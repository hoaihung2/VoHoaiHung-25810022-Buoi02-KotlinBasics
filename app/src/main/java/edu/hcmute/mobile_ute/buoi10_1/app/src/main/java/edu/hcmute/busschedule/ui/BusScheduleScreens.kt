package edu.hcmute.busschedule.ui

import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import edu.hcmute.busschedule.data.Schedule
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun BusScheduleApp(
    viewModel: BusScheduleViewModel = viewModel(factory = BusScheduleViewModel.factory)
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "list") {
        composable("list") {
            val schedules by viewModel.fullSchedule().collectAsState(emptyList())
            ScheduleScreen(
                title = "Bus Schedule",
                schedules = schedules,
                showStopName = true,
                onItemClick = { stop -> navController.navigate("detail/${Uri.encode(stop)}") }
            )
        }
        composable(
            route = "detail/{stopName}",
            arguments = listOf(navArgument("stopName") { type = NavType.StringType })
        ) { entry ->
            val stopName = entry.arguments?.getString("stopName") ?: ""
            val schedules by viewModel.scheduleForStopName(stopName).collectAsState(emptyList())
            ScheduleScreen(
                title = stopName,
                schedules = schedules,
                showStopName = false,
                onItemClick = {}
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen(
    title: String,
    schedules: List<Schedule>,
    showStopName: Boolean,
    onItemClick: (String) -> Unit
) {
    Scaffold(topBar = { TopAppBar(title = { Text(title) }) }) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            items(schedules) { item ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(item.stopName) }
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(if (showStopName) item.stopName else "Arrival time")
                    Text(formatTime(item.arrivalTime))
                }
                HorizontalDivider()
            }
        }
    }
}

private fun formatTime(seconds: Int): String =
    SimpleDateFormat("h:mm a", Locale.getDefault()).format(Date(seconds.toLong() * 1000))
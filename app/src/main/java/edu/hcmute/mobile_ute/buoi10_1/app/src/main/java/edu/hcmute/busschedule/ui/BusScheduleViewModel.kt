package edu.hcmute.busschedule.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import edu.hcmute.busschedule.BusScheduleApplication
import edu.hcmute.busschedule.data.Schedule
import edu.hcmute.busschedule.data.ScheduleDao
import kotlinx.coroutines.flow.Flow

class BusScheduleViewModel(private val dao: ScheduleDao) : ViewModel() {

    fun fullSchedule(): Flow<List<Schedule>> = dao.getAll()

    fun scheduleForStopName(name: String): Flow<List<Schedule>> = dao.getByStopName(name)

    companion object {
        val factory = viewModelFactory {
            initializer {
                val app = this[APPLICATION_KEY] as BusScheduleApplication
                BusScheduleViewModel(app.database.scheduleDao())
            }
        }
    }
}
package edu.hcmute.marsphotos

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade

@Composable
fun MarsScreen(marsViewModel: MarsViewModel = viewModel(factory = MarsViewModel.Factory)) {
    val uiState by marsViewModel.uiState.collectAsState()
    when (val state = uiState) {
        is MarsUiState.Loading -> Box(Modifier.fillMaxSize(), Alignment.Center) {
            CircularProgressIndicator()
        }
        is MarsUiState.Error -> Box(Modifier.fillMaxSize(), Alignment.Center) {
            Button(onClick = { marsViewModel.getMarsPhotos() }) { Text("Retry") }
        }
        is MarsUiState.Success -> PhotosGrid(state.photos)
    }
}

@Composable
fun PhotosGrid(photos: List<MarsPhoto>) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(150.dp),
        contentPadding = PaddingValues(4.dp),
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.padding(top = 32.dp)
    ) {
        items(photos, key = { it.id }) { photo ->
            MarsPhotoCard(photo)
        }
    }
}

@Composable
fun MarsPhotoCard(photo: MarsPhoto) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(photo.imgSrc)
            .crossfade(true)
            .build(),
        contentDescription = "Mars photo ${photo.id}",
        placeholder = painterResource(R.drawable.loading_img),
        error = painterResource(R.drawable.ic_broken_image),
        contentScale = ContentScale.Crop,
        modifier = Modifier.aspectRatio(1f)
    )
}
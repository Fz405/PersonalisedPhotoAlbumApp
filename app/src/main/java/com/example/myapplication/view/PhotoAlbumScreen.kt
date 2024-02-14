package com.example.myapplication.view
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.viewmodel.PhotoAlbumViewModel


@Composable
fun PhotoAlbumScreen(photoAlbumViewModel: PhotoAlbumViewModel = viewModel()) {
    Column {
        Text(text = "Personalized Photo Album")
        Button(onClick = { photoAlbumViewModel.fetchAlbums() }) {
            Text("Load Photos")
        }
        // This is where you would display your photos, e.g., in a LazyColumn
    }
}

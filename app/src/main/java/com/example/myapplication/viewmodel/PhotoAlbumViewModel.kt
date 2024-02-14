package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.Album

// ViewModel
class PhotoAlbumViewModel : ViewModel() {
    // LiveData holding the list of albums
    val albums = MutableLiveData<List<Album>>(listOf())

    // Function to fetch albums (could be from a repository)
    fun fetchAlbums() {
        // This would be replaced with actual data fetching logic
        albums.value = listOf(
            Album("1", "Vacation"),
            Album("2", "Family"),
            Album("3", "Friends")
        )
    }
}
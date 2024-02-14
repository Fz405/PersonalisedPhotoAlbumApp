import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R
import com.example.myapplication.model.Album


// ViewModel
class PhotoAlbumViewModel : ViewModel() {
    // Using MutableState to hold the list of albums
    var albums by mutableStateOf(listOf<Album>())

    // Function to fetch albums (could be from a repository)
    fun fetchAlbums() {
        // This would be replaced with actual data fetching logic
        albums = listOf(
            Album("1", "Vacation"),
            Album("2", "Family"),
            Album("3", "Friends")
        )
    }
}

// UI layer with Composables
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlbumsScreen(viewModel: PhotoAlbumViewModel = viewModel()) {
    val albums = viewModel.albums

    // Fetch albums when the screen is first composed
    LaunchedEffect(key1 = true) {
        viewModel.fetchAlbums()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Albums") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Navigate to create new album screen */ }) {
                Icon(ImageVector.vectorResource(id = androidx.core.R.drawable.ic_call_answer), contentDescription = "Add Album")
            }
        }
    ) { innerPadding ->
        AlbumList(albums, Modifier.padding(innerPadding))
    }
}

@Composable
fun AlbumList(albums: List<Album>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(albums) { album ->
            AlbumListItem(album)
        }
    }
}

@Composable
fun AlbumListItem(album: Album) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { /* TODO: Handle album click */ },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = album.title,
            style = MaterialTheme.typography.headlineMedium,
            fontStyle = FontStyle.Italic,
            fontWeight = FontWeight.ExtraBold,
            color= Color.Red,
            fontSize = 36.sp
                )

            // Additional album details here
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AlbumsScreenPreview() {
    AlbumsScreen()
}

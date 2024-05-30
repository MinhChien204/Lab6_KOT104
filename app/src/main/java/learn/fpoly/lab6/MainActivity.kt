package learn.fpoly.lab6

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.rememberLazyStaggeredGridState
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter

class MainActivity: ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                MainScreen()
            }
        }
    }
}

val sampleMovies = listOf(
    Movie("Dune: Hành Tinh Cát - Phần Hai", "187'", "29/02/2024", "Hành Động, Khoa Học Viễn Tưởng", "https://ca-times.brightspotcdn.com/dims4/default/9bacbe7/2147483647/strip/true/crop/5007x2420+0+0/resize/1200x580!/quality/75/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F60%2Ffa%2F34b8687b4dc8902a6a81159e873f%2Fla-en-dune-movie-one-shot-040.JPG"),
    Movie("Mai", "145'", "01/03/2024", "Tâm Lý, Tình Cảm", "https://cinema.momocdn.net/img/30196263872528348-thumb.jpg"),
    Movie("Dune: Hành Tinh Cát - Phần Hai", "187'", "29/02/2024", "Hành Động, Khoa Học Viễn Tưởng", "https://ca-times.brightspotcdn.com/dims4/default/9bacbe7/2147483647/strip/true/crop/5007x2420+0+0/resize/1200x580!/quality/75/?url=https%3A%2F%2Fcalifornia-times-brightspot.s3.amazonaws.com%2F60%2Ffa%2F34b8687b4dc8902a6a81159e873f%2Fla-en-dune-movie-one-shot-040.JPG"),
    Movie("Mai", "145'", "01/03/2024", "Tâm Lý, Tình Cảm", "https://cinema.momocdn.net/img/30196263872528348-thumb.jpg"),
    )

@Composable
fun MovieCard(movie: Movie) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = rememberImagePainter(movie.img),
                contentDescription = null,
                modifier = Modifier
                    .height(180.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = movie.title, style = MaterialTheme.typography.h6)
            Text(text = "Thời lượng: ${movie.duration}", style = MaterialTheme.typography.body2)
            Text(text = "Khởi chiếu: ${movie.date}", style = MaterialTheme.typography.body2)
            Text(text = "Thể loại: ${movie.genre}", style = MaterialTheme.typography.body2)
        }
    }
}

@Composable
fun MovieListRow(movies: List<Movie>) {
    LazyRow {
        items(movies) { movie ->
            MovieCard(movie)
        }
    }
}

@Composable
fun MovieListColumn(movies: List<Movie>) {
    LazyColumn {
        items(movies) { movie ->
            MovieCard(movie)
        }
    }
}

@Composable
fun MovieGrid(movies: List<Movie>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(8.dp)
    ) {
        items(movies) { movie ->
            MovieCard(movie)
        }
    }
}

@Preview
@Composable
fun MainScreen() {
    var viewMode by remember { mutableStateOf("row") }

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(onClick = { viewMode = "row" }) {
                Text("Hàng")
            }
            Button(onClick = { viewMode = "column" }) {
                Text("Cột")
            }
            Button(onClick = { viewMode = "grid" }) {
                Text("Lưới")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (viewMode) {
            "row" -> MovieListRow(movies = sampleMovies)
            "column" -> MovieListColumn(movies = sampleMovies)
            "grid" -> MovieGrid(movies = sampleMovies)
        }
    }
}

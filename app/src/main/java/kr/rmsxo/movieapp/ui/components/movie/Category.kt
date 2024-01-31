package kr.rmsxo.movieapp.ui.components.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kr.rmsxo.movieapp.ui.theme.MovieAppTheme
import kr.rmsxo.movieapp.ui.theme.Paddings
import kr.rmsxo.movieapp.ui.theme.h5Title

@Composable
fun CategoryRow() {
    Column() {
        CategoryTitle( "Action")

        // 리사이클러 뷰 같은거
        LazyRow(
            contentPadding = PaddingValues(
                horizontal = Paddings.large
            )
        ) {
            item {
                MovieItem()
            }
            item {
                MovieItem()
            }
            item {
                MovieItem()
            }
            item {
                MovieItem()
            }
        }
    }
}

@Composable
fun CategoryTitle(titleName: String) {
    Text(
        text = "Action",
        modifier = Modifier
            .padding(
                vertical = Paddings.large,
                horizontal = Paddings.extra
            ),
        style = MaterialTheme.typography.headlineSmall
    )
}

@Preview
@Composable
fun CategoryRowPreview() {
    MovieAppTheme {
        CategoryRow()
    }
}



















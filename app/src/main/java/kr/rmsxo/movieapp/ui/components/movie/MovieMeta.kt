package kr.rmsxo.movieapp.ui.components.movie

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import kr.rmsxo.movieapp.ui.theme.Paddings
import kr.rmsxo.movieapp.ui.theme.colorScheme
import kr.rmsxo.movieapp.ui.theme.h5Title
import kr.rmsxo.movieapp.ui.util.getAnnotatedText

@Composable
fun MovieMeta(
    modifier: Modifier = Modifier,
    key: String,
    value: String
) {
    Column(modifier = modifier) {
        // Key
        Text(
            text = key,
            style = MaterialTheme.typography.h5Title,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
        )

        // Value
        Text(
            text = getAnnotatedText(text = value),
            style = MaterialTheme.typography.labelLarge
        )

        Spacer(modifier = Modifier.height(Paddings.large))
    }
}
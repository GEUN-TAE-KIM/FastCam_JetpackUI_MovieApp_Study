package kr.rmsxo.movieapp.ui.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import kr.rmsxo.movieapp.ui.components.dialog.components.button.DialogButtonColumn
import kr.rmsxo.movieapp.ui.components.dialog.components.content.DialogContentWrapper
import kr.rmsxo.movieapp.ui.components.dialog.components.title.DialogTitleWrapper
import kr.rmsxo.movieapp.ui.models.dialog.DialogButton
import kr.rmsxo.movieapp.ui.models.dialog.DialogContent
import kr.rmsxo.movieapp.ui.models.dialog.DialogText
import kr.rmsxo.movieapp.ui.models.dialog.DialogTitle
import kr.rmsxo.movieapp.ui.theme.MovieAppTheme
import kr.rmsxo.movieapp.ui.theme.Paddings

@Composable
fun BaseDialog(
    dialogTitle: DialogTitle? = null,
    dialogContent: DialogContent? = null,
    buttons: List<DialogButton>? = null
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(Paddings.none),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.background),
        shape = MaterialTheme.shapes.large
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            dialogTitle?.let {
                DialogTitleWrapper(it)
            }
            Column(
                modifier = Modifier
                    .background(Color.Transparent)
                    .fillMaxWidth()
                    .padding(
                        start = Paddings.xlarge,
                        end = Paddings.xlarge,
                        bottom = Paddings.xlarge
                    )
            ) {
                dialogContent?.let { DialogContentWrapper(it) }
                buttons?.let { DialogButtonColumn(it) }
            }
        }

    }
}

@Preview
@Composable
fun BaseDialogPreview() {
    MovieAppTheme {
        BaseDialog(
            dialogTitle = DialogTitle.Header("TITLE"),
            dialogContent =  DialogContent.Large(
                DialogText.Default("qweqw qweqwe qweqw qweqwe qwe qwe qwe qw eqw eqw eqw eq eqw ")
            ),
            buttons = listOf(
                DialogButton.Primary("Okay") {

                }
            )
        )
    }
}

@Preview
@Composable
fun BaseDialog2Preview() {
    MovieAppTheme {
        BaseDialog(
            dialogTitle = DialogTitle.Large("TITLE"),
            dialogContent =  DialogContent.Default(
                DialogText.Default("qweqw qweqwe qweqw qweqwe qwe qwe qwe qw eqw eqw eqw eq eqw ")
            ),
            buttons = listOf(
                DialogButton.Secondary("Okay") {},
                DialogButton.UnderlinedText("Cancel") {}
            )
        )
    }
}

@Preview
@Composable
fun BaseDialogRatingPreview() {
    MovieAppTheme {
        BaseDialog(
            dialogTitle = DialogTitle.Large("TITLE"),
            dialogContent =  DialogContent.Rating(
                DialogText.Rating (
                    text = "par",
                    rating = 8.2f
                )
            ),
            buttons = listOf(
                DialogButton.Primary("Okay") {},
                DialogButton.Secondary("Cancel") {}
            )
        )
    }
}

















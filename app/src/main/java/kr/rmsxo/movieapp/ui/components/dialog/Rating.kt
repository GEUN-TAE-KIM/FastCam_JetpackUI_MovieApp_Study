package kr.rmsxo.movieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import kr.rmsxo.movieapp.ui.models.dialog.DialogButton
import kr.rmsxo.movieapp.ui.models.dialog.DialogContent
import kr.rmsxo.movieapp.ui.models.dialog.DialogText
import kr.rmsxo.movieapp.ui.models.dialog.DialogTitle

@Composable
fun DialogPopup.Rating(
    movieName: String,
    rating: Float,
    buttons: List<DialogButton>
) {
    BaseDialog(
        dialogTitle = DialogTitle.Large("Rate your Score"),
        dialogContent =  DialogContent.Rating(
            DialogText.Rating (
                text = movieName,
                rating = rating
            )
        ),
        buttons = buttons
    )
}
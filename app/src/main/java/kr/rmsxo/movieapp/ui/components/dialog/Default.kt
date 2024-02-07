package kr.rmsxo.movieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import kr.rmsxo.movieapp.ui.models.dialog.DialogButton
import kr.rmsxo.movieapp.ui.models.dialog.DialogContent
import kr.rmsxo.movieapp.ui.models.dialog.DialogText
import kr.rmsxo.movieapp.ui.models.dialog.DialogTitle

object DialogPopup

@Composable
fun DialogPopup.Default (
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialog(
        dialogTitle = DialogTitle.Default(title),
        dialogContent =  DialogContent.Default(
            DialogText.Default(bodyText)
        ),
        buttons = buttons
        )
}
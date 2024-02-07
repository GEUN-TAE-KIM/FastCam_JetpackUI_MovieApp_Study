package kr.rmsxo.movieapp.ui.components.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import kr.rmsxo.movieapp.R
import kr.rmsxo.movieapp.ui.models.dialog.DialogButton
import kr.rmsxo.movieapp.ui.models.dialog.DialogContent
import kr.rmsxo.movieapp.ui.models.dialog.DialogText
import kr.rmsxo.movieapp.ui.models.dialog.DialogTitle

@Composable
fun DialogPopup.Alert(
    title: String,
    bodyText: String,
    buttons: List<DialogButton>
) {
    BaseDialog(
        dialogTitle = DialogTitle.Header(
            title
        ),
        dialogContent =  DialogContent.Large(
            DialogText.Default(bodyText)
        ),
        buttons = buttons
    )
}
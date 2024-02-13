package kr.rmsxo.movieapp.features.dialogs

import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.stringResource
import dagger.hilt.android.AndroidEntryPoint
import kr.rmsxo.movieapp.BaseDialogFragment
import kr.rmsxo.movieapp.R
import kr.rmsxo.movieapp.ui.components.dialog.Alert
import kr.rmsxo.movieapp.ui.components.dialog.DialogPopup
import kr.rmsxo.movieapp.ui.models.dialog.DialogButton
import kr.rmsxo.movieapp.ui.theme.MovieAppTheme

@AndroidEntryPoint
class InfoDialogFragment : BaseDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog?.apply {
            isCancelable = true
            setCanceledOnTouchOutside(true)
            window?.setBackgroundDrawable(ColorDrawable(requireContext().getColor(android.R.color.transparent)))
        }

        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                MovieAppTheme(
                    themeState = themeViewModel.themeState.collectAsState()
                ) {
                    DialogPopup.Alert(
                        title = stringResource(R.string.app_name),
                        bodyText = stringResource(R.string.info_message),
                        buttons = listOf(
                            DialogButton.UnderlinedText(getString(R.string.close)) {
                                dismiss()
                            }
                        )
                    )
                }
            }
        }
    }
}
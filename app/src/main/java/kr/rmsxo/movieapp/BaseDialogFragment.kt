package kr.rmsxo.movieapp

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import kr.rmsxo.movieapp.features.common.viewmodel.ThemeViewModel

open class BaseDialogFragment : DialogFragment() {
    protected val themeViewModel: ThemeViewModel by activityViewModels()
}
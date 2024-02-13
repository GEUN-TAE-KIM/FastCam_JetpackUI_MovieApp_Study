package kr.rmsxo.movieapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kr.rmsxo.movieapp.features.common.viewmodel.ThemeViewModel

open class BaseFragment : Fragment() {
    protected val themeViewModel: ThemeViewModel by activityViewModels()
}
package kr.rmsxo.movieapp.features.feed.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kr.rmsxo.movieapp.features.common.entity.EntityWrapper
import kr.rmsxo.movieapp.features.feed.domain.usecase.IGetFeedCategoryUseCase
import kr.rmsxo.movieapp.features.feed.presentation.input.IFeedViewModelInput
import kr.rmsxo.movieapp.features.feed.presentation.output.FeedState
import kr.rmsxo.movieapp.features.feed.presentation.output.FeedUiEffect
import kr.rmsxo.movieapp.features.feed.presentation.output.IFeedViewModelOutput
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val getFeedCategoryUseCase: IGetFeedCategoryUseCase
): ViewModel(), IFeedViewModelOutput, IFeedViewModelInput {

    // 화면에 보여 주기 위한 Flow
    private val _feedState: MutableStateFlow<FeedState> =
        MutableStateFlow(FeedState.Loading)
    override val feedState: StateFlow<FeedState>
        get() = _feedState

    // 유저로 부터 입력을 받아서 Fragment 단에서 액션을 수행 하기 위한 flow
    private val _feedUiEffect = MutableSharedFlow<FeedUiEffect>(replay = 0)
    override val feedUiEffect: SharedFlow<FeedUiEffect>
        get() = _feedUiEffect

    init {
        fetchFeed()
    }

    private fun fetchFeed() {
        viewModelScope.launch {
            _feedState.value = FeedState.Loading

            val categories = getFeedCategoryUseCase()
            _feedState.value = when(categories) {
                is EntityWrapper.Success -> {
                    FeedState.Main(
                        categories = categories.entity
                    )
                }
                is EntityWrapper.Fail -> {
                    FeedState.Failed(
                        reason = categories.error.message ?: "Unk error"
                    )
                }
            }
        }
    }

    override fun openDetail(movieName: String) {
        TODO("Not yet implemented")
    }

    override fun openInfoDialog() {
        TODO("Not yet implemented")
    }

    override fun refreshFeed() {
        TODO("Not yet implemented")
    }

}
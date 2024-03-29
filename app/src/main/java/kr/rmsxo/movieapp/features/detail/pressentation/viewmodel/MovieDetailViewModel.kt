package kr.rmsxo.movieapp.features.detail.pressentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kr.rmsxo.movieapp.features.detail.domain.usecase.IGetMovieDetailUseCase
import kr.rmsxo.movieapp.features.detail.pressentation.input.IDetailViewModelInputs
import kr.rmsxo.movieapp.features.detail.pressentation.output.DetailUiEffect
import kr.rmsxo.movieapp.features.detail.pressentation.output.IDetailViewModelOutputs
import kr.rmsxo.movieapp.features.detail.pressentation.output.MovieDetailState
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: IGetMovieDetailUseCase
) : ViewModel(), IDetailViewModelInputs, IDetailViewModelOutputs {

    val inputs: IDetailViewModelInputs = this
    val outputs: IDetailViewModelOutputs = this

    private val _detailState: MutableStateFlow<MovieDetailState> =
        MutableStateFlow(MovieDetailState.Initial)
    override val detailState: StateFlow<MovieDetailState>
        get() = _detailState

    private val _detailUiEffect = MutableSharedFlow<DetailUiEffect>(replay = 0)
    override val detailUiEffect: SharedFlow<DetailUiEffect>
        get() = _detailUiEffect

    suspend fun initMovieName(movieName: String) {
        _detailState.value = MovieDetailState.Main(
            movieDetailEntity = getMovieDetailUseCase(movieName)
        )
    }

    override fun goBackToFeed() {
        viewModelScope.launch {
            _detailUiEffect.emit(
                DetailUiEffect.Back
            )
        }
    }

    override fun openImdbClicked() {
        viewModelScope.launch {
            if (detailState.value is MovieDetailState.Main) {
                val value = detailState.value as MovieDetailState.Main
                _detailUiEffect.emit(
                    DetailUiEffect.OpenUrl(
                        value.movieDetailEntity.imdbPath
                    )
                )
            }
        }
    }

    override fun rateClicked() {
        viewModelScope.launch {
            if (detailState.value is MovieDetailState.Main) {
                val value = detailState.value as MovieDetailState.Main
                _detailUiEffect.emit(
                    DetailUiEffect.RateMovie(
                        movieTitle = value.movieDetailEntity.title,
                        rating = value.movieDetailEntity.rating
                    )
                )
            }
        }
    }
}
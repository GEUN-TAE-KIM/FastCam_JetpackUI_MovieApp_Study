package kr.rmsxo.movieapp.features.detail.domain.usecase

import kr.rmsxo.movieapp.features.common.entity.MovieDetailEntity

interface IGetMovieDetailUseCase {
    suspend operator fun invoke(name: String): MovieDetailEntity
}
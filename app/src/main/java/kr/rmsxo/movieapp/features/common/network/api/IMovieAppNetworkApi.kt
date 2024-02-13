package kr.rmsxo.movieapp.features.common.network.api

import kr.rmsxo.movieapp.features.common.network.model.MovieResponse
import kr.rmsxo.movieapp.library.network.model.ApiResult

interface IMovieAppNetworkApi {
    suspend fun getMovies(): ApiResult<List<MovieResponse>>
}
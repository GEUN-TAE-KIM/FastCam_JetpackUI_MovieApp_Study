package kr.rmsxo.movieapp.features.common.repository

import kr.rmsxo.movieapp.features.common.network.api.IMovieAppNetworkApi
import kr.rmsxo.movieapp.library.network.model.ApiResponse
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieNetworkApi : IMovieAppNetworkApi
) : IMovieDataSource {

    override suspend fun getMovieList() {
        val data = movieNetworkApi.getMovies().response
        if (data is ApiResponse.Success) {
            val movieList = data.data
        }
    }
}
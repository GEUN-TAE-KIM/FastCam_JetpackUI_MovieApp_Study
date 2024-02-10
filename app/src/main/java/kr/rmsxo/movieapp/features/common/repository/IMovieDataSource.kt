package kr.rmsxo.movieapp.features.common.repository

interface IMovieDataSource {
    suspend fun getMovieList()
}
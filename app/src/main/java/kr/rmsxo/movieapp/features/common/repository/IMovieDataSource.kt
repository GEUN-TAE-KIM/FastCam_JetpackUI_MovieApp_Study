package kr.rmsxo.movieapp.features.common.repository

import kr.rmsxo.movieapp.features.common.entity.CategoryEntity
import kr.rmsxo.movieapp.features.common.entity.EntityWrapper
import kr.rmsxo.movieapp.features.common.entity.MovieDetailEntity
import kr.rmsxo.movieapp.features.feed.domain.enum.SortOrder

interface IMovieDataSource {
    suspend fun getCategories(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>
    suspend fun getMovieDetail(movieName: String): MovieDetailEntity
}
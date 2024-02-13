package kr.rmsxo.movieapp.features.feed.domain.usecase

import kr.rmsxo.movieapp.features.common.entity.CategoryEntity
import kr.rmsxo.movieapp.features.common.entity.EntityWrapper
import kr.rmsxo.movieapp.features.common.repository.IMovieDataSource
import kr.rmsxo.movieapp.features.feed.domain.enum.SortOrder
import javax.inject.Inject

class GetFeedCategoryUseCase @Inject constructor(
    private val dataSource: IMovieDataSource
) : IGetFeedCategoryUseCase {
    override suspend fun invoke(sortOrder: SortOrder?): EntityWrapper<List<CategoryEntity>> {
        return dataSource.getCategories(sortOrder)
    }
}
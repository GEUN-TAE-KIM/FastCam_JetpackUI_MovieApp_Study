package kr.rmsxo.movieapp.features.feed.domain.usecase

import kr.rmsxo.movieapp.features.common.entity.CategoryEntity
import kr.rmsxo.movieapp.features.common.entity.EntityWrapper
import kr.rmsxo.movieapp.features.feed.domain.enum.SortOrder

interface IGetFeedCategoryUseCase {
    suspend operator fun invoke(sortOrder: SortOrder? = null): EntityWrapper<List<CategoryEntity>>
}
package kr.rmsxo.movieapp.features.feed.presentation.output

import kr.rmsxo.movieapp.features.common.entity.CategoryEntity

sealed class FeedState {
    data object Loading: FeedState()
    class Main(
        val categories: List<CategoryEntity>
    ) : FeedState()
    class Failed(
        val reason: String
    ): FeedState()
}

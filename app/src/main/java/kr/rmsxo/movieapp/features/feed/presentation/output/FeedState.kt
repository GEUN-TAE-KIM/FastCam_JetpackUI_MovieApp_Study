package kr.rmsxo.movieapp.features.feed.presentation.output

sealed class FeedState {
    data object Loading: FeedState()
    class Main(
        val movielist: List<MovieFeedItemEntity>
    ) : FeedState()
    class Failed(
        val reason: String
    ): FeedState()
}

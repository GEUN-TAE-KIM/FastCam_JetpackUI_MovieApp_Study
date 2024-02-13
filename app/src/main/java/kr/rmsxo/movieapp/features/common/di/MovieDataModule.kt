package kr.rmsxo.movieapp.features.common.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.rmsxo.movieapp.features.common.network.api.IMovieAppNetworkApi
import kr.rmsxo.movieapp.features.common.network.api.MovieAppNetworkApi
import kr.rmsxo.movieapp.features.common.repository.IMovieDataSource
import kr.rmsxo.movieapp.features.common.repository.MovieRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class MovieDataModule {

    @Singleton
    @Binds
    abstract fun bindMovieRepository(movieRepository: MovieRepository): IMovieDataSource

    @Singleton
    @Binds
    abstract fun bindNetwork(networkApi: MovieAppNetworkApi): IMovieAppNetworkApi

}

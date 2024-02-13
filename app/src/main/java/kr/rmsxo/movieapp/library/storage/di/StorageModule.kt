package kr.rmsxo.movieapp.library.storage.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kr.rmsxo.movieapp.library.storage.IStorage
import kr.rmsxo.movieapp.library.storage.StorageManager
import kr.rmsxo.movieapp.library.storage.helpers.DataConverter
import kr.rmsxo.movieapp.library.storage.helpers.DataEncoding
import kr.rmsxo.movieapp.library.storage.prefs.SharedPrefsStorageProvider
import kr.rmsxo.movieapp.library.storage.prefs.StorageProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class StorageModule {

    @Singleton
    @Provides
    fun bindOnDiscStorage(
        storage: StorageProvider,
        converter: DataConverter,
        encoding: DataEncoding
    ): IStorage = StorageManager(storage, converter, encoding)

    @Provides
    fun provideSharePrefStorageProvider(provider: SharedPrefsStorageProvider): StorageProvider =
        provider

}
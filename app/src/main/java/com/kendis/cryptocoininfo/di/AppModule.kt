package com.kendis.cryptocoininfo.di

import com.kendis.cryptocoininfo.common.Constants
import com.kendis.cryptocoininfo.data.remote.CryptoCoinApi
import com.kendis.cryptocoininfo.data.repository.CoinRepositoryImpl
import com.kendis.cryptocoininfo.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideRetrofit(): CryptoCoinApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CryptoCoinApi::class.java)
    }

    @Provides
    fun provideCoinRepository(api: CryptoCoinApi): CoinRepository {
        return CoinRepositoryImpl(api)
    }
}
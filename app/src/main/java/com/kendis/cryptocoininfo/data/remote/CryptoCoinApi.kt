package com.kendis.cryptocoininfo.data.remote

import com.kendis.cryptocoininfo.data.remote.dto.CoinDetailDto
import com.kendis.cryptocoininfo.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CryptoCoinApi {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}

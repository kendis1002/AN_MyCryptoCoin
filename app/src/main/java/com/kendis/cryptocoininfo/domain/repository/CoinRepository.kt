package com.kendis.cryptocoininfo.domain.repository

import com.kendis.cryptocoininfo.data.remote.dto.CoinDetailDto
import com.kendis.cryptocoininfo.data.remote.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailDto
}

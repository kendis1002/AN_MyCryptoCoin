package com.kendis.cryptocoininfo.data.repository

import com.kendis.cryptocoininfo.data.remote.CryptoCoinApi
import com.kendis.cryptocoininfo.data.remote.dto.CoinDetailDto
import com.kendis.cryptocoininfo.data.remote.dto.CoinDto
import com.kendis.cryptocoininfo.domain.repository.CoinRepository

class CoinRepositoryImpl(val api: CryptoCoinApi) : CoinRepository {

    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailDto {
        return api.getCoinById(coinId)
    }
}

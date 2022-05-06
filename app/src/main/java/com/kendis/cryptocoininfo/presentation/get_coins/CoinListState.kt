package com.kendis.cryptocoininfo.presentation.get_coins

import com.kendis.cryptocoininfo.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
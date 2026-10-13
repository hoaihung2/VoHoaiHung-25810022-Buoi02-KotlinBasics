package edu.hcmute.unscramble.ui

import androidx.annotation.DrawableRes
import edu.hcmute.unscramble.data.Datasource

data class DessertUiState(
    val revenue: Int = 0,
    val dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0,
    val currentDessertPrice: Int = Datasource.dessertList[0].price,
    @DrawableRes val currentDessertImageId: Int = Datasource.dessertList[0].imageId
)
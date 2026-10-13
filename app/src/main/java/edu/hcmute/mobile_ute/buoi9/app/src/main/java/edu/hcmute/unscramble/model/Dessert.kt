package edu.hcmute.unscramble.model

import androidx.annotation.DrawableRes

data class Dessert(
    @DrawableRes val imageId: Int,
    val price: Int,
    val startProductionAmount: Int
)
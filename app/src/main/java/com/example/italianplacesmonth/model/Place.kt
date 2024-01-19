package com.example.italianplacesmonth.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Place(
    @StringRes val title: Int,
    @StringRes val city: Int,
    @StringRes val region: Int,
    @StringRes val year: Int,
    @DrawableRes val image: Int
)

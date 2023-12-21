package com.example.wapookt.domain.toilet.presentaion.dto.request

import com.example.wapookt.domain.toilet.enums.Floor
import com.example.wapookt.domain.toilet.enums.Gender
import com.example.wapookt.domain.toilet.enums.Location

data class LocationRegisterRequest(

    val location: Location,
    val floor: Floor,
    val gender: Gender,
    val position: Int,
    val state:Boolean
)
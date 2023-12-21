package com.example.wapookt.domain.toilet.presentaion.dto.response

import com.example.wapookt.domain.toilet.enums.Gender


data class LocationGetsResponse(
    val gender: Gender,
    val position: Int,
    val state: Boolean
)
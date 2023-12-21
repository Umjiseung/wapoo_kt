package com.example.wapookt.domain.toilet.presentaion.dto.request

data class LocationUpdateRequest(
    val id:Long,
    val position: Int,
    val state: Boolean
)
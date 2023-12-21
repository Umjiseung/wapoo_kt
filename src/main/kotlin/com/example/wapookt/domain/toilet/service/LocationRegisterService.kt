package com.example.wapookt.domain.toilet.service

import com.example.wapookt.domain.toilet.entity.Toilet
import com.example.wapookt.domain.toilet.presentaion.dto.request.LocationRegisterRequest
import com.example.wapookt.domain.toilet.repository.ToiletRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LocationRegisterService(
    private val toiletRepository: ToiletRepository
) {
    @Transactional
    fun execute(locationRegisterRequest: LocationRegisterRequest) {
        val toilet = Toilet(
            location = locationRegisterRequest.location,
            floor = locationRegisterRequest.floor,
            gender = locationRegisterRequest.gender,
            position = locationRegisterRequest.position,
            state = locationRegisterRequest.state
        )
        toiletRepository.save(toilet)
    }
}
package com.example.wapookt.domain.toilet.service

import com.example.wapookt.domain.toilet.presentaion.dto.request.LocationUpdateRequest
import com.example.wapookt.domain.toilet.repository.ToiletRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LocationUpdateService(
    private val toiletRepository: ToiletRepository
) {
    @Transactional(rollbackFor = [Exception::class])
    fun execute(locationUpdateRequest: LocationUpdateRequest) {
        val toilet = toiletRepository.findByIdAndPosition(locationUpdateRequest.id, locationUpdateRequest.position)
        toilet.update(locationUpdateRequest.state)
    }
}
package com.example.wapookt.domain.toilet.service

import com.example.wapookt.domain.toilet.enums.Floor
import com.example.wapookt.domain.toilet.enums.Location
import com.example.wapookt.domain.toilet.presentaion.dto.response.LocationGetsResponse
import com.example.wapookt.domain.toilet.repository.ToiletRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class LocationGetsService(
    private val toiletRepository: ToiletRepository
) {
    @Transactional(readOnly = true)
    fun execute(location: Location, floor: Floor): List<LocationGetsResponse> {
        val toilets = toiletRepository.findByLocationAndFloor(location, floor)
        val responses: MutableList<LocationGetsResponse> = mutableListOf()

        for (toilet in toilets) {
            responses.add(LocationGetsResponse(
                toilet.gender,
                toilet.position,
                toilet.state
            ))
        }
        return responses
    }
}
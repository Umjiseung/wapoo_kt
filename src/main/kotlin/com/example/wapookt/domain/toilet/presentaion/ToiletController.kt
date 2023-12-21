package com.example.wapookt.domain.toilet.presentaion

import com.example.wapookt.domain.toilet.enums.Floor
import com.example.wapookt.domain.toilet.enums.Location
import com.example.wapookt.domain.toilet.presentaion.dto.request.LocationRegisterRequest
import com.example.wapookt.domain.toilet.presentaion.dto.request.LocationUpdateRequest
import com.example.wapookt.domain.toilet.presentaion.dto.response.LocationGetsResponse
import com.example.wapookt.domain.toilet.service.LocationGetsService
import com.example.wapookt.domain.toilet.service.LocationRegisterService
import com.example.wapookt.domain.toilet.service.LocationUpdateService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/toilet")
class ToiletController(
    private val locationRegisterService: LocationRegisterService,
    private val locationGetsService: LocationGetsService,
    private val locationUpdateService: LocationUpdateService
) {

    @PostMapping
    fun locationRegister(@RequestBody locationRegisterRequest: LocationRegisterRequest): ResponseEntity<Void> {
        locationRegisterService.execute(locationRegisterRequest)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping("/{location}/{floor}")
    fun locationGets(@PathVariable location: Location, @PathVariable floor: Floor): ResponseEntity<List<LocationGetsResponse>> {
        val result = locationGetsService.execute(location,floor)
        return ResponseEntity.ok(result)
    }

    @PatchMapping
    fun locationUpdate(@RequestBody locationUpdateRequest: LocationUpdateRequest): ResponseEntity<Void> {
        locationUpdateService.execute(locationUpdateRequest)
        return ResponseEntity(HttpStatus.OK)
    }

}
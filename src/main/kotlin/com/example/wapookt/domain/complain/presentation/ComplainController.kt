package com.example.wapookt.domain.complain.presentation

import com.example.wapookt.domain.complain.presentation.dto.ComplainGetsDto
import com.example.wapookt.domain.complain.presentation.dto.ComplainRegisterDto
import com.example.wapookt.domain.complain.service.ComplainGetsService
import com.example.wapookt.domain.complain.service.ComplainRegisterService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/complain")
@CrossOrigin
class ComplainController(
    private val complainRegisterService: ComplainRegisterService,
    private val complainGetsService: ComplainGetsService
) {

    @PostMapping
    fun complainRegister(@RequestBody complainRegisterDto: ComplainRegisterDto): ResponseEntity<Void> {
        complainRegisterService.execute(complainRegisterDto)
        return ResponseEntity(HttpStatus.CREATED)
    }

    @GetMapping
    fun complainGets(): ResponseEntity<List<ComplainGetsDto>> {
        val result = complainGetsService.execute()
        return ResponseEntity.ok(result)
    }


}
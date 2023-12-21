package com.example.wapookt.domain.complain.service

import com.example.wapookt.domain.complain.presentation.dto.ComplainGetsDto
import com.example.wapookt.domain.complain.repository.ComplainRepository
import org.springframework.stereotype.Service

@Service
class ComplainGetsService(
    private val complainRepository: ComplainRepository
) {

    fun execute(): List<ComplainGetsDto> {
        val complains = complainRepository.findAll()
        val responses: MutableList<ComplainGetsDto> = mutableListOf()

        for (complain in complains) {
            responses.add(
                ComplainGetsDto(
                complain.id,
                complain.title,
                complain.time
            )
            )
        }
        return responses
    }

}
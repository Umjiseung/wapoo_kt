package com.example.wapookt.domain.complain.service

import com.example.wapookt.domain.complain.entity.Complain
import com.example.wapookt.domain.complain.presentation.dto.ComplainRegisterDto
import com.example.wapookt.domain.complain.repository.ComplainRepository
import org.springframework.stereotype.Service
import java.text.SimpleDateFormat
import java.util.*

@Service
class ComplainRegisterService(
    private val complainRepository: ComplainRepository
) {

    fun execute(complainRegisterDto: ComplainRegisterDto) {
        val dateFormat = SimpleDateFormat("yyyyMMdd")
        val time = Date()
        val result: String = dateFormat.format(time)
        val complain = Complain(
            title = complainRegisterDto.title,
            time = result
        )
        complainRepository.save(complain)
    }

}
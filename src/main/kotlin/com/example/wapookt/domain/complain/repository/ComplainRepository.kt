package com.example.wapookt.domain.complain.repository

import com.example.wapookt.domain.complain.entity.Complain
import org.springframework.data.jpa.repository.JpaRepository

interface ComplainRepository: JpaRepository<Complain,Long> {
}
package com.example.wapookt.domain.toilet.repository

import com.example.wapookt.domain.toilet.entity.Toilet
import com.example.wapookt.domain.toilet.enums.Floor
import com.example.wapookt.domain.toilet.enums.Location
import org.springframework.data.jpa.repository.JpaRepository

interface ToiletRepository: JpaRepository<Toilet,Long> {
    fun findByLocationAndFloor(location: Location,floor: Floor): List<Toilet>
    fun findByIdAndPosition(id: Long, position: Int): Toilet
}
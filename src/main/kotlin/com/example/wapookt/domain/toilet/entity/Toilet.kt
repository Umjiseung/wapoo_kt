package com.example.wapookt.domain.toilet.entity

import com.example.wapookt.domain.toilet.enums.Floor
import com.example.wapookt.domain.toilet.enums.Gender
import com.example.wapookt.domain.toilet.enums.Location
import jakarta.persistence.*

@Entity
class Toilet (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "toilet_state", nullable = false)
    var state: Boolean,

    @Column(name = "toilet_position")
    val position: Int,

    @Column(name = "toilet_location", nullable = false)
    @Enumerated(EnumType.STRING)
    val location: Location,

    @Column(name = "toilet_floor", nullable = false)
    @Enumerated(EnumType.STRING)
    val floor: Floor,

    @Column(name = "toilet_gender", nullable = false)
    @Enumerated(EnumType.STRING)
    val gender: Gender
){
    fun update(state: Boolean) {
        this.state = state
    }
}
package com.example.aidrawingdiary.entity

import com.example.aidrawingdiary.dto.DiaryRequest
import jakarta.persistence.*
import java.time.LocalDate

@Entity
class DiaryEntity (
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id:Long? = null,

    @Column(nullable = false)
    val date: LocalDate,

    @Column(nullable = false)
    val username: String,
){
    constructor(diaryRequest: DiaryRequest) : this(
        date = diaryRequest.date,
        username = diaryRequest.username
    )
}
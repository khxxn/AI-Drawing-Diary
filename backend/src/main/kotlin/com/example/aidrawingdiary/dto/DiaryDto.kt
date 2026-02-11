package com.example.aidrawingdiary.dto

import com.example.aidrawingdiary.entity.DiaryEntity
import java.time.LocalDate

data class DiaryDto(
    val id: Long? = null,
    val date: LocalDate = LocalDate.now(),
    val username: String = ""
) {
    constructor(diaryEntity: DiaryEntity) : this(
        id = diaryEntity.id,
        date = diaryEntity.date,
        username = diaryEntity.username
    )
}

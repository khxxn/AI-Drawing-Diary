package com.example.aidrawingdiary.repository

import com.example.aidrawingdiary.entity.DiaryMessageEntity
import org.springframework.data.repository.CrudRepository

interface DiaryMessageRepository : CrudRepository<DiaryMessageEntity, Long> {
    fun findByDiaryIdOrderByIdAsc(Id: Long): List<DiaryMessageEntity>
}
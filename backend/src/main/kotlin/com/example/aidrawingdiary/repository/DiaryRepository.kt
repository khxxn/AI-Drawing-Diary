package com.example.aidrawingdiary.repository

import com.example.aidrawingdiary.entity.DiaryEntity
import org.springframework.data.repository.CrudRepository

interface DiaryRepository : CrudRepository<DiaryEntity, Long> {
    fun findDiaryEntityByUsername(username: String): List<DiaryEntity>
}
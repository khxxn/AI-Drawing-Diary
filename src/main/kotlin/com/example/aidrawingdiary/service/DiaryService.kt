package com.example.aidrawingdiary.service

import com.example.aidrawingdiary.dto.DiaryDto
import com.example.aidrawingdiary.dto.DiaryRequest
import com.example.aidrawingdiary.entity.DiaryEntity
import com.example.aidrawingdiary.repository.DiaryRepository
import org.springframework.stereotype.Service


@Service
class DiaryService (
    private val diaryRepository : DiaryRepository
){
   fun createDiary(diaryRequest: DiaryRequest): DiaryDto{
       val diaryEntity = diaryRepository.save(DiaryEntity(diaryRequest))
       return DiaryDto(diaryEntity)
   }
    fun getDiaries(username: String) : List<DiaryDto> {
        val diaryEntities = diaryRepository.findDiaryEntityByUsername(username)
        return diaryEntities.map{ DiaryDto(diaryEntity = it) }
    }
}
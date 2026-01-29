package com.example.aidrawingdiary.controller

import com.example.aidrawingdiary.dto.DiaryDto
import com.example.aidrawingdiary.dto.DiaryRequest
import com.example.aidrawingdiary.dto.UserRequest
import com.example.aidrawingdiary.service.DiaryService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/diary")
class DiaryController (
    val diaryService: DiaryService
) {

    @PostMapping
    fun createDiary(
        @RequestBody diaryRequest : DiaryRequest
    ): DiaryDto{
        val response = diaryService.createDiary(diaryRequest)
        return response
    }

    @GetMapping("/{username}")
    fun getDiaries(
        @PathVariable username: String
    ): List<DiaryDto>{
        val response = diaryService.getDiaries(username)
        return response
    }
}
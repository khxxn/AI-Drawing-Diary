package com.example.aidrawingdiary.dto

data class MessageRequest(
    val diaryId: Long,
    val type: String,
    val username: String,
    val message: String,
)

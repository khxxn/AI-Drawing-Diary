package com.example.aidrawingdiary.service

import com.example.aidrawingdiary.dto.MessageRequest
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux


@Service
class DiaryMessageService(
    private val diaryAiService: DiaryAiService
) {
    fun createMessage(messageRequest: MessageRequest): Flux<String> {
        return diaryAiService.chatStream(messageRequest)
    }
}
package com.example.aidrawingdiary.service

import com.example.aidrawingdiary.dto.MessageDto
import com.example.aidrawingdiary.dto.MessageRequest
import com.example.aidrawingdiary.repository.DiaryMessageRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux


@Service
class DiaryMessageService(
    private val diaryMessageRepository: DiaryMessageRepository,
    private val diaryAiService: DiaryAiService
) {
    fun createMessage(messageRequest: MessageRequest): Flux<String> {
        return diaryAiService.chatStream(messageRequest)
    }

    fun getMessages(diaryId: Long): List<MessageDto>{
        return diaryMessageRepository.findByDiaryIdOrderByIdAsc(diaryId).map {
            MessageDto(it)
        }
    }
}
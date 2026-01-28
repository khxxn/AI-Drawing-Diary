package com.example.aidrawingdiary.service

import com.example.aidrawingdiary.dto.UserRequest
import com.example.aidrawingdiary.dto.UserResponse
import com.example.aidrawingdiary.entity.UserEntity
import com.example.aidrawingdiary.repository.UserRepository
import org.springframework.stereotype.Service


@Service
class UserService(
    private val userRepository: UserRepository
) {
    fun checkUsername(request: UserRequest) : UserResponse {
        val result = userRepository.existsUserEntityByUsername(request.username)

        if(!result){
            userRepository.save(UserEntity(username= request.username))
        }
        return UserResponse(result)
    }
}
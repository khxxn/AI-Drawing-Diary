package com.example.aidrawingdiary.controller

import com.example.aidrawingdiary.dto.UserRequest
import com.example.aidrawingdiary.dto.UserResponse
import com.example.aidrawingdiary.service.UserService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun checkUsername (
        @RequestBody request: UserRequest
    ): UserResponse {
        val response = userService.checkUsername(request)
        return response
    }

}



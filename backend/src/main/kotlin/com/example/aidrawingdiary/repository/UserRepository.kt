package com.example.aidrawingdiary.repository

import com.example.aidrawingdiary.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<UserEntity, Long>{
    fun existsUserEntityByUsername(username:String):Boolean
}
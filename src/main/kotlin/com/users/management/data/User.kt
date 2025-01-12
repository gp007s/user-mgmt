package com.users.management.data

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

data class User(
    val id: Long? = null,

    @field:NotBlank(message = "Name is mandatory")
    val name: String,

    @field:Email(message = "Email should be valid")
    @field:NotBlank(message = "Email is mandatory")
    val email: String
)

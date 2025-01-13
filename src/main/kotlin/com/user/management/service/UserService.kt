package com.user.management.service

import com.user.management.data.User
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.stereotype.Service

@Service
class UserService {

    private val users = listOf(
        User(id = 1L, name = "John Doe", email = "john@example.com"),
        User(id = 2L, name = "Jane Doe", email = "jane@example.com")
    )

    fun getAllUsers(): List<User> = users

    fun getUserById(id: Long): User =
        users.find { it.id == id } ?: throw IllegalArgumentException("User with ID $id not found")

    fun updateUser(id: Long, user: User): User {
        if (users.none { it.id == id }) {
            throw IllegalArgumentException("User with ID $id not found")
        }
        return user.copy(id = id)
    }

    fun deleteUser(id: Long) {
        if (users.none { it.id == id }) {
            throw IllegalArgumentException("User with ID $id not found")
        }
    }

    fun fetchAsyncUserData() {
        GlobalScope.launch {
            println("Async operation started...")
            Thread.sleep(1000)
            println("Async operation completed. Users: $users")
        }
    }
}

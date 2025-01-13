package com.user.management.controller

import com.user.management.data.User
import com.user.management.service.UserService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {

    @GetMapping
    fun getAllUsers(): ResponseEntity<List<User>> = ResponseEntity.ok(userService.getAllUsers())

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> =
        ResponseEntity.ok(userService.getUserById(id))

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @Valid @RequestBody user: User): ResponseEntity<User> =
        ResponseEntity.ok(userService.updateUser(id, user))

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long): ResponseEntity<Void> {
        userService.deleteUser(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/async")
    fun fetchAsyncUsers(): ResponseEntity<Void> {
        userService.fetchAsyncUserData()
        return ResponseEntity.accepted().build()
    }
}

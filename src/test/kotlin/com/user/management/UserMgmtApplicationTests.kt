package com.user.management

import com.user.management.data.User
import com.user.management.controller.UserController
import com.user.management.service.UserService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserMgmtApplicationTests {
	private val userService: UserService = mockk()
	private val userController = UserController(userService)

	@Test
	fun contextLoads() {
	}

	@Test
	fun `test getAllUsers returns user list`() {
		val userList = listOf(
			User(id = 1, name = "John Doe", email = "john@example.com"),
			User(id = 2, name = "Jane Doe", email = "jane@example.com")
		)
		every { userService.getAllUsers() } returns userList

		val response = userController.getAllUsers()
		System.out.println(response)
		// TODO : assertEquals(2, response.size)
		//TODO : assertEquals("John Doe",response[0].name)
	}
}

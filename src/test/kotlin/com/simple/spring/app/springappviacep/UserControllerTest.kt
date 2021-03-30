package com.simple.spring.app.springappviacep

import com.google.gson.Gson
import com.simple.spring.app.springappviacep.controller.UserController
import com.simple.spring.app.springappviacep.domainDTO.UserDTO
import org.junit.Before
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

class UserControllerTest : SpringAppViacepApplicationTests() {

    @Autowired
    lateinit var mockMVC: MockMvc

    @Autowired
    lateinit var userController: UserController

    val gson = Gson()

    @Before
    fun setUp() {
        this.mockMVC = MockMvcBuilders.standaloneSetup(userController).build()
    }

    @Test
    fun testGetUser() {

        mockMVC.perform(MockMvcRequestBuilders.get("/users/1")).andExpect(MockMvcResultMatchers.status().isOk)
        mockMVC.perform(MockMvcRequestBuilders.get("/users/1")).andExpect(MockMvcResultMatchers.jsonPath("name").value("João"))
    }

    @Test
    fun testPostUser() {
        val userTest = UserDTO(
                name = "Teste",
                document = "123456789",
                zipcode = "12040570",
        )
        mockMVC.perform(MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(userTest)))
                .andExpect(MockMvcResultMatchers.status().isCreated)
    }
}
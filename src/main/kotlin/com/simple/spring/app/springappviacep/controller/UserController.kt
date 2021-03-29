package com.simple.spring.app.springappviacep.controller

import com.simple.spring.app.springappviacep.domain.User
import com.simple.spring.app.springappviacep.domainDTO.UserDTO
import com.simple.spring.app.springappviacep.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.support.ServletUriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping(value = ["/users"])
class UserController @Autowired constructor (val service: UserService){

//    @GetMapping
//    fun testeCEP() {
//        val client: ViacepClient = ViacepClient()
//        client.get("ws/12042210/json/")
//    }

    @GetMapping(value = ["/{id}"])
	fun find(@PathVariable id: Int): ResponseEntity<User> {
		val obj: User = service.find(id)
		return ResponseEntity.ok().body(obj)
	}

    @PostMapping
    fun insert(@Valid @RequestBody userDTO: UserDTO): ResponseEntity<Unit> {
		var user = service.fromDTO(userDTO)
		user = service.insert(user)
		val uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.id).toUri()
		return ResponseEntity.created(uri).build()
    }
}
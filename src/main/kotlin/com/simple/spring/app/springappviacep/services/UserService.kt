package com.simple.spring.app.springappviacep.services

import com.simple.spring.app.springappviacep.client.getAddress
import com.simple.spring.app.springappviacep.domain.User
import com.simple.spring.app.springappviacep.domainDTO.UserDTO
import com.simple.spring.app.springappviacep.repositories.UserRepository
import org.hibernate.ObjectNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class UserService @Autowired constructor(val repo: UserRepository) {

    fun find(id: Int): User {
        val obj: User? = repo.findByIdOrNull(id)
        return obj ?: throw ObjectNotFoundException("Objeto não encontrado! Id: {$id}", "Tipo {${User::class}}")
    }

    fun insert(obj: User): User {
        obj.id = null
        return repo.save(obj)
    }

    fun fromDTO(userDTO: UserDTO): User {
        val address = getAddress(userDTO.zipcode)
        val name = userDTO.name
        val document = userDTO.document
        val zipcode = userDTO.zipcode
        val street = address.street
        val complement = address.complement
        val district = address.district
        val state = address.state
        val uf = address.UF
        return User(null, name, document, zipcode, street, complement, district, state, uf)
    }
}
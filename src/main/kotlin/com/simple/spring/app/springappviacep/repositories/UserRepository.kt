package com.simple.spring.app.springappviacep.repositories

import com.simple.spring.app.springappviacep.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface UserRepository : CrudRepository<User, Int> {

}
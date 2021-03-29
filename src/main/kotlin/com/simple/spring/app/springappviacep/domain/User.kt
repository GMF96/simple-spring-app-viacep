package com.simple.spring.app.springappviacep.domain;

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,
        var name: String = "teste",
        val document: String = "teste",
        var zipcode: String = "teste",
        var street: String = "teste",
        var complement: String? = null,
        var district: String = "teste",
        var state: String = "teste",
        var uf: String = "teste"
        )


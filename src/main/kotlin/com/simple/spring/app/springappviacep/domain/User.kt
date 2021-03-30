package com.simple.spring.app.springappviacep.domain

import javax.persistence.Table
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

// foi necessário incluir os valores default por conta do banco de dados
@Entity
@Table(name="users")
data class User (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Int? = null,
        var name: String = "default",
        val document: String = "default",
        var zipcode: String = "default",
        var street: String = "default",
        var complement: String? = null,
        var district: String = "default",
        var state: String = "default",
        var uf: String = "default"
        )


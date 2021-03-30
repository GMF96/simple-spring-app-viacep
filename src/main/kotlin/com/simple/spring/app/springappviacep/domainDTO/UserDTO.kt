package com.simple.spring.app.springappviacep.domainDTO

data class UserDTO (
    var id: Int? = null,
    var name: String,
    val document: String,
    var zipcode: String
    )

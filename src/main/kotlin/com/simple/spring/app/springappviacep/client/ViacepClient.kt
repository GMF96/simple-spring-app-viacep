package com.simple.spring.app.springappviacep.client


import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.http.*
import org.springframework.web.client.RestTemplate
import java.net.URI


val host = "http://viacep.com.br/"
val rest = RestTemplate()

fun getAddress(zipcode: String): Address {
    val uri = URI(host+"ws/"+zipcode+"/json/")
    val responseEntity: ResponseEntity<String> = rest.getForEntity(uri, String::class.java)
    val jsonObj = if (responseEntity.body != null) toJson(responseEntity.body!!) else throw Exception("Response can not be null")
    val user_address = Address(
        zipcode = jsonObj.get("cep").toString(),
        street = jsonObj.get("logradouro").toString(),
        complement = jsonObj?.get("complemento").toString(),
        district = jsonObj.get("bairro").toString(),
        state = jsonObj.get("localidade").toString(),
        UF = jsonObj.get("uf").toString()
    )
    return user_address
}


data class Address(
    val zipcode: String,
    val street: String,
    val complement: String?,
    val district: String,
    val state: String,
    val UF: String
)

fun toJson(str: String): JsonNode {
    val mapper = ObjectMapper()
    return mapper.readTree(str)
}
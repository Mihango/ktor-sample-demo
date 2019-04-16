package com.tech.models

data class Address(val code: String, val postal: String, val street: String)
data class Customer(val name: String, val address: Address)

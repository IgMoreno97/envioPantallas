package com.utad.enviopantallas

import java.io.Serializable


    data class User(val email: String, val nombre: String, val apellidos: String, val password: String, val fechaNacimiento: String) : Serializable


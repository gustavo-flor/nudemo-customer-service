package br.com.nudemo.cs.core.domain

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalDateTime.now

class Customer(var id: String? = null,
               var cpf: String,
               var fullName: String,
               var email: String,
               var birthDate: LocalDate,
               var createdAt: LocalDateTime = now(),
               var updatedAt: LocalDateTime = now()) {

}
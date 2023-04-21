package br.com.nudemo.cs.dataprovider.mongo.entity

import br.com.nudemo.cs.core.domain.Customer
import org.springframework.data.mongodb.core.index.Indexed
import org.springframework.data.mongodb.core.mapping.Document
import java.time.LocalDate
import java.time.LocalDateTime

@Document(collection = "customers")
class CustomerEntity(private var id: String? = null,
                     @Indexed(unique = true) private val cpf: String,
                     private val fullName: String,
                     private val email: String,
                     private val birthDate: LocalDate,
                     private val createdAt: LocalDateTime,
                     private val updatedAt: LocalDateTime) {

    fun toDomain(): Customer {
        return Customer(
            id = id,
            cpf = cpf,
            fullName = fullName,
            email = email,
            birthDate = birthDate,
            createdAt = createdAt,
            updatedAt = updatedAt
        )
    }

    companion object {

        fun of(customer: Customer): CustomerEntity {
            return CustomerEntity(
                id = customer.id,
                cpf = customer.cpf,
                fullName = customer.fullName,
                email = customer.email,
                birthDate = customer.birthDate,
                createdAt = customer.createdAt,
                updatedAt = customer.updatedAt
            )
        }

    }

}

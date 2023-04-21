package br.com.nudemo.cs.core.usecase

import br.com.nudemo.cs.common.util.StringUtil.Companion.removeNonDigits
import br.com.nudemo.cs.common.validation.mapping.FullName
import br.com.nudemo.cs.common.validation.mapping.LegalBirthDate
import br.com.nudemo.cs.core.domain.Customer
import jakarta.validation.Valid
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank
import org.hibernate.validator.constraints.br.CPF
import org.springframework.validation.annotation.Validated
import java.time.LocalDate

@Validated
interface CreateCustomerUseCase {

    fun execute(@Valid input: Input): Output

    data class Input(@field:NotBlank @field:CPF val cpf: String,
                     @field:NotBlank @field:FullName val fullName: String,
                     @field:NotBlank @field:Email val email: String,
                     @field:LegalBirthDate val birthDate: LocalDate) {

        fun toDomain(): Customer {
            return Customer(
                cpf = removeNonDigits(cpf),
                fullName = fullName,
                email = email,
                birthDate = birthDate
            )
        }

    }

    data class Output(val customer: Customer)

}
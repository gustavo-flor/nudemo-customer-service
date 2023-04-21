package br.com.nudemo.cs.common.validation

import br.com.nudemo.cs.common.validation.mapping.LegalBirthDate
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import java.time.LocalDate
import java.time.Period

class LegalBirthDateValidator: ConstraintValidator<LegalBirthDate, LocalDate> {

    private var minimumAge: Int = 18

    override fun initialize(constraintAnnotation: LegalBirthDate) {
        minimumAge = constraintAnnotation.minimumAge
    }

    override fun isValid(input: LocalDate?, context: ConstraintValidatorContext?): Boolean {
        val currentDate = LocalDate.now()
        return input == null || Period.between(input, currentDate).years >= minimumAge
    }

}
package br.com.nudemo.cs.common.validation.mapping

import br.com.nudemo.cs.common.validation.LegalBirthDateValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [LegalBirthDateValidator::class])
@MustBeDocumented
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class LegalBirthDate(val message: String = "{br.com.nudemo.cs.common.validation.mapping.LegalAge.message}",
                                val minimumAge: Int = 18,
                                val groups: Array<KClass<*>> = [],
                                val payload: Array<KClass<out Payload>> = [])

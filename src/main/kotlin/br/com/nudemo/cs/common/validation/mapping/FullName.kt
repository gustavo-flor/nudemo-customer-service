package br.com.nudemo.cs.common.validation.mapping

import br.com.nudemo.cs.common.validation.FullNameValidator
import jakarta.validation.Constraint
import jakarta.validation.Payload
import kotlin.reflect.KClass

@Constraint(validatedBy = [FullNameValidator::class])
@MustBeDocumented
@Target(AnnotationTarget.FIELD)
@Retention(AnnotationRetention.RUNTIME)
annotation class FullName(val message: String = "{br.com.nudemo.cs.common.validation.mapping.FullName.message}",
                          val regexp: String = "^[a-zA-Z]{2,}(?: [a-zA-Z]+)+$",
                          val groups: Array<KClass<*>> = [],
                          val payload: Array<KClass<out Payload>> = [])

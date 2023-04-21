package br.com.nudemo.cs.common.validation

import br.com.nudemo.cs.common.util.StringUtil.Companion.removeAccents
import br.com.nudemo.cs.common.validation.mapping.FullName
import jakarta.validation.ConstraintValidator
import jakarta.validation.ConstraintValidatorContext
import java.util.Optional
import java.util.regex.Matcher
import java.util.regex.Pattern

class FullNameValidator: ConstraintValidator<FullName, String> {

    private var fullNamePattern: Pattern = Pattern.compile("^[a-zA-Z]{2,}(?: [a-zA-Z]+)+$")

    override fun initialize(constraintAnnotation: FullName) {
        fullNamePattern = Pattern.compile(constraintAnnotation.regexp);
    }

    override fun isValid(input: String?, context: ConstraintValidatorContext?): Boolean {
        return Optional.ofNullable(input)
            .map { value: String -> value.trim() }
            .map { value: String -> removeAccents(value) }
            .map { value: String -> fullNamePattern.matcher(value) }
            .map { value: Matcher -> value.matches() }
            .orElse(true);
    }

}
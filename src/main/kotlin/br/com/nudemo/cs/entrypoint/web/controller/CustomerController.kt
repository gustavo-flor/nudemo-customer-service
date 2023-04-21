package br.com.nudemo.cs.entrypoint.web.controller

import br.com.nudemo.cs.core.domain.Customer
import br.com.nudemo.cs.core.usecase.CreateCustomerUseCase
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/customers")
class CustomerController(private val createCustomerUseCase: CreateCustomerUseCase) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody input: CreateCustomerUseCase.Input): Customer {
        return createCustomerUseCase.execute(input).customer
    }

}
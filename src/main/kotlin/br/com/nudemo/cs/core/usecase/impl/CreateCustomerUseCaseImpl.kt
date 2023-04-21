package br.com.nudemo.cs.core.usecase.impl

import br.com.nudemo.cs.core.service.CustomerService
import br.com.nudemo.cs.core.usecase.CreateCustomerUseCase
import org.springframework.stereotype.Component

@Component
class CreateCustomerUseCaseImpl(private val customerService: CustomerService): CreateCustomerUseCase {

    override fun execute(input: CreateCustomerUseCase.Input): CreateCustomerUseCase.Output {
        val customer = customerService.save(input.toDomain())
        return CreateCustomerUseCase.Output(customer)
    }

}
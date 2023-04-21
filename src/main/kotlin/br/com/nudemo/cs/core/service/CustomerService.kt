package br.com.nudemo.cs.core.service

import br.com.nudemo.cs.core.domain.Customer

interface CustomerService {

    fun save(customer: Customer): Customer

}
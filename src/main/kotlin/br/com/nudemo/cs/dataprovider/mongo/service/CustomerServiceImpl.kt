package br.com.nudemo.cs.dataprovider.mongo.service

import br.com.nudemo.cs.core.domain.Customer
import br.com.nudemo.cs.core.service.CustomerService
import br.com.nudemo.cs.dataprovider.mongo.entity.CustomerEntity
import br.com.nudemo.cs.dataprovider.mongo.repository.CustomerEntityRepository
import org.springframework.stereotype.Service

@Service
class CustomerServiceImpl(private val customerEntityRepository: CustomerEntityRepository): CustomerService {

    override fun save(customer: Customer): Customer {
        val entity = CustomerEntity.of(customer)
        return customerEntityRepository.save(entity).toDomain()
    }

}
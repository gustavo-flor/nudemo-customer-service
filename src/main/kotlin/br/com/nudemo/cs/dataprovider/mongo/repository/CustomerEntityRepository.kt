package br.com.nudemo.cs.dataprovider.mongo.repository

import br.com.nudemo.cs.dataprovider.mongo.entity.CustomerEntity
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface CustomerEntityRepository: MongoRepository<CustomerEntity, String>

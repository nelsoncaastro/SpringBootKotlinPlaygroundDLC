package com.uca.capas.crudthymeleaf

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.uca.capas.crudthymeleaf.repositories"])
@EnableTransactionManagement
@EntityScan(basePackages = ["com.uca.capas.crudthymeleaf.domain"])
class CrudThymeleafApplication

fun main(args: Array<String>) {
    runApplication<CrudThymeleafApplication>(*args)
}

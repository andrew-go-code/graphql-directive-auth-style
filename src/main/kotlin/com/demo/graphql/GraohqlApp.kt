package com.demo.graphql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GraphqlApp

fun main(args: Array<String>) {
    runApplication<GraphqlApp>(*args)
}

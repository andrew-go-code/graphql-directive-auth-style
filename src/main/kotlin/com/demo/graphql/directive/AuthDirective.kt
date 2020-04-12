package com.demo.graphql.directive

import graphql.GraphQLException
import graphql.schema.DataFetcher
import graphql.schema.idl.SchemaDirectiveWiringEnvironment
import mu.KotlinLogging

abstract class AuthDirective {
    private val logger = KotlinLogging.logger {}

    fun getAuthDataFetcher(authEntities: List<String>, origDataFetcher: DataFetcher<Any>): DataFetcher<Any> {
        return DataFetcher<Any> { environment ->
            if (hasAuthEntities(authEntities)){
                origDataFetcher.get(environment)
            } else {
                throw GraphQLException("Access denied")
            }
        }
    }

    fun authEntities(environment: SchemaDirectiveWiringEnvironment<*>): List<String>{
        try {
            return environment.directive.getArgument(getDirectiveArgumentName()).value as List<String>
        } catch (ex: ClassCastException){
            logger.error { "Wrong usage of a directive for ${environment.element.name}" }
            throw GraphQLException(ex.message)
        }
    }

    protected abstract fun getDirectiveArgumentName(): String

    protected abstract fun hasAuthEntities(authEntities: List<String>): Boolean
}
package com.demo.graphql.directive

import graphql.schema.GraphQLObjectType
import graphql.schema.idl.SchemaDirectiveWiringEnvironment

abstract class FieldObjectDirective : FieldDirective() {
    override fun onObject(environment: SchemaDirectiveWiringEnvironment<GraphQLObjectType>): GraphQLObjectType {
        val authEntities = authEntities(environment)

        val objectType = environment.element
        val parentType = environment.fieldsContainer

        objectType.fieldDefinitions.forEach{
            val origDataFetcher = environment.codeRegistry.getDataFetcher(parentType, it)
            val authDataFetcher = getAuthDataFetcher(authEntities, origDataFetcher)
            environment.codeRegistry.dataFetcher(parentType, it, authDataFetcher)
        }

        return objectType
    }
}
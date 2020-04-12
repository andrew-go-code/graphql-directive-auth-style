package com.demo.graphql.directive

import graphql.schema.GraphQLFieldDefinition
import graphql.schema.idl.SchemaDirectiveWiring
import graphql.schema.idl.SchemaDirectiveWiringEnvironment

abstract class FieldDirective : SchemaDirectiveWiring, AuthDirective() {
    override fun onField(environment: SchemaDirectiveWiringEnvironment<GraphQLFieldDefinition>): GraphQLFieldDefinition {
        val authEntities = authEntities(environment)

        val field = environment.element
        val parentType = environment.fieldsContainer

        val origDataFetcher = environment.codeRegistry.getDataFetcher(parentType, field)
        val authDataFetcher = getAuthDataFetcher(authEntities, origDataFetcher);
        environment.codeRegistry.dataFetcher(parentType, field, authDataFetcher)

        return field
    }
}
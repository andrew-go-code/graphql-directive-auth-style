package com.demo.graphql.resolver

import com.demo.graphql.model.Dictionaries
import graphql.kickstart.tools.GraphQLQueryResolver
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class RootResolver : GraphQLQueryResolver {
    fun dictionary(): Dictionaries {
        return Dictionaries()
    }
}
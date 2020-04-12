package com.demo.graphql.config

import com.demo.graphql.directive.HasGroupDirective
import com.demo.graphql.directive.HasResourceDirective
import com.demo.graphql.directive.HasRoleDirective
import graphql.kickstart.tools.boot.SchemaDirective
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class GraphqlConfig {
    @Bean
    fun hasRoleDirective(): SchemaDirective {
        return SchemaDirective("hasRole", HasRoleDirective())
    }

    @Bean
    fun hasGroupDirective(): SchemaDirective {
        return SchemaDirective("hasGroup", HasGroupDirective())
    }

    @Bean
    fun hasResourceDirective(): SchemaDirective {
        return SchemaDirective("hasResource", HasResourceDirective())
    }
}
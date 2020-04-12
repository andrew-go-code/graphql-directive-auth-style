package com.demo.graphql.directive

import com.demo.graphql.util.AuthUtil

class HasResourceDirective : FieldDirective() {
    companion object {
        const val directiveArgumentName: String = "resources"
    }

    override fun getDirectiveArgumentName(): String {
        return directiveArgumentName
    }

    override fun hasAuthEntities(authEntities: List<String>): Boolean {
        return AuthUtil.containsResources(authEntities)
    }
}
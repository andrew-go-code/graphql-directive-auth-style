package com.demo.graphql.directive

import com.demo.graphql.util.AuthUtil

class HasGroupDirective : FieldDirective() {
    companion object {
        const val directiveArgumentName: String = "groups"
    }

    override fun getDirectiveArgumentName(): String {
        return directiveArgumentName
    }

    override fun hasAuthEntities(authEntities: List<String>): Boolean {
        return AuthUtil.containsGroups(authEntities)
    }
}
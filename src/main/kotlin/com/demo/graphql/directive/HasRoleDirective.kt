package com.demo.graphql.directive

import com.demo.graphql.util.AuthUtil

class HasRoleDirective : FieldObjectDirective() {
    companion object {
        const val directiveArgumentName: String = "roles"
    }

    override fun getDirectiveArgumentName(): String {
        return directiveArgumentName
    }

    override fun hasAuthEntities(authEntities: List<String>): Boolean {
        return AuthUtil.containsRoles(authEntities)
    }
}
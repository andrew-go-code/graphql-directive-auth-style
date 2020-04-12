package com.demo.graphql.util

import mu.KotlinLogging
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.context.SecurityContextHolder
import java.util.stream.Collectors

/*
 *  groups and resources you can get (for example) from security context.
 *  if you use keycloak (for example) and use spring boot keycloak starter then
 *  resources would be in security context by default,
 *  for groups keycloak mappers should be set in order to find them (groups) in the context
 *  (you could find them in token other claims in particular)
 */
class AuthUtil {
    companion object {
        private val logger = KotlinLogging.logger {}

        private val fakeUserGroups: List<String> = listOf("cool_users_group", "special_group")
        private val fakeUserResources: List<String> = listOf("weird_resource", "special_resource")

        fun containsGroups(requiredGroups: List<String>): Boolean {
            logger.info { "current groups: $fakeUserGroups" }
            logger.info { "required groups: $requiredGroups" }
            return fakeUserGroups.containsAll(requiredGroups)
        }

        fun containsResources(requiredResources: List<String>): Boolean {
            logger.info { "current resources: $fakeUserResources" }
            logger.info { "required resources: $requiredResources" }
            return fakeUserResources.containsAll(requiredResources)
        }

        fun containsRoles(requiredRoles: List<String>): Boolean {
            val authorities = SecurityContextHolder.getContext().authentication.authorities
            val grantedAuthorities = requiredRoles.stream()
                    .map(::SimpleGrantedAuthority)
                    .collect(Collectors.toList())
            logger.info { "current roles: $authorities" }
            logger.info { "required roles: $grantedAuthorities" }
            return authorities.containsAll(grantedAuthorities)
        }
    }
}
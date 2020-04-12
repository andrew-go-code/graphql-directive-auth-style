package com.demo.graphql.resolver

import com.demo.graphql.model.Dictionaries
import graphql.kickstart.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class DictionaryResolver : GraphQLResolver<Dictionaries> {
    fun dictionaryOne(dictionaries: Dictionaries): List<String> {
        return listOf("dictionary one item 1", "dictionary two item 2");
    }

    fun dictionaryTwo(dictionaries: Dictionaries): List<String> {
        return listOf("dictionary two item 1", "dictionary two item 2")
    }

    fun dictionarySpecial(dictionaries: Dictionaries): List<String> {
        return listOf("dictionary special item 1", "dictionary special item 2")
    }

    fun dictionaryOnlyForWeirdPersons(dictionaries: Dictionaries): List<String> {
        return listOf("cool stuff item 1", "cool stuff item 2")
    }
}
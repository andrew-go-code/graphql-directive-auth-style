# GraphQL directive authorization style using Spring Boot

## Description

This project demonstrates how to restrict data access via graphql schema directives.

Say you have one or several auth entities (like roles, groups, atc.) that user may have. 
Then you want to give access to some data corresponding to these entities.
This task can solved using @directives like this:

```
type Dictionaries @hasRole(roles: ["usual_user", "graph_user"]) {
    dictionaryOne: [String]
    dictionaryTwo: [String] @hasRole(roles: ["not_existing_role"])
    dictionarySpecial: [String] @hasGroup(groups: ["special_group"])
    dictionaryOnlyForWeirdPersons: [String] @hasResource(resources: ["weird_resource"])
}
```

In this example we have Dictionaries type that can we accessed with two ROLES 
('usual_user', 'graph_user'). 
* For 'dictionaryOne' - it's enough. 
* For 'dictionaryTwo' - user must have ROLE 'not_existing_role' as well. 
* For 'dictionarySpecial' - user must have GROUP 'special_group'. 
* For 'dictionaryOnlyForWeirdPersons' - user must have RESOURCE 'weird_resource'.


### Request example

```graphql
query {
  dictionary {
    dictionaryOne
    dictionaryTwo
    dictionarySpecial
    dictionaryOnlyForWeirdPersons
  }
}
```

In addition, you have to pass http basic authentication with username=user, password=pass
(more specific 'user:pass' or in base64 'dNlcjpwYXNz')

```json
{
	"Authorization" : "Basic dNlcjpwYXNz"
}
```
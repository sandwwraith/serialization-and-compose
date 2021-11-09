package kotlinx.testing.common

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Serializable
data class User(val firstName: String, val age: Int)

fun decodeUser(input: String): User = Json.decodeFromString(input)
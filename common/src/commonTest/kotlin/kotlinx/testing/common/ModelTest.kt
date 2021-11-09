package kotlinx.testing.common

import kotlin.test.Test
import kotlin.test.assertEquals

class ModelTest {
    val testInput = """{"firstName":"Test user","age":1}"""

    @Test
    fun testParser() {
        val user = decodeUser(testInput)
        assertEquals(1, user.age)
        assertEquals("Test user", user.firstName)
    }
}
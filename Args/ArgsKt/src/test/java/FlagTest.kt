import org.junit.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class FlagTest {
    @ParameterizedTest(name = "should return {0} given {1}")
    @CsvSource(
            "false, 'boolean'",
            "0, 'integer'",
            "'', 'string'",
            "[], string[]",
            "[], integer[]"
    )
    fun testTypeDefaultValue(expected: Any?, given: String) {
        assertEquals(expected, FlagParser.parseDefaultValue(given).toString());
    }


    @ParameterizedTest(name = "should return flag given pattern")
    @ValueSource(
            strings = ["l:boolean", "p:integer", "d:string", "g:string[]", "i:integer[]"]
    )
    fun testReturnFlagGivenPattern(pattern: String) {
        val flag = FlagParser.parseFlagPattern(pattern)
        val split = pattern.split(":")
        assertEquals(split[0], flag.name)
        assertEquals(split[1], flag.typeName)
        assertEquals(FlagParser.parseDefaultValue(split[1]), flag.defaultValue)
    }

}
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFails

class FlagTest {
    @Test
    fun test_boolean_flag() {
        val flag = Flag("l:Boolean")
        assertEquals("l", flag.name)
        assertEquals(false, flag.defaultValue)
    }

    @Test
    fun test_int_flag() {
        val flag = Flag("l:Int")
        assertEquals("l", flag.name)
        assertEquals(0, flag.defaultValue)
    }

    @Test
    fun test_string_flag() {
        val flag = Flag("l:String")
        assertEquals("l", flag.name)
        assertEquals("", flag.defaultValue)
    }

    @Test
    fun test_boolean_flag_parse_null() {
        val flag = Flag("l:Boolean")
        assertEquals(false, flag.parse(null))
    }

    @Test
    fun test_boolean_flag_parse_empty() {
        val flag = Flag("l:Boolean")
        assertEquals(true, flag.parse(""))
    }

    @Test
    fun test_boolean_flag_parse_true() {
        val flag = Flag("l:Boolean")
        assertEquals(true, flag.parse("true"))
    }

    @Test
    fun test_boolean_flag_parse_exception() {
        val flag = Flag("l:Boolean")
        assertFails { flag.parse("abc") }
    }

    @Test
    fun test_int_flag_parse_null() {
        val flag = Flag("l:Int")
        assertEquals(0, flag.parse(null))
    }

    @Test
    fun test_int_flag_parse_empty() {
        val flag = Flag("l:Int")
        assertEquals(0, flag.parse(""))
    }

    @Test
    fun test_int_flag_parse_number() {
        val flag = Flag("l:Int")
        assertEquals(123, flag.parse("123"))
    }

    @Test
    fun test_int_flag_parse_exception() {
        val flag = Flag("l:Int")
        assertFails { flag.parse("a123") }
    }

    @Test
    fun test_string_flag_parse_string() {
        val flag = Flag("l:String")
        assertEquals("a123", flag.parse("a123"))
    }
}
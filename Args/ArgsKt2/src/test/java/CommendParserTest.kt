import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class CommendParserTest {
    @Test
    fun test_parser_size() {
        val parser = CommendParser("-l -p 8080 -d /usr/logs")
        assertEquals(3, parser.size())
    }

    @Test
    fun test_parser_size_with_negative_number() {
        val parser = CommendParser("-l -p -9 -d /usr/logs")
        assertEquals(3, parser.size())
    }

    @Test
    fun test_parser_empty_flag() {
        val parser = CommendParser("-l -p -9 -d /usr/logs")
        assertEquals("", parser.get("l"))
    }

    @Test
    fun test_parser_null_flag() {
        val parser = CommendParser("-l -p -9 -d /usr/logs")
        assertNull(parser.get("a"))
    }
}
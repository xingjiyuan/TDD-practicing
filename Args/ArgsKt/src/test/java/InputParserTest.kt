import org.junit.Test
import kotlin.test.assertEquals

class InputParserTest {
    @Test
    fun should_split_by_blink() {
        assertEquals(listOf("-l", "-p", "8080", "-d", "/usr/logs"),
                InputParser.split("-l -p 8080 -d /usr/logs"))
    }
    @Test
    fun should_make_pair_from_list(){
        assertEquals(listOf(Pair("l",""),Pair("p", "8080"), Pair("d", "/usr/logs")),
                InputParser.makePair("-l -p 8080 -d /usr/logs"))
    }
}
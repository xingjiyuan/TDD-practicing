import org.junit.Before
import org.junit.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertEquals

class SchemeTest {
    @ParameterizedTest(name = "should return size of {0} given pattern (1)")
    @CsvSource(
            "5,'l:boolean p:integer d:string g:string[] i:integer[]'"
    )
    fun testSchemeParseResultSize(expectedSize: Int, schemePattern: String) {
        val scheme = SchemeParser.parse(schemePattern)
        assertEquals(expectedSize, scheme.flags.size);
    }

    @Test
    fun testSchemeParserResult() {
        val scheme = SchemeParser.parse("l:boolean p:integer d:string g:string[] i:integer[]")
        var flag = scheme.getFlag("l")
        assertEquals(flag.name,"l")
        assertEquals(flag.typeName,"boolean")
        assertEquals(flag.defaultValue,false)

        flag = scheme.getFlag("p")
        assertEquals(flag.name,"p")
        assertEquals(flag.typeName,"integer")
        assertEquals(flag.defaultValue,0)

        flag = scheme.getFlag("d")
        assertEquals(flag.name,"d")
        assertEquals(flag.typeName,"string")
        assertEquals(flag.defaultValue,"")

        flag = scheme.getFlag("g")
        assertEquals(flag.name,"g")
        assertEquals(flag.typeName,"string[]")
        assertEquals(flag.defaultValue, listOf<String>())

        flag = scheme.getFlag("i")
        assertEquals(flag.name,"i")
        assertEquals(flag.typeName,"integer[]")
        assertEquals(flag.defaultValue, listOf<Int>())
    }


}
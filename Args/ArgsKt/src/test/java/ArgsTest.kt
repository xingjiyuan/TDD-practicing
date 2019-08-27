import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

import kotlin.test.assertEquals

class ArgsTest {
    @Test
    fun test_arg_from_flag() {
        val booleanFlag = Flag("l", "boolean", true)
        assertFlagEqualsArg(booleanFlag, Arg.fromFlag(booleanFlag))
        val intFlag = Flag("p", "integer", 8080)
        assertFlagEqualsArg(intFlag, Arg.fromFlag(intFlag))
        val stringFlag = Flag("d", "String", "")
        assertFlagEqualsArg(stringFlag, Arg.fromFlag(stringFlag))
    }

    private fun <T> assertFlagEqualsArg(flag: Flag<T>, arg: Arg<T>) {
        assertEquals(flag.name, arg.name)
        assertEquals(flag.defaultValue, arg.value)
    }

    @Test
    internal fun test_args_size() {
        val args = args()
        assertEquals(5, args.size())
    }

    private fun args(): Args {
        val input = InputParser.makePair("-l -p 8080 -d /usr/logs -g this,is,a,list -i 1,2,-3,5")
        val scheme = SchemeParser.parse("l:boolean p:integer d:string g:string[] i:integer[]")
        val args = Args(input, scheme)
        return args
    }

    @ParameterizedTest(name = "should throw {0} when given {1} with {2}")
    @CsvSource(
            "'-p接受integer类型的值，但实际收到的是abc', '-l -p abc -d /usr/logs', 'l:boolean p:integer d:string'",
            "'-l接受boolean类型的值，但实际收到的是abc', '-l abc -p 8080 -d /usr/logs', 'l:boolean p:integer d:string'"
    )
    fun should_throw_exception(expectedMessage: String, givenInput: String, givenScheme: String) {
        assertThrows<IllegalArgumentException>(expectedMessage) { Args(input = givenInput, scheme = givenScheme) }
    }

    @ParameterizedTest(name = "should return {0} given {1}")
    @CsvSource(
            "true, 'l'", "8080,'p'", "'/usr/logs','d'"
    )
    fun test(expectedValue: Any, givenFlagName: String) {
        val args = args()
        assertEquals(expectedValue.toString(), args.get(givenFlagName).toString())
    }

    @Test
    fun test_arg_g(){
        val args = args()
        assertEquals(listOf("this", "is", "a", "list"), args.get("g"))

    }

    @Test
    fun test_arg_i(){
        val args = args()
        assertEquals(listOf(1, 2, -3, 5), args.get("i"))

    }

}

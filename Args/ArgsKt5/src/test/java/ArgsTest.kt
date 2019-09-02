import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ArgsTest {
    lateinit var args: Args
    @BeforeEach
    internal fun setUp() {
        args = Args(Schema("s:string,i:int,b:boolean"))
    }

    @Test
    internal fun should_has_input_arg_when_handled_input() {
        args.handleInput("-s /usr/log -i 10 -b")
        assertEquals(3, args.getInputArgsSize())
    }

    @Test
    internal fun should_has_input_arg_list_when_handled_input() {
        args.handleInput("-s /usr/log -i 10 -b")
        assertEquals(
                listOf(InputArg("s", "/usr/log"),
                        InputArg("i", "10"),
                        InputArg("b", "")),
                args.inputArgs)
    }

    @Test
    internal fun should_get_string_value() {
        args.handleInput("-s /usr/log -i 10 -b")
        assertEquals("/usr/log", args.get("s"))
    }

    @Test
    internal fun should_get_int_value() {
        args.handleInput("-s /usr/log -i 10 -b")
        assertEquals(10, args.get("i"))
    }

    @Test
    internal fun should_get_boolean_value() {
        args.handleInput("-s /usr/log -i 10 -b")
        assertEquals(true, args.get("b"))
    }
}
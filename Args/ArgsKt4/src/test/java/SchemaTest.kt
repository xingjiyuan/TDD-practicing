import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class SchemaTest {
    @Test
    internal fun should_has_arg_spec_when_given_scheme_spec() {
        val schema: Schema = Schema("l:boolean,a:int,s:string")
        assertEquals(listOf(ArgSpec("l", "boolean"), ArgSpec("a", "int"), ArgSpec("s", "string")), schema.specList)
    }
}
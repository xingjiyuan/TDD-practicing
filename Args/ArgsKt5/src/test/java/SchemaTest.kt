import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class SchemaTest {
    @Test
    internal fun should_has_arg_spec_when_give_a_schema_str() {
        val schema = Schema("s:string,i:int,b:boolean")
        assertEquals(3, schema.getSpecSize())
    }

    @Test
    internal fun should_has_arg_spec_list_when_give_a_schema_str() {
        val schema = Schema("s:string,i:int,b:boolean")
        assertEquals(
                listOf(ArgSpec("s", "string"),
                        ArgSpec("i", "int"),
                        ArgSpec("b", "boolean")),
                schema.argSpecs)
    }
}
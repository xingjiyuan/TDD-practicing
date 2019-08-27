import org.junit.Test
import org.junit.jupiter.api.Assertions.*

class SchemaTest {


    @Test
    fun test_flag_size() {
        val schema = Schema("l:Boolean p:Int d:String");
        assertEquals(3, schema.size())
    }

    @Test
    fun test_get_l_flag() {
        val schema = Schema("l:Boolean p:Int d:String");
        assertEquals(Flag("l:Boolean"), schema.get("l"))
    }

    @Test
    fun test_get_null_flag() {
        val schema = Schema("l:Boolean p:Int d:String");
        assertNull(schema.get("a"))
    }
}
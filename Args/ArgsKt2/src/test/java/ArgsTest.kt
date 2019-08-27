import org.junit.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ArgsTest {
    @Test
    fun test_throw_not_support_exception() {
        val schema = Schema("l:Boolean p:Int d:String")
        val parser = CommendParser("-a -1 -p 8080 -d /usr/logs")
        assertFailsWith<IllegalArgumentException>("不支持-a") {
            Args(schema, parser)
        }
    }

    @Test
    fun test_throw_exception() {
        val schema = Schema("l:Boolean p:Int d:String")
        val parser = CommendParser("-l -1 -p 8080 -d /usr/logs")
        assertFailsWith<IllegalArgumentException>("-l接受Boolean值，但收到的是-1") {
            Args(schema, parser)
        }
    }

    /*
    * 任务清单
    * schema 解析出参数结构，参数结构有参数名，缺省值
    * schema 根据参数名，参数结构
    *
    * parser 解析出命令行输入的参数名和参数值
    *        根据参数名，获取输入值
    *
    *
    * Args  验证输入与参数结构是否匹配
    *       根据参数名，获取输入值
    *       如果输入值为空，则返回参数结构默认值
    *
    * */
    @Test //6:45
    fun test_boolean_default_value() {
        val schema = Schema("l:Boolean p:Int d:String")
        val parser = CommendParser("-l -p 8080 -d /usr/logs")
        val args = Args(schema, parser)
        assertEquals(true, args.getValue("l"))
        assertEquals(8080, args.getValue("p"))
        assertEquals("/usr/logs", args.getValue("d"))
    }

    @Test
    fun test_boolean_empty_value() {
        val schema = Schema("l:Boolean p:Int d:String")
        val parser = CommendParser("-p 8080 -d /usr/logs")
        val args = Args(schema, parser)
        assertEquals(false, args.getValue("l"))
        assertEquals(8080, args.getValue("p"))
        assertEquals("/usr/logs", args.getValue("d"))
    }

    @Test
    fun test_boolean_false_value() {
        val schema = Schema("l:Boolean p:Int d:String")
        val parser = CommendParser("-l false -p 8080 -d /usr/logs")
        val args = Args(schema, parser)
        assertEquals(false, args.getValue("l"))
        assertEquals(8080, args.getValue("p"))
        assertEquals("/usr/logs", args.getValue("d"))
    }

    @Test
    fun test_boolean_true_value() {
        val schema = Schema("l:Boolean p:Int d:String")
        val parser = CommendParser("-l true -p 8080 -d /usr/logs")
        val args = Args(schema, parser)
        assertEquals(true, args.getValue("l"))
        assertEquals(8080, args.getValue("p"))
        assertEquals("/usr/logs", args.getValue("d"))
    }

    @Test
    fun test_int_negative_value() {
        val schema = Schema("l:Boolean p:Int d:String")
        val parser = CommendParser("-l true -p -9 -d /usr/logs")
        val args = Args(schema, parser)
        assertEquals(true, args.getValue("l"))
        assertEquals(-9, args.getValue("p"))
        assertEquals("/usr/logs", args.getValue("d"))
    }
}
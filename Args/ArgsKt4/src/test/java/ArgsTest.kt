import kotlin.test.assertEquals

class ArgsTest {
    //@Test
    fun test() {
        val schema: Schema = Schema("l:boolean,a:int,s:string")
        val args = Args(schema)
        args.handleInput("-l -a 8080 -s /usr/log")
        assertEquals(true, args.get("l"))
    }
}
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class InputHandlerTest {
    @Test
    internal fun should_return_size_when_handle_input() {
        val inputHandler = InputHandler().apply { this.handle("-l -a 8080 -s /usr/log") }
        assertEquals(3, inputHandler.handledSize())
    }

    @Test
    internal fun should_return_list_when_handle_input() {
        val inputHandler = InputHandler().apply { this.handle("-l -a 8080 -s /usr/log") }
        assertEquals(listOf(InputArg("l", ""), InputArg("a", "8080"), InputArg("s", "/usr/log")), inputHandler.handledList)
    }
}

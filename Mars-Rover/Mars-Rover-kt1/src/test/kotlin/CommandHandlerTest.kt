import org.junit.Assert.assertEquals
import org.junit.Test

class CommandHandlerTest {
    @Test
    internal fun should_100X100_area_when_handled_init_command() {
        val commandHandler = CommandHandler()
        val initResult = commandHandler.handleInitCommand("X=100,Y=100,x=10,y=10,d=S")
        assertEquals(Area(100, 100), initResult.area)
    }

    @Test
    internal fun should_10_and_10_point_when_handled_init_command() {
        val commandHandler = CommandHandler()
        val initResult = commandHandler.handleInitCommand("X=100,Y=100,x=10,y=10,d=S")
        assertEquals(Point(10, 10), initResult.point)
    }

    @Test
    internal fun should_S_direction_when_handled_init_command() {
        val commandHandler = CommandHandler()
        val initResult = commandHandler.handleInitCommand("X=100,Y=100,x=10,y=10,d=S")
        assertEquals(Direction.S, initResult.direction)
    }
}
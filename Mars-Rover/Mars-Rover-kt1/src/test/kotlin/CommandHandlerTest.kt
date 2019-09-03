import org.junit.Assert.assertEquals
import org.junit.Test

class CommandHandlerTest {
    @Test
    internal fun should_return_100X100_area_when_handled_init_command() {
        val marsRover = MarsRover()
        marsRover.handler.handleInitCommand("X=100,Y=100,x=10,y=10,d=S")
        assertEquals(Area(100, 100), marsRover.area)
    }

    @Test
    internal fun should_return_10_and_10_point_when_handled_init_command() {
        val marsRover = MarsRover()
        marsRover.handler.handleInitCommand("X=100,Y=100,x=10,y=10,d=S")
        assertEquals(Point(10, 10), marsRover.position)
    }

    @Test
    internal fun should_return_S_direction_when_handled_init_command() {
        val marsRover = MarsRover()
        marsRover.handler.handleInitCommand("X=100,Y=100,x=10,y=10,d=S")
        assertEquals(Direction.S, marsRover.direction)
    }

    @Test
    fun should_return_S_direction_when_handled__l_with_W_direction() {
        val commandHandler = MarsRover().handler
        assertEquals(Direction.S, commandHandler.handleDirectionCommand("l", Direction.W))
    }

}
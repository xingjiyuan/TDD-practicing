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
    fun should_return_S_direction_when_handled_l_with_W_direction() {
        val marsRover = MarsRover()
        marsRover.direction = Direction.W
        marsRover.handler.handleDirectionCommand("l")
        assertEquals(Direction.S, marsRover.direction)
    }

    @Test
    fun should_handle_forward_command() {
        val marsRover = MarsRover()
        marsRover.handler.handleInitCommand("X=100,Y=100,x=10,y=10,d=S")
        marsRover.handler.handleOperateCommand("f=5")
        assertEquals(Point(10, 5), marsRover.position)
    }

    @Test
    fun should_handle_backward_command() {
        val marsRover = MarsRover()
        marsRover.handler.handleInitCommand("X=100,Y=100,x=10,y=10,d=S")
        marsRover.handler.handleOperateCommand("b=5")
        assertEquals(Point(10, 15), marsRover.position)
    }

    @Test
    fun should_handle_turn_command() {
        val marsRover = MarsRover()
        marsRover.handler.handleInitCommand("X=100,Y=100,x=10,y=10,d=N")
        marsRover.handler.handleOperateCommand("t=l")
        assertEquals(Direction.W, marsRover.direction)
    }

    @Test
    fun should_handle_batch_operate_command() {
        val marsRover = MarsRover()
        marsRover.handler.handleInitCommand("X=100,Y=100,x=10,y=10,d=N")
        marsRover.handler.handleOperateCommand("t=l,t=l,f=5,b=4")
        assertEquals(Direction.S, marsRover.direction)
        assertEquals(Point(10, 9), marsRover.position)
    }
}
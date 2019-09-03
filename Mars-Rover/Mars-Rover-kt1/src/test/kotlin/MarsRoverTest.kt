import org.junit.Assert.assertEquals
import org.junit.Test

class MarsRoverTest {
    /**
     * 框定需求
     *  1. 指令说明：X, Y 探索区域的大小，x, y 火星车初始坐标，d 火星车初始朝向，f 火星车向前走，b 火星车向后走，t 火星车转向
     *  2. 指令格式为 指令名称=指令值,指令名称=指令值,...
     *  3. 火星车先接收初始化指令，包括探索区域和自己所处位置和方向
     *  4. 火星车可以成批接受移动和转向指令
     *  5. 火星车接收到操作指令后，在完成操作后会立即回报当前位置和朝向
     */
    @Test
    internal fun test() {
        val marsRover = MarsRover()
        marsRover.handleInitCommand("X=100,Y=100,x=10,y=10,d=S")
        assertEquals(Area(100, 100), marsRover.area)
        assertEquals(Point(10, 10), marsRover.position)
        assertEquals(Direction.S, marsRover.direction)

        assertEquals("x=10,y=4,d=E", marsRover.handleOperateCommand("f=6,t=l"))
        assertEquals(Point(10, 4), marsRover.position)
        assertEquals(Direction.E, marsRover.direction)
        assertEquals("x=10,y=4,d=E", marsRover.report())
    }

    @Test
    fun should_has_area_and_point_and_direction_when_handle_init_command() {
        val marsRover = MarsRover()
        marsRover.handleInitCommand("X=100,Y=100,x=10,y=10,d=S")
        assertEquals(Area(100, 100), marsRover.area)
        assertEquals(Point(10, 10), marsRover.position)
        assertEquals(Direction.S, marsRover.direction)
    }

    @Test
    fun should_has_position_5_and_10_when_forward_with_W_direction() {
        val marsRover = MarsRover()
        marsRover.handleInitCommand("X=100,Y=100,x=10,y=10,d=W")
        marsRover.forward(5)
        assertEquals(Point(5, 10), marsRover.position)
    }

    @Test
    fun should_has_position_15_and_10_when_forward_with_E_direction() {
        val marsRover = MarsRover()
        marsRover.handleInitCommand("X=100,Y=100,x=10,y=10,d=E")
        marsRover.forward(5)
        assertEquals(Point(15, 10), marsRover.position)
    }

    @Test
    fun should_has_position_10_and_5_when_forward_with_S_direction() {
        val marsRover = MarsRover()
        marsRover.handleInitCommand("X=100,Y=100,x=10,y=10,d=S")
        marsRover.forward(5)
        assertEquals(Point(10, 5), marsRover.position)
    }

    @Test
    fun should_has_position_10_and_15_when_forward_with_N_direction() {
        val marsRover = MarsRover()
        marsRover.handleInitCommand("X=100,Y=100,x=10,y=10,d=N")
        marsRover.forward(5)
        assertEquals(Point(10, 15), marsRover.position)
    }

    @Test
    fun should_return_position_when_backward() {
        val marsRover = MarsRover()
        marsRover.handleInitCommand("X=100,Y=100,x=10,y=10,d=N")
        marsRover.backward(5)
        assertEquals(Point(10, 5), marsRover.position)
    }

    @Test
    fun should_return_direction_when_turned_left() {
        val marsRover = MarsRover()
        marsRover.handleInitCommand("X=100,Y=100,x=10,y=10,d=N")
        assertEquals(Direction.N, marsRover.direction)
        marsRover.turnLeft()
        assertEquals(Direction.W, marsRover.direction)
        marsRover.turnRight()
        assertEquals(Direction.N, marsRover.direction)
    }
}
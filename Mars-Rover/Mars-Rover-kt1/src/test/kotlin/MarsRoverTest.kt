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
        assertEquals(Area(100, 100), marsRover.getArea())
        assertEquals(Point(10, 10), marsRover.getPosition())
        assertEquals(Direction.S, marsRover.getDirection())

        assertEquals("x=10,y=4,d=E", marsRover.handleOperateCommand("f=6,t=l"))
        assertEquals(Point(10, 4), marsRover.getPosition())
        assertEquals(Direction.E, marsRover.getDirection())
        assertEquals("x=10,y=4,d=E", marsRover.report())
    }
}
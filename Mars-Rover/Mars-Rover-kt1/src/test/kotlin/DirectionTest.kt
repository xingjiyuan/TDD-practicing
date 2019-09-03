import org.junit.Assert.*
import org.junit.Test

class DirectionTest {
    @Test
    fun should_return_S_direction_when_W_direction_turned_left() {
        assertEquals(Direction.S, Direction.W.turnLeft())
    }
    @Test
    fun should_return_N_direction_when_W_direction_turned_right() {
        assertEquals(Direction.N, Direction.W.turnRight())
    }
    @Test
    fun should_return_W_direction_when_N_direction_turned_left() {
        assertEquals(Direction.W, Direction.N.turnLeft())
    }
}
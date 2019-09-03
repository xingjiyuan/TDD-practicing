import org.junit.Assert.assertEquals
import org.junit.Test

class DirectionTest {
    @Test
    fun should_return_S_direction_when_W_direction_turned_left() {
        assertEquals(Direction.S, Direction.W.toLeft())
    }
    @Test
    fun should_return_N_direction_when_W_direction_turned_right() {
        assertEquals(Direction.N, Direction.W.toRight())
    }
    @Test
    fun should_return_W_direction_when_N_direction_turned_left() {
        assertEquals(Direction.W, Direction.N.toLeft())
    }
}
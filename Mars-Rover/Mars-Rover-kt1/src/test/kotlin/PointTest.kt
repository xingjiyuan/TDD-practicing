import org.junit.Assert.assertEquals
import org.junit.Test

class PointTest {
    @Test
    fun should_return_15_when_add_x() {
        val point = Point(10, 10)
        assertEquals(Point(15, 10), point.addX(5))
    }

    @Test
    fun should_return_15_when_add_y() {
        val point = Point(10, 10)
        assertEquals(Point(10, 15), point.addY(5))
    }
}
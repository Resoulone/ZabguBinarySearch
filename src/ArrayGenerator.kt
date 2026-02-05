import kotlin.random.Random

object ArrayGenerator {
    fun generateArray(length: Int, min: Long, max: Long): LongArray {
        return LongArray(length) { Random.nextLong(min, max + 1) }
    }
}

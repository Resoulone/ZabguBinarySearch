import java.io.File

object Database {
    fun saveToFile(
        timesSequential: DoubleArray,
        timesBinary: DoubleArray,
        lengths: IntArray,
        filename: String = "results.txt"
    ) {
        val file = File(filename)
        file.bufferedWriter().use { writer ->
            writer.write("Длина массива\tВремя последовательного (мс)\tВремя бинарного (мс)\n")
            for (i in timesSequential.indices) {
                writer.write("${lengths[i]}\t${timesSequential[i]}\t${timesBinary[i]}\n")
            }
        }
        println("Результаты сохранены в файл: $filename")
    }
}
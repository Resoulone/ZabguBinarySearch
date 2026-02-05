import kotlin.system.measureNanoTime
import java.io.File

fun main() {
    var test = Tests.testSort()
    println("Тест сортировки!..........$test")

    var testSearchPosl = Tests.testSearchСonsistent()
    println("Тест последовательного поиска!..........$testSearchPosl")
    var testSearchBinary = Tests.testSearchBinary()
    println("Тест бинарного поиска!..........$testSearchBinary")


    // Начальные значения
    var length = 20000
    val min = 1L
    val max = 1000L
    val iterations = 5  // Количество операций

    val timesSequential = DoubleArray(iterations)
    val timesBinary = DoubleArray(iterations)
    val lengths = IntArray(iterations)
    val searchElement = 42L  // Элемент который нужно найти

    println("Поиск элемента $searchElement")

    for (i in 0 until iterations) {
        // Условия для разных итераций
        if (iterations != 1 && i != 0) {
            length *= 2
        }

        // Генерация массива
        val massiv = ArrayGenerator.generateArray(length, min, max)
        val massivSort = Sorter.shellSort(massiv.toTypedArray()).toLongArray() // требуется сортировка перед тем как делать бинарный поиск

        // Последовательный поиск
        val sequentialResult: Long
        val sequentialTime = measureNanoTime {
            sequentialResult = Search.searchPosl(massiv.toTypedArray(), searchElement)
        }
        print("$sequentialResult  ")

        timesSequential[i] = sequentialTime / 1_000_000.0  // Конвертация в миллисекунды



        // Бинарный поиск
        val binaryResult: Long
        val binaryTime = measureNanoTime {
            binaryResult = Search.searchBinary(massivSort.toTypedArray(), searchElement, 0, length - 1)
        }
        println("$binaryResult")

        timesBinary[i] = binaryTime / 1_000_000.0  // Конвертация в миллисекунды
        lengths[i] = length
    }

    // Запись в файл для построения графиков
    Database.saveToFile(timesSequential, timesBinary, lengths)

    println("\nРезультаты:")
    println("Длина\tПоследовательный (мс)\tБинарный (мс)")
    for (i in 0 until iterations) {
        println("${lengths[i]}\t${String.format("%.6f", timesSequential[i])}\t${String.format("%.6f", timesBinary[i])}")
    }
}
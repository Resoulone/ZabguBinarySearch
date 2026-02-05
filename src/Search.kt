object Search {
    /**
     * Последовательный поиск
     * функция принемает массив и искомое число в массиве
     * функция возвращает индекс типа long найденного числа, если не найдено вернет -1
     * поиск происходит последовательно, то есть перебором массива
     */
    fun <T : Comparable<T>> searchPosl(massiv: Array<T>, searchNum: T): Long {
        for (i in massiv.indices) {
            // Используем compareTo для сравнения значений
            if (massiv[i].compareTo(searchNum) == 0) {
                return i.toLong()
            }
        }
        return -1
    }

    /**
     * Бинарный поиск
     * функция принемает массив - massiv, искомое число - searchNum,  индекс начала поиска(startPer) == 0 и индекс конца поиска(stopPer)
     * возвращает индекс типа long найденного числа, если не найдено вернет -1
     * ВАЖНО! массив должен быть отсортирован по возрастанию, иначе не работает
     *
     * функция в отсортированном массиве определяет середину массива, сравнивает значение искомое и значение середины массива
     * val bin = startPer + (stopPer - startPer) / 2 - индекс в середине массива
     * если false - то сравнивает bin < искомого числа если false  то конец массива stopPer = bin - 1 то есть сдвигаем
     * правую часть массива на половину и повторяем все заново
     */
    fun <T : Comparable<T>> searchBinary(massiv: Array<T>, searchNum:  T, startPer: Int = 0, stopPer: Int = massiv.size - 1): Long {
        // Проверка границ

        if (startPer > stopPer) {
            return -1 // условие выхода

        }

        // Находим средний индекс
        val bin = startPer + (stopPer - startPer) / 2

        // Проверяем, найден ли элемент
        return when {
            massiv[bin] == searchNum -> bin.toLong()
            massiv[bin] < searchNum -> searchBinary(massiv, searchNum, bin + 1, stopPer)
            else -> searchBinary(massiv, searchNum, startPer, bin - 1)
        }
    }
}
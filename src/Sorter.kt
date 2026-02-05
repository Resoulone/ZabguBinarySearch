

    object Sorter {

        fun <T : Comparable<T>> shellSort(arr: Array<T>): Array<T> { // Comparable ограничение для шаблона типа Т , который требует принимать только типы с операторами сравнения
            val sortedArray = arr.copyOf()
            val n = sortedArray.size
            var gap = n / 2
            while (gap > 0) {
                for (i in gap until n) {
                    val temp = sortedArray[i]
                    var j = i
                    while (j >= gap && sortedArray[j - gap] > temp) {
                        sortedArray[j] = sortedArray[j - gap]
                        j -= gap
                    }
                    sortedArray[j] = temp
                }
                gap /= 2
            }
            return sortedArray
        }
    }

import Sorter
import kotlin.collections.toLongArray

object Tests{
    fun testSort(): String{
        var arr = longArrayOf(3, 1, 4, 1, 5, 9, 2, 6)
        var sortArr = Sorter.shellSort(arr.toTypedArray()).toLongArray()
        assert(pereborderSort(sortArr))

        var arr2 = longArrayOf(12, 13 , 14 , 15 )
        var sortArr2 = Sorter.shellSort(arr2.toTypedArray()).toLongArray()
        assert(pereborderSort(sortArr2))

        var arr3 = longArrayOf(9, 8, 7, 6, 5, 4, 3, 2, 1)
        var sortArr3 = Sorter.shellSort(arr3.toTypedArray()).toLongArray()
        assert(pereborderSort(sortArr3))


        return "OK!"

    }
    fun testSearchСonsistent(): String{
        var arr = longArrayOf(34, 545, 12, 92, 345, 222, 3442, 1134)
        var searchNum = 92L
        val index = 3L
        var res = Search.searchPosl(arr.toTypedArray(), searchNum)
        assert(index == res)

        var arr2 = longArrayOf(34,35,36,37,38)
        var searchNum2 = 34L
        var index2 = 0L
        var res2 = Search.searchPosl(arr2.toTypedArray(), searchNum2)
        assert(index2 == res2)

        var arr3 = longArrayOf(34,36,37,1)
        var searchNum3 = 37L
        var index3 = 2L
        var res3 = Search.searchPosl(arr3.toTypedArray(), searchNum3)
        assert(index3 == res3)
        return "OK!"
    }

    fun testSearchBinary(): String{
        var arr = longArrayOf(33, 121, 34, 3431, 52, 934, 223, 5)
        var sortArr = Sorter.shellSort(arr.toTypedArray()).toLongArray()
        var searchNum = 5L
        var index = 0L
        var res = Search.searchBinary(sortArr.toTypedArray(),searchNum)
        assert(index == res)

        var searchNum2 = 3431L
        var index2 = 7L
        var res2 = Search.searchBinary(sortArr.toTypedArray(),searchNum2)
        assert(index2 == res2)

        var searchNum3 = 33L
        var index3 = 1L
        var res3 = Search.searchBinary(sortArr.toTypedArray(),searchNum3)
        assert(index3 == res3)

        var searchNum4 = 100L
        var res4 = Search.searchBinary(sortArr.toTypedArray(),searchNum4)
        var index4 = -1L
        assert(index4 == res4)


        return "OK!"
    }



    fun pereborderSort(arr: LongArray): Boolean {

        for (i in 0 until arr.size -1){
            if (arr[i] > arr[i+1]){
                return false
            }

        }
        return true
    }



}
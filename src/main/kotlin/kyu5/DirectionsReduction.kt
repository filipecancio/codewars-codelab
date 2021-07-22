package kyu5

object DirReduction {
    lateinit var newArr:Array<String>

    fun dirReduc(arr: Array<String>): Array<String> {
        var skip = 0

        var newArr = arr.filterIndexed { index, value ->
            if(index < arr.size-1){
                isNotReasonable(value, arr[index+1])
            }else if(Directions.position == 0){
                true
            } else{
                Directions.position = 0
                false
            }
        }.toTypedArray()
        if(arr.size != newArr.size){
            newArr = dirReduc(newArr)
        }

        return  newArr
    }
}

fun getCoordinate(valueA: String, valueB: String) =
    Pair(Directions.valueOf(valueA).coordinate, Directions.valueOf(valueB).coordinate)

fun isSameCoordinate(valueA: String, valueB: String): Boolean {
    val coordinates = getCoordinate(valueA, valueB)
    return coordinates.first == coordinates.second
}

fun getModule(valueA: String, valueB: String) =
    Pair(Directions.valueOf(valueA).module, Directions.valueOf(valueB).module)

fun isSameDirection(valueA: String, valueB: String): Boolean {
    val module = getModule(valueA, valueB)
    return module.first + module.second != 0
}

fun isNotReasonable(valueA: String, valueB: String) =
    if ((isSameCoordinate(valueA, valueB) && isSameDirection(valueA, valueB))||(!isSameCoordinate(valueA,valueB))) {
        if (Directions.position == 1) {
            Directions.position = 0
            false
        } else {
            true
        }
    } else {
        if (Directions.position == 0) {
            Directions.position = 1
            false
        } else {
            Directions.position = 0
            false
        }

    }

enum class Directions(val module: Int, val coordinate: Char) {
    NORTH(1, 'x'),
    SOUTH(-1, 'x'),
    EAST(1, 'y'),
    WEST(-1, 'y');

    companion object {
        var position = 0
    }
}
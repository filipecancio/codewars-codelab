
fun encode(num: Int): String {
    val temp = RomanBind.getNumber(num).result
    return temp
}

enum class RomanBind(val decimalValue: Int, val decimalPreviousValue: Int, val valueRom: String, val previousValue: String) {
    M(1000,900, "M", "CM"),
    D(500, 400,"D", "CD"),
    C(100, 90,"C", "XC"),
    L(50, 40,"L", "XL"),
    X(10, 9,"X", "IX"),
    V(5, 4,"V", "IV"),
    I(1, 0,"I", "");

    companion object {

        fun getNumber(num: Int,count:RomanNumberCount = RomanNumberCount()): RomanNumberCount {
            values().map {
                if (it.decimalPreviousValue <= num) {
                    count.apply {
                        type = it
                        division = if (it.decimalPreviousValue == num) 4 else (num / it.decimalValue)
                        module = num % it.decimalValue
                        result = when (division) {
                            3 -> result + it.valueRom + it.valueRom + it.valueRom
                            2 -> result + it.valueRom + it.valueRom
                            1 -> result + it.valueRom
                            else -> result + it.previousValue
                        }
                        if (module > 0 && (module != num)) Companion.getNumber(module,count)
                        else if(module != 0 && module == num) Companion.getNumber(num - it.decimalPreviousValue,count)
                    }
                    return count
                }
            }
            return count
        }

    }
}

data class RomanNumberCount(
    var type: RomanBind = RomanBind.I,
    var module: Int = 0,
    var division: Int = 0,
    var result: String = ""
)
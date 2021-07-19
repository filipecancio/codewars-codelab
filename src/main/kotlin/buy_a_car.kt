import kotlin.math.roundToInt

object BuyCar {
    fun nbMonths(
        startPriceOld: Int,
        startPriceNew: Int,
        savingperMonth: Int,
        percentLossByMonth: Double
    ): Pair<Int, Int> {
        Pair(0, 0)
        var priceOld = startPriceOld.toDouble()
        var priceNew = startPriceNew.toDouble()
        var monthLeft = 0
        var loss = percentLossByMonth
        var valueLeft = priceOld - (priceNew - (monthLeft * savingperMonth))

        do {
            if (valueLeft < 0) {
                monthLeft++
                if (monthLeft > 0 && isPair(monthLeft)) loss += 0.5
                priceOld = decreaseValue(priceOld,loss)
                priceNew = decreaseValue(priceNew,loss)
            }
            valueLeft = priceOld - (priceNew - (monthLeft * savingperMonth))
        } while (valueLeft < 0)

        return Pair(monthLeft,valueLeft.roundToInt())
    }

    fun isPair(num: Int) = num % 2 == 0
    private fun decreaseValue(num: Double, fee:Double):Double = num - (num * (fee/100))
}
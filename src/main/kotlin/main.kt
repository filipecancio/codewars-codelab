import kyu7.gps

fun main(args: Array<String>) {
    /**
     * println(encode(0))
    println(encode(1))
    println(encode(21))
    println(encode(2008))
    println(encode(1666))

    print(BuyCar.nbMonths(7500, 32000, 300, 1.55))
    */


    val x = doubleArrayOf(0.0, 0.23, 0.46, 0.69, 0.92, 1.15, 1.38, 1.61)
    val x1 = doubleArrayOf(0.0,0.18,0.36,0.54,0.72,1.05,1.26,1.47,1.92,2.16,2.4,2.64,2.88,3.12,3.36,3.6,3.84)
    println(gps(20, x1))
}
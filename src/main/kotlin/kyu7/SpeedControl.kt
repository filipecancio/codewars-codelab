package kyu7

fun gps(s: Int, x: DoubleArray): Int {
    var sections = getSections(x)
    sections = getVelocitys(s, sections)
    return sections.max()?.toInt() ?: 0
}

fun getSections(x: DoubleArray) = x.mapIndexed { index, value ->
    if (index + 1 < x.size) {
        x[index + 1] - value
    } else null
}.filterNotNull()

fun bindVelocity(s: Int, delta_distance: Double) = (3600 * delta_distance) / s

fun getVelocitys(s: Int, x: List<Double>) = x.map { value -> bindVelocity(s, value) }

fun printDoubleArray(x: DoubleArray){
    print(" x: [")
    x.map { print(" $it ") }
    println("]")
}

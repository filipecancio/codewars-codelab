import kyu5.DirReduction.dirReduc
import kyu6.wave
import kyu7.gps

fun main(args: Array<String>) {
    print(dirReduc(arrayOf("NORTH", "EAST", "NORTH", "EAST", "WEST", "WEST", "EAST", "EAST", "WEST", "SOUTH")).toList())
}
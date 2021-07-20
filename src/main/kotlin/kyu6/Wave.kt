package kyu6

fun wave(str: String): List<String> = str.mapIndexed { index, cha ->
    if (cha.toInt() in 97..122) str.replaceRange(index, index + 1, cha.toUpperCase().toString()) else null
}.filterNotNull()
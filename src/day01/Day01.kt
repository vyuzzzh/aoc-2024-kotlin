package day01

import readInput
import kotlin.math.abs

fun main() {
    val testInput = readInput("day01_test")
    val input = readInput("day01")

    val left = mutableListOf<Int>()
    val right = mutableListOf<Int>()

    testInput.forEach { line ->
        val parts = line.split(" ")
        val first = parts.first().toInt()
        val second = parts.last().toInt()

        left.add(first)
        right.add(second)
    }
    right.sort()
    left.sort()

    val totalDistance = left.zip(right) { l, r -> abs(l - r) }.sum()

    val map = left.associateWith { l -> right.count { it == l } }
    val similarityScore = left.sumOf { l -> l * (map[l] ?: 0) }
    println(totalDistance)
    println(similarityScore)
}

package com.example._1.algorithm

fun main() {
	val a = 3
	val b = 6
	var answer = 0
	for (i: Int in a..b) {
		answer += i
	}

	println(answer)
	println("*".repeat(b))
}

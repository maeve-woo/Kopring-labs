package com.example._1.algorithm

import java.util.*

fun main() {
	val a = intArrayOf(4,3,2,1)
	var b = intArrayOf()
	var min = Int.MAX_VALUE
	if(a.size <= 1) {
		b = intArrayOf(-1)
		println(b.contentToString())
		return
	}
	for (i: Int in a) {
		if(min > i) {
			min = i
		}
	}
	println(a.filter { e-> e != min }.toIntArray())
	return
}

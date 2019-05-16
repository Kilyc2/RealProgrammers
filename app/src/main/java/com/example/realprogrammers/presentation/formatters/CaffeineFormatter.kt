package com.example.realprogrammers.presentation.formatters

inline class CaffeineFormatter(private val caffeineLevel: Int) {

    fun format() = when (caffeineLevel) {
        0 -> "Bad"
        1 -> "Regular"
        2 -> "Good"
        3 -> "Great"
        else -> "Excellent"
    }
}
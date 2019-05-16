package com.example.realprogrammers.presentation.formatters

inline class EmacsFormatter(private val emacsValue: Int) {

    fun format() = when (emacsValue) {
        0 -> "Bad"
        1 -> "Regular"
        2 -> "Good"
        3 -> "Great"
        else -> "Excellent"
    }
}
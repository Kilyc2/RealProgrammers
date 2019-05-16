package com.example.realprogrammers.domain.entities

import java.util.*

data class Programmer(
    val firstName: String,
    val lastName: String,
    val emacs: Int,
    val caffeine: Int,
    val rating: Int,
    val interviewDate: Date,
    val isFavourite: Boolean
) {
    val fullName: String
        get() = "$firstName $lastName"
}
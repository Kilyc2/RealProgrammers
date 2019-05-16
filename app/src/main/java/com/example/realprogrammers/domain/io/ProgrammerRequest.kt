package com.example.realprogrammers.domain.io

import java.util.*

data class ProgrammerRequest(
    var firstName: String = "",
    var lastName: String = "",
    var emacs: Int = 2,
    var caffeine: Int = 2,
    var rating: Int = 1,
    var interviewDate: Date? = null,
    var isFavourite: Boolean = false
) {
    val isValid: Boolean
        get() = firstName.isNotBlank()
}

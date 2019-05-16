package com.example.realprogrammers.domain.io

import com.example.realprogrammers.domain.entities.Programmer
import java.util.*

data class ProgrammerResponse(
    val fullName: String,
    val interviewDate: Date,
    val isFavorite: Boolean
) {
    constructor(programmer: Programmer) : this(
        fullName = programmer.fullName,
        interviewDate = programmer.interviewDate,
        isFavorite = programmer.isFavourite
    )

}
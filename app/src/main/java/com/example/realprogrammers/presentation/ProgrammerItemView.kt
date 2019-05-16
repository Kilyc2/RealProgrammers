package com.example.realprogrammers.presentation

interface ProgrammerItemView {

    fun displayName(name: String)
    fun displayInterviewDate(date: String)
    fun displayFavourite(favourite: Boolean)
}
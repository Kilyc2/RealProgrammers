package com.example.realprogrammers.presentation

interface DetailView {

    fun setFirstName(firstName: String)
    fun setLastName(lastName: String)
    fun setCaffeineValue(caffeineValue: Int)
    fun displayCaffeineLabel(caffeineLabel: String)
    fun setEmacsValue(emacsValue: Int)
    fun displayEmacsLabel(emacsLabel: String)
    fun setRating(rating: Int)
    fun activateButton(isEnabled: Boolean)
}
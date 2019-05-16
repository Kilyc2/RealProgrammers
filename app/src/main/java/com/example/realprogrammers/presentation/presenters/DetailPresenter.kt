package com.example.realprogrammers.presentation.presenters

import com.example.realprogrammers.domain.UseCaseFactory
import com.example.realprogrammers.domain.io.ProgrammerRequest
import com.example.realprogrammers.presentation.DetailView
import com.example.realprogrammers.presentation.formatters.CaffeineFormatter
import com.example.realprogrammers.presentation.formatters.EmacsFormatter
import kotlin.properties.Delegates

class DetailPresenter(
    private val view: DetailView,
    private val useCaseFactory: UseCaseFactory
) {

    private var programmer: ProgrammerRequest by Delegates.observable(ProgrammerRequest()) { _, _, _ ->
        displayView()
    }

    fun viewReady() = with(view) {
        setFirstName(firstName = programmer.firstName)
        setLastName(lastName = programmer.lastName)
        setEmacsValue(emacsValue = programmer.emacs)
        displayEmacsLabel(emacsLabel = EmacsFormatter(emacsValue = programmer.emacs).format())
        setCaffeineValue(caffeineValue = programmer.caffeine)
        displayCaffeineLabel(caffeineLabel = CaffeineFormatter(caffeineLevel = programmer.caffeine).format())
        setRating(rating = programmer.rating)
        activateButton(programmer.isValid)
    }

    fun firstNameChanges(firstName: String) {
        programmer = programmer.copy(firstName = firstName)
    }

    fun lastNameChanges(lastName: String) {
        programmer = programmer.copy(lastName = lastName)
    }

    fun caffeineLevelChanges(caffeineLevel: Int) {
        val rating = (caffeineLevel + programmer.emacs) / 2
        programmer = programmer.copy(caffeine = caffeineLevel, rating = rating)
    }

    fun emacsLevelChanges(emacsLevel: Int) {
        val rating = (emacsLevel + programmer.caffeine) / 2
        programmer = programmer.copy(emacs = emacsLevel, rating = rating)
    }

    private fun displayView() = with(view) {
        displayEmacsLabel(emacsLabel = EmacsFormatter(emacsValue = programmer.emacs).format())
        displayCaffeineLabel(caffeineLabel = CaffeineFormatter(caffeineLevel = programmer.caffeine).format())
        setRating(rating = programmer.rating)
        activateButton(programmer.isValid)
    }

    fun saveButtonClicked() {
        useCaseFactory.addProgrammerUseCase(handler = {}, programmer = programmer)
    }

}
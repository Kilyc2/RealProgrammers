package com.example.realprogrammers.presentation.presenters

import com.example.realprogrammers.domain.EntityGateway
import com.example.realprogrammers.domain.UseCaseFactory
import com.example.realprogrammers.domain.io.ProgrammerResponse
import com.example.realprogrammers.presentation.MainView
import com.example.realprogrammers.presentation.ProgrammerItemView
import com.example.realprogrammers.presentation.formatters.toFormattedString

class MainPresenter(
    private val view: MainView,
    private val useCaseFactory: UseCaseFactory
) : EntityGateway.Observer {

    private var programmerList = emptyList<ProgrammerResponse>()

    val numberOfItems: Int
        get() = programmerList.size

    fun viewReady() {
        val presenter = this
        useCaseFactory.listProgrammersUseCase { response ->
            presenter.programmerList = response
        }
            .execute()
    }

    fun configureViewHolder(viewHolder: ProgrammerItemView, position: Int) {
        viewHolder.run {
            val programmer = programmerList[position]
            programmer.run {
                displayFavourite(favourite = isFavorite)
                displayInterviewDate(date = interviewDate.toFormattedString())
                displayName(name = fullName)
            }
        }
    }

    fun pressButton() {
        view.goToDetail()
    }

    override fun notifyChanges() {

    }
}
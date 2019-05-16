package com.example.realprogrammers.domain.usecases

import com.example.realprogrammers.domain.EntityGateway
import com.example.realprogrammers.domain.Handler
import com.example.realprogrammers.domain.UseCase
import com.example.realprogrammers.domain.entities.Programmer
import com.example.realprogrammers.domain.io.ProgrammerRequest
import java.util.*

class AddProgrammerUseCase(
    private val gateway: EntityGateway,
    private val handler: Handler<Unit>,
    private val programmer: ProgrammerRequest
) : UseCase {

    private fun add(programmerRequest: ProgrammerRequest) {
        programmerRequest.run {
            gateway.insert(
                Programmer(
                    firstName = firstName,
                    lastName = lastName,
                    emacs = emacs,
                    caffeine = caffeine,
                    rating = rating,
                    interviewDate = Date(),
                    isFavourite = isFavourite
                )
            )
        }
    }

    override fun execute() {
        add(programmer)
        handler(Unit)
    }
}
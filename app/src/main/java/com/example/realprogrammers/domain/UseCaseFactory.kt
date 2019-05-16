package com.example.realprogrammers.domain

import com.example.realprogrammers.domain.io.ProgrammerRequest
import com.example.realprogrammers.domain.io.ProgrammerResponse
import com.example.realprogrammers.domain.usecases.AddProgrammerUseCase
import com.example.realprogrammers.domain.usecases.ListProgrammersUseCase

class UseCaseFactory(private val entityGateway: EntityGateway) {

    fun listProgrammersUseCase(handler: (List<ProgrammerResponse>) -> Unit): UseCase =
        ListProgrammersUseCase(gateway = entityGateway, handler = handler)

    fun addProgrammerUseCase(handler: (Unit) -> Unit, programmer: ProgrammerRequest): UseCase =
        AddProgrammerUseCase(gateway = entityGateway, handler = handler, programmer = programmer)

}
package com.example.realprogrammers.domain.usecases

import com.example.realprogrammers.domain.EntityGateway
import com.example.realprogrammers.domain.Handler
import com.example.realprogrammers.domain.UseCase
import com.example.realprogrammers.domain.io.ProgrammerResponse

class ListProgrammersUseCase(
    private val gateway: EntityGateway,
    private val handler: Handler<List<ProgrammerResponse>>
) : UseCase {

    override fun execute() {
        var response: List<ProgrammerResponse> = mutableListOf()

        gateway.fetchProgrammers { result ->
            if (result.isSuccess) {
                result.map { programmerList ->
                    response = programmerList.map { programmer ->
                        ProgrammerResponse(programmer)
                    }
                }
            }
        }

        handler(response)
    }
}
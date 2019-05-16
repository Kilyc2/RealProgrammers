package com.example.realprogrammers.data

import com.example.realprogrammers.domain.EGHandler
import com.example.realprogrammers.domain.EntityGateway
import com.example.realprogrammers.domain.entities.Programmer
import java.lang.ref.WeakReference

class InMemoryRepository(private val programmers: List<Programmer>) : EntityGateway {

    private lateinit var observers: MutableList<WeakReference<EntityGateway.Observer>>

    override fun addObservers(observer: WeakReference<EntityGateway.Observer>) {
        observers.add(observer)
    }

    private var programmerList = mutableListOf<Programmer>()

    override fun fetchProgrammers(handler: EGHandler<List<Programmer>>) {
        programmers.map { programmer -> programmerList.add(programmer.copy()) }
        handler(Result.success(programmerList.toList()))
    }

    override fun insert(programmer: Programmer): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun findProgrammer(id: String): Programmer {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteProgrammer(id: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(programmer: Programmer): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
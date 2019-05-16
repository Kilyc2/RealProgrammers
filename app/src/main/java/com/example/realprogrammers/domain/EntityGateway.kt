package com.example.realprogrammers.domain

import com.example.realprogrammers.domain.entities.Programmer
import java.lang.ref.WeakReference

typealias EGHandler<T> = (Result<T>) -> Unit

class IdNotFound(val id: String) : Throwable()

interface EntityGateway {

    fun fetchProgrammers(handler: EGHandler<List<Programmer>>)

    fun insert(programmer: Programmer): String

    fun findProgrammer(id: String): Programmer

    fun deleteProgrammer(id: String): String

    fun update(programmer: Programmer): String

    fun addObservers(observer: WeakReference<Observer>)

    interface Observer {
        fun notifyChanges()
    }
}





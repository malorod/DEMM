package com.demm.marina.demm

import org.junit.Assert.*
import org.junit.Test

class MapThingRepositoryTest {

    val repository: ThingRepository = MapThingRepository()

    @Test
    fun givenNewRepositoryShouldBeEmpty() {
        assertTrue(repository.isEmpty())
    }

    @Test
    fun shouldSaveAThing() {
        //Given
        val thing = Thing("Boli","Cajón")
        //When
        repository.save(thing)
        //Then
        assertTrue(repository.contains(thing)!!)
    }
}
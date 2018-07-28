package com.demm.marina.demm

import org.hamcrest.core.Is
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

    @Test
    fun shouldReturnTwoThingsSavedInTheSamePlace() {
        //Given
        val cajon = "cajon"
        val socks = Thing("Socks", cajon)
        val scarf = Thing("gufanda", cajon)

        //When
        repository.save(socks)
        repository.save(scarf)

        //then
        assertThat(repository.contains(socks)!!, Is.`is`(true))
        assertTrue(repository.contains(scarf)!!)
    }
}
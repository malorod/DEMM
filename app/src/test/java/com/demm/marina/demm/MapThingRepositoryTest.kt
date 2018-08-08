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
        val thing = Thing("Boli", "Cajón")
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

        //Then
        assertThat(repository.contains(socks)!!, Is.`is`(true))
        assertTrue(repository.contains(scarf)!!)
    }

    @Test
    fun shoulReturnTheFirstKey(){
        //Given
        val expected = Thing("Calcetines", "Estanteria")
        repository.save(expected)

        //When
        val first = repository.getFirst()

        //Then
        assertThat(first, Is.`is`(expected))
    }
    
    @Test
    fun shouldReturnAllTheThings(){
        //Given
        val cajon = "cajon"
        val socks = Thing("Socks", cajon)
        val scarf = Thing("Bufanda", cajon)
        val jeans = Thing("Vaqueros", cajon)
        repository.save(socks)
        repository.save(scarf)
        repository.save(jeans)
        
        //When
        val listThings = repository.getThingList(repository.getFirst())
        
        //Assert
        assertThat(listThings!!.size, Is.`is`(3))
        assertTrue(listThings.contains(scarf))
        assertTrue(listThings.contains(socks))
        assertTrue(listThings.contains(jeans))
    }
}

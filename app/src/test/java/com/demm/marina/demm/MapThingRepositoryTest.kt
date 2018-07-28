package com.demm.marina.demm

import org.junit.Assert.*
import org.junit.Test

class MapThingRepositoryTest {

    val repository = MapThingRepository()

    @Test
    fun givenNewRepositoryShouldBeEmpty() {
        assertEquals(repository.map.size.toLong(), 0)
    }
}
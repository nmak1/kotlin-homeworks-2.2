package ru.netology

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val added = service.add(
            Post(
                id = 1,
                text = "First post"
                )
        )
        val result = added.idInPosts > 0
        assertTrue(result)
    }

    @Test
    fun update_objectFound() {
        val service = WallService()
        val post1 = Post(
            id = 1,
            ownerId = 1,
            date = 1,
            text = "First post",
            )
        service.add(post1)
        val post2 = Post(
            id = 2,
            ownerId = 1,
            date = 1,
            text = "Second post",

        )
        service.add(post2)
        val update = Post(
            id = 1,
            ownerId = 1,
            date = 2,
            text = "The newest first post",

        )
        val result = service.update(update)
        assertTrue(result)

    }


    @Test
    fun update_objectNotFound() {

        val service = WallService()

        val post1 = Post(
            id = 1,
            ownerId = 1,
            date = 1,
            text = "First post",

        )
        service.add(post1)
        val post2 = Post(
            id = 2,
            ownerId = 1,
            date = 1,
            text = "Second post",

        )
        service.add(post2)

        val update = Post(
            id = 11,
            ownerId = 1,
            date = 1,
            text = "The newest first post",

        )

        val result = service.update(update)

        assertFalse(result)
    }
}
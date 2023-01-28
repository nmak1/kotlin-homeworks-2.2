package ru.netology

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class WallServiceTest {

    @Test
    fun add() {
        val service = WallService()
        val added = service.addedPost(
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
        service.addedPost(post1)
        val post2 = Post(
            id = 2,
            ownerId = 1,
            date = 1,
            text = "Second post",

            )
        service.addedPost(post2)
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
        service.addedPost(post1)
        val post2 = Post(
            id = 2,
            ownerId = 1,
            date = 1,
            text = "Second post",

            )
        service.addedPost(post2)

        val update = Post(
            id = 11,
            ownerId = 1,
            date = 1,
            text = "The newest first post",

            )

        val result = service.update(update)

        assertFalse(result)
    }

    @Test(expected = PostNotFoudException::class)
    fun shouldThrow() {
        val post1 = Post(
            id = 1,
            ownerId = 1,
            date = 1,
            text = "First post",

            )
        WallService().addedPost(post1)
        val commentForTest = Comment(post1.id, text = "test")
        WallService().createComment(post1.id, commentForTest)
    }

    @Test(expected = PostNotFoudException::class)
    fun reasonTest() {

        val post = Post(
            id = 1,
            ownerId = 1,
            date = 1,
            text = "First post",

            )
        WallService().addedPost(post)
        val commentForTest = Comment(post.id, text = "test")
        val comment = WallService().createComment(post.id, commentForTest)
        assertTrue(WallService().repotComment(post.id!!,comment.id!!, ReasonType.Спам))

    }
}
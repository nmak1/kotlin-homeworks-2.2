package ru.netology


class WallService {

    private var posts = emptyArray<Post>()
    private var comments = emptyArray<Comment>()

    fun addedPost(post: Post): Post {
        posts += if (posts.isEmpty()) post.copy(idInPosts = 1) else post.copy(idInPosts = posts.last().idInPosts + 1)
        return posts.last()

    }

    fun update(post: Post): Boolean {
        val idexPostUpdates = posts.indexOf(post)
        return if (idexPostUpdates != -1) {
            posts[idexPostUpdates] =
                post.copy(ownerId = posts[idexPostUpdates].ownerId, date = posts[idexPostUpdates].date)
            true
        } else {
            false
        }
    }


    fun createComment(postId: Int?, comment: Comment): Comment {
        for (post in posts) {
            if (postId == post.id) {
                posts[postId!!].comments = posts[postId].comments?.plus(comment)
                return comments.last()
            }
        }
        throw PostNotFoudException("Пост не найден")
    }


    @Throws(PostNotFoudException::class)
    fun repotComment(
        owner_id: Int,
        comment_id: Int,
        reasonType: ReasonType
    ): Boolean {
        for (post in posts) {
            if (owner_id == post.id)
                for (comment in comments)
                    if (comment_id == comment.id) {
                        return true
                    }
        }
        return false
        throw PostNotFoudException("Такой пост не найден")

    }
}
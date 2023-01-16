package ru.netology

class WallService {

    private var posts = emptyArray<Post>()

    fun add( post: Post) : Post {
        posts += if ( posts.isEmpty()) post.copy(idInPosts = 1) else post.copy(idInPosts = posts.last().idInPosts+1)
        return posts.last()

    }

    fun update ( post: Post) : Boolean {
        val idexPostUpdates = posts.indexOf(post)
        return if (idexPostUpdates !=-1){
            posts[idexPostUpdates] = post.copy(ownerId = posts[idexPostUpdates].ownerId, date = posts[idexPostUpdates].date)
             true } else {
             false
            }
        }

}
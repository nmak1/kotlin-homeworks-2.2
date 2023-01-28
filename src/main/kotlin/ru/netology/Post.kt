package ru.netology

data class Post(
    var id: Int? = null,
    val ownerId: Int?=null,
    val fromId: Int?=null,
    val createdBy: Int?=null,
    val date: Int?=null,
    val text: String?=null,
    val replyOwnerId: Int?=null,
    val replyPostId: Int?=null,
    val friendsOnly: Boolean = false,
    var comments: Array <Comment>?= emptyArray(),
    val copyright: String?=null,
    val likes: Likes?=null,
    val reposts: Reposts?=null,
    val views: Views?=null,
    val postType: String = "post",
    val postSource: PostSource?=null,
    val attachment: Array<Attachment>?= emptyArray(),
    val geo: Geo?=null,
    val signerId: Int?=null,
    val copyHistory: Array<Post>?= emptyArray(),
    val canPin: Boolean = false,
    val canDelete: Boolean = false,
    val canEdit: Boolean = false,
    val isPinned: Boolean = false,
    val markedAsAds: Boolean = false,
    val isFavorite: Boolean = false,
    val postponedId: Int?=null,
    var idInPosts: Int = 0
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Post

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id!!
    }


}
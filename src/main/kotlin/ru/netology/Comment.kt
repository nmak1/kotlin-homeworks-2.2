package ru.netology

data class Comment(
    var id: Int? = null, // Идентификатор комментария
    val postId: Int? = null, // идентификатор поста
    val fromId: Int? = null, // Идентификатор автора комментария
    val date: Int? = null, // Дата создания комментария в формате Unixtime
    val text: String? = null, // Текст комментария
    val donut: Donut? = null, //  Информация о VK Donut
    val attachments: Array<Attachment>? = emptyArray(), // Медиавложения комментария (фотографии, ссылки и т.п.)
    val parentsStack: Array<Int>? = emptyArray(), // Массив идентификаторов родительских комментариев
    val thread: Thread? = null,
)
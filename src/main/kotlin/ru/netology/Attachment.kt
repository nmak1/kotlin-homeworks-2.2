package ru.netology


sealed class Attachment(val type: String)

data class AudioAttachment(val audio: Audio) : Attachment("audio")
data class DocAttachment(val doc: Doc) : Attachment("doc")
data class LinkAttachment(val link: Link) : Attachment("link")
data class PhotoAttachment(val photo: Photo) : Attachment("photo")
data class VideoAttachment(val video: Video) : Attachment("video")



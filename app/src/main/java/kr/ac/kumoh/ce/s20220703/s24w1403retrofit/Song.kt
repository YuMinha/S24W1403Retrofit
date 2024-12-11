package kr.ac.kumoh.ce.s20220703.s24w1403retrofit

data class Song(
    val id: Int,
    val title: String,
    val singer: String,
    val rating: Int,
    val lyrics: String?
)
package koogle.ride.share.model

data class Help(
    val created_at: String,
    val driver: Int,
    val help_description: String,
    val help_title: String,
    val id: Int,
    val updated_at: String,
    val user_help_id: Int
)
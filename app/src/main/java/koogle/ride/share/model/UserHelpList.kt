package koogle.ride.share.model

data class UserHelpList(
    val helpList: List<Help>,
    val message: String,
    val statusCode: Int
)
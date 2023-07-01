package koogle.ride.share.model

data class HelpItemResponse(
    val helpDescriptionDetails: List<Help>,
    val message: String,
    val statusCode: Int
)
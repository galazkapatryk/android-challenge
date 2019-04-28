package pl.branchdev.eventdomain.model

data class Event(
    val title: String,
    val subtitle: String,
    val thumbnailUrl: String,
    val dateInformation: String,
    val videoUrl: String
)
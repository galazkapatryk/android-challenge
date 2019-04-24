package pl.branchdev.data

class VideoEventDto(
    id: String,
    title: String,
    subtitle: String,
    date: String,
    imageUrl: String, val videoUrl: String
) : EventDto(id, title, subtitle, date, imageUrl)
package com.moonanime.app

data class Anime(
    val id: String,
    val title: String,
    val imageUrl: String,
    val description: String = "",
    val episodes: Int = 0
)

class AnimeRepository {

    private val animeList = listOf(
        Anime(
            id = "1",
            title = "Demon Slayer",
            imageUrl = "https://picsum.photos/400/600?random=1",
            description = "A young swordsman begins a dangerous journey.",
            episodes = 55
        ),
        Anime(
            id = "2",
            title = "Attack on Titan",
            imageUrl = "https://picsum.photos/400/600?random=2",
            description = "Humanity fights for survival behind enormous walls.",
            episodes = 89
        ),
        Anime(
            id = "3",
            title = "Jujutsu Kaisen",
            imageUrl = "https://picsum.photos/400/600?random=3",
            description = "A student becomes involved with a world of curses.",
            episodes = 47
        ),
        Anime(
            id = "4",
            title = "One Piece",
            imageUrl = "https://picsum.photos/400/600?random=4",
            description = "A pirate crew searches for the legendary One Piece.",
            episodes = 1100
        )
    )

    fun getAnime(): List<Anime> {
        return animeList
    }

    fun searchAnime(query: String): List<Anime> {
        if (query.isBlank()) return animeList

        return animeList.filter {
            it.title.contains(query, ignoreCase = true)
        }
    }

    fun getAnimeById(id: String): Anime? {
        return animeList.find { it.id == id }
    }
}
package com.moonanime.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MoonAnimeApp()
        }
    }
}

@Composable
fun MoonAnimeApp() {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF090A13)
        ) {
            MoonAnimeHome()
        }
    }
}

@Composable
fun MoonAnimeHome() {

    var searchText by remember { mutableStateOf("") }

    val animeList = listOf(
        "Solo Leveling",
        "One Piece",
        "Demon Slayer",
        "Jujutsu Kaisen",
        "Naruto",
        "Attack on Titan"
    )

    val filteredAnime = animeList.filter {
        it.contains(searchText, ignoreCase = true)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "🌙 MoonAnime",
            color = Color.White,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "Watch your favorite anime",
            color = Color.LightGray,
            fontSize = 14.sp
        )

        Spacer(modifier = Modifier.height(18.dp))

        TextField(
            value = searchText,
            onValueChange = { searchText = it },
            modifier = Modifier.fillMaxWidth(),
            placeholder = {
                Text("Search anime...")
            },
            singleLine = true,
            shape = RoundedCornerShape(14.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = if (searchText.isEmpty()) "🔥 Trending Anime"
            else "🔎 Search Results",
            color = Color.White,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        if (filteredAnime.isEmpty()) {

            Text(
                text = "No anime found.",
                color = Color.LightGray,
                modifier = Modifier.padding(top = 20.dp)
            )

        } else {

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                items(filteredAnime) { anime ->

                    AnimeCard(
                        title = anime
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(28.dp))

        Text(
            text = "⭐ Your Library",
            color = Color.White,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = { },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Open Library")
        }
    }
}

@Composable
fun AnimeCard(title: String) {

    Box(
        modifier = Modifier
            .width(150.dp)
            .height(210.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color(0xFF25284A),
                        Color(0xFF11121E)
                    )
                )
            )
            .padding(12.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {

            Text(
                text = "🎬",
                fontSize = 45.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = title,
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Anime",
                color = Color.LightGray,
                fontSize = 12.sp
            )
        }
    }
}
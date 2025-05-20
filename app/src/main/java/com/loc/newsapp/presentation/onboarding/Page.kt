package com.loc.newsapp.presentation.onboarding

import androidx.annotation.DrawableRes
import com.loc.newsapp.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int,
)

val pages = listOf(
    Page(
        title = "Stay in the Loop",
        description = "Never miss an update from your favorite clubs. All news, one place.",
        image = R.drawable.onboarding1
    ),
    Page(
        title = "Discover New Clubs",
        description = "Explore communities that match your interests.",
        image = R.drawable.onboarding2
    ),
    Page(
        title = "Join the Vibe",
        description = "Connect, participate, and make the most of campus life.",
        image = R.drawable.onboarding3
    )
)
package com.aluastudio.library

import android.media.MediaPlayer

data class SoundItem(
    val nameResId: Int, // ID du texte dans strings.xml
    val imageResId: Int, // ID de l'image drawable
    val soundResId: Int, // ID du son raw
    var mediaPlayer: MediaPlayer? = null,
    var isPlaying: Boolean = false,
    var volume: Int = 0 // de 0 à 100
)

val soundList = listOf(
    SoundItem(R.string.raining, R.drawable.ic_raining, R.raw.raining),
    SoundItem(R.string.soft_wind, R.drawable.ic_soft_wind, R.raw.soft_wind),
    SoundItem(R.string.thunder, R.drawable.ic_thunder, R.raw.thunder),
    SoundItem(R.string.cat_purring, R.drawable.ic_cat_purring, R.raw.cat_purring),
    SoundItem(R.string.library, R.drawable.ic_library, R.raw.library),
    SoundItem(R.string.coffee, R.drawable.ic_coffee, R.raw.coffee),
    SoundItem(R.string.forest, R.drawable.ic_forest, R.raw.forest),
    SoundItem(R.string.water_stream, R.drawable.ic_water_stream, R.raw.water_stream),
    SoundItem(R.string.seaside, R.drawable.ic_seaside, R.raw.seaside),
    SoundItem(R.string.campfire, R.drawable.ic_campfire, R.raw.campfire),
    SoundItem(R.string.white_noise, R.drawable.ic_noise, R.raw.white_noise),
    SoundItem(R.string.pink_noise, R.drawable.ic_noise, R.raw.pink_noise),
    SoundItem(R.string.brownien_noise, R.drawable.ic_noise, R.raw.brownien_noise)
)
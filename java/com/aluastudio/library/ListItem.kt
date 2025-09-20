package com.aluastudio.library

import android.media.MediaPlayer

sealed class ListItem {
    data class Section(val title: String) : ListItem()
    data class Sound(
        val nameResId: Int,
        val iconResId: Int,
        val soundResId: Int,
        var mediaPlayer: MediaPlayer? = null,
        var isPlaying: Boolean = false,
        var volume: Int = 0
    ) : ListItem()
}
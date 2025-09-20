package com.aluastudio.library

import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SoundAdapter(private val sounds: List<SoundItem>) :
    RecyclerView.Adapter<SoundAdapter.SoundViewHolder>() {

    inner class SoundViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.libraryIcon)
        val label: TextView = view.findViewById(R.id.libraryLabel)
        val slider: SeekBar = view.findViewById(R.id.volumeSlider)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sound, parent, false)
        return SoundViewHolder(view)
    }

    override fun onBindViewHolder(holder: SoundViewHolder, position: Int) {
        val sound = sounds[position]
        val context = holder.itemView.context

        holder.label.text = context.getString(sound.nameResId)
        holder.icon.setImageResource(sound.imageResId)
        holder.icon.alpha = if (sound.volume == 0) 0.4f else 1.0f
        holder.slider.progress = sound.volume

        if (sound.mediaPlayer == null) {
            sound.mediaPlayer = MediaPlayer.create(context, sound.soundResId)
            sound.mediaPlayer?.isLooping = true
        }

        holder.slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                sound.volume = progress
                val volume = progress / 100f
                sound.mediaPlayer?.setVolume(volume, volume)

                if (progress == 0) {
                    sound.mediaPlayer?.pause()
                    sound.isPlaying = false
                } else {
                    if (!sound.isPlaying) {
                        sound.mediaPlayer?.start()
                        sound.isPlaying = true
                    }
                }

                holder.icon.alpha = if (progress == 0) 0.4f else 1.0f
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}
            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })
    }

    override fun getItemCount(): Int = sounds.size
}

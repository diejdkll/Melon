package com.example.melon

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide

class MelonDetailActivity : AppCompatActivity() {

    lateinit var playPauseBottom: ImageView
    lateinit var mediaPlayer: MediaPlayer
    var position = 0
        set(value) {
            if(value <= 0){
                field = 0
            }else if (value >= melonItemList.size - 1){
                field = melonItemList.size - 1
            }else{
                field = value
            }
        }
    var isPlaying: Boolean = true
        set(value) {
            if (value == true){
                playPauseBottom.setImageDrawable(
                    this.resources.getDrawable(R.drawable.pause, this.theme)
                )
            }else{
                playPauseBottom.setImageDrawable(
                    this.resources.getDrawable(R.drawable.play, this.theme)
                )
            }
            field = value
        }
    lateinit var melonItemList: ArrayList<MelonItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_melon_detail)

        melonItemList = intent.getSerializableExtra("melon_item_list") as ArrayList<MelonItem>
        position = intent.getIntExtra("position", 0)

        playMelonItem(melonItemList.get(position))
        changeThumbnail(melonItemList.get(position))

        playPauseBottom = findViewById(R.id.play)
        playPauseBottom.setOnClickListener {
            if(isPlaying == true){
                isPlaying = false
                mediaPlayer.stop()
            }else{
                isPlaying = true
                playMelonItem(melonItemList.get(position))
            }
        }

        findViewById<ImageView>(R.id.back).setOnClickListener {
            mediaPlayer.stop()
            position = position - 1
            playMelonItem(melonItemList.get(position))
            changeThumbnail(melonItemList.get(position))
        }

        findViewById<ImageView>(R.id.next).setOnClickListener {
            mediaPlayer.stop()
            position = position + 1
            playMelonItem(melonItemList.get(position))
            changeThumbnail(melonItemList.get(position))
        }
    }
    fun playMelonItem(melonItem: MelonItem){
        mediaPlayer = MediaPlayer.create(
            this,
            Uri.parse(melonItem.song)
        )
        mediaPlayer.start()
    }
    fun changeThumbnail(melonItem: MelonItem){
        findViewById<ImageView>(R.id.thumbnail).apply {
            val glide = Glide.with(this@MelonDetailActivity)
            glide.load(melonItem.thumbnail).into(this)
        }
    }
}
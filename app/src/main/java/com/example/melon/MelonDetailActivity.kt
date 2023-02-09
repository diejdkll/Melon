package com.example.melon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MelonDetailActivity : AppCompatActivity() {

    lateinit var playPauseBottom: ImageView
    var isPlaying: Boolean = false
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

        playPauseBottom = findViewById(R.id.play)
        playPauseBottom.setOnClickListener {
            if(isPlaying == true){
                isPlaying = false
            }else{
                isPlaying = true
            }
        }

        melonItemList = intent.getSerializableExtra("melon_item_list") as ArrayList<MelonItem>
    }
}
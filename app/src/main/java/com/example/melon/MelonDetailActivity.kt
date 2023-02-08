package com.example.melon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MelonDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_melon_detail)

        val melonItemList = intent.getSerializableExtra("melon_item_list") as ArrayList<MelonItem>
    }
}
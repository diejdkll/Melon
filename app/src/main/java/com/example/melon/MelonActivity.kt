package com.example.melon

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MelonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_melon)

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val retrofitService = retrofit.create(RetrofitService::class.java)

        retrofitService.getMelonItemList().enqueue(object : Callback<ArrayList<MelonItem>>{
            override fun onResponse(
                call: Call<ArrayList<MelonItem>>,
                response: Response<ArrayList<MelonItem>>
            ) {

            }

            override fun onFailure(call: Call<ArrayList<MelonItem>>, t: Throwable) {

            }
        })
    }
}

class MelonItemRecyclerAdepter(
    val melonItemList: ArrayList<MelonItem>,
    val inflater: LayoutInflater,
    val glide: RequestManager,
    val context: Context
): RecyclerView.Adapter<MelonItemRecyclerAdepter.Viewholder>(){

    inner class Viewholder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {

    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
    }

    override fun getItemCount(): Int {
        return melonItemList.size
    }
}
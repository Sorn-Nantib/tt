package com.example.retrofitmyself

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.example.retrofitmyself.databinding.ActivityDetailBinding
import com.example.retrofitmyself.databinding.ActivityMainBinding
import com.example.retrofitmyself.model.GameModel
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {

    private  lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val cardModel = intent.getSerializableExtra("card")  as GameModel.Data.Meme

        if(cardModel !=null){
            val textView: TextView = findViewById(R.id.user_detail)
            val textViews: TextView = findViewById(R.id.title_detail)
            val imageView: ImageView = findViewById(R.id.image_detail)

            textView.text = cardModel.id
            textViews.text = cardModel.name
            Picasso.get()
                .load(cardModel.url)
                .placeholder(R.drawable.blue)
                .error(R.drawable.lover)
                .into(imageView);
        }
        binding.arrowBack.setOnClickListener {
            finish()
        }

    }
}
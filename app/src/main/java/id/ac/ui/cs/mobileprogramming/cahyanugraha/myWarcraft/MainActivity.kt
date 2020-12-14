package id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Picasso
            .get()
            .load("https://render-us.worldofwarcraft.com/character/nagrand/110/193182574-main.jpg")
            .into(binding.imageViewMonk)
        Picasso
            .get()
            .load("https://render-us.worldofwarcraft.com/character/nagrand/236/198891500-main.jpg")
            .into(binding.imageViewDK)
        Picasso
            .get()
            .load("https://render-us.worldofwarcraft.com/character/nagrand/21/199371285-main.jpg")
            .into(binding.imageViewMage)
        Picasso
            .get()
            .load("https://render-us.worldofwarcraft.com/character/nagrand/39/199371303-main.jpg")
            .into(binding.imageViewShaman)
    }
}
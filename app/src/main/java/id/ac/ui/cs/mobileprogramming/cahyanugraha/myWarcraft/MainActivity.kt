package id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    private lateinit var profileImageView: ImageView
    private lateinit var profileImageShowButton: Button
    private lateinit var profileImageCloseButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.profileImageView = findViewById(R.id.profileImage)
        this.profileImageShowButton = findViewById(R.id.profileImageShowButton)
        this.profileImageCloseButton = findViewById(R.id.profileImageCloseButton)

        this.profileImageShowButton.setOnClickListener {
            onClickProfileImageShowButton()
        }
        this.profileImageCloseButton.setOnClickListener {
            onClickProfileImageCloseButton()
        }
    }

    private fun onClickProfileImageShowButton() {
        val profileImageURL: String = "https://render-us.worldofwarcraft.com/character/nagrand/110/193182574-main.jpg"
        Picasso.get().load(profileImageURL).into(this.profileImageView)
        this.profileImageView.visibility = View.VISIBLE
        this.profileImageCloseButton.visibility = View.VISIBLE
        this.profileImageShowButton.visibility = View.GONE
    }

    private fun onClickProfileImageCloseButton() {
        this.profileImageView.visibility = View.GONE
        this.profileImageCloseButton.visibility = View.GONE
        this.profileImageShowButton.visibility = View.VISIBLE
    }
}
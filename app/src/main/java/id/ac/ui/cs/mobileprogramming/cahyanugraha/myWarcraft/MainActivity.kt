package id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var profileImageView: ImageView
    lateinit var profileImageShowButton: Button
    lateinit var profileImageCloseButton: Button
    lateinit var goToTimerActivityButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.profileImageView = findViewById(R.id.profileImage)
        this.profileImageShowButton = findViewById(R.id.profileImageShowButton)
        this.profileImageCloseButton = findViewById(R.id.profileImageCloseButton)
        this.goToTimerActivityButton = findViewById(R.id.goToTimerActivityButton)

        this.profileImageShowButton.setOnClickListener {
            val profileImageURL: String = "https://render-us.worldofwarcraft.com/character/nagrand/110/193182574-main.jpg"
            Picasso.get().load(profileImageURL).into(this.profileImageView)
            this.profileImageView.visibility = View.VISIBLE
            this.profileImageCloseButton.visibility = View.VISIBLE
            this.profileImageShowButton.visibility = View.GONE
        }
        this.profileImageCloseButton.setOnClickListener {
            this.profileImageView.visibility = View.GONE
            this.profileImageCloseButton.visibility = View.GONE
            this.profileImageShowButton.visibility = View.VISIBLE
        }
        this.goToTimerActivityButton.setOnClickListener {
            val intent = Intent(this, TimerActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        println("PRESSED!")
        val alertBuilder = AlertDialog.Builder(this)
        alertBuilder.apply {
            setTitle(R.string.main_activity_on_back_pressed_title)
            setPositiveButton(R.string.main_activity_on_back_pressed_ok,
                DialogInterface.OnClickListener { _, _ ->
                    super.onBackPressed()
                })
            setNegativeButton(R.string.main_activity_on_back_pressed_cancel,
                DialogInterface.OnClickListener { dialog, _ ->
                    dialog.dismiss()
                })
        }
        alertBuilder.create()
        alertBuilder.show()
    }
}
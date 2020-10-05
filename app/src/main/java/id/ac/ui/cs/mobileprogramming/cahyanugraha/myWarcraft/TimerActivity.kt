package id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft

import android.content.Intent
import android.content.Intent.FLAG_ACTIVITY_REORDER_TO_FRONT
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_timer.*

class TimerActivity : AppCompatActivity() {
    lateinit var timerTextView: TextView
    lateinit var plusButton: Button
    lateinit var minusButton: Button
    lateinit var startButton: Button
    lateinit var goToMainActivityButton: Button
    lateinit var timerViewModel: TimerViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        // Set views
        this.timerTextView = findViewById(R.id.timerTextView)
        this.plusButton = findViewById(R.id.plusButton)
        this.minusButton = findViewById(R.id.minusButton)
        this.startButton = findViewById(R.id.startButton)
        this.goToMainActivityButton = findViewById(R.id.goToMainActivityButton)

        // Set viewModel
        this.timerViewModel = ViewModelProvider(this).get(TimerViewModel::class.java)
        this.timerViewModel.resetCountdown()
        this.timerViewModel.setTimerNotRunning()

        this.timerViewModel.getCountdown().observe(this, Observer<Int?>{countdown ->
            this.timerTextView.text = if (countdown == null) "0 seconds" else "$countdown seconds"
        })

        this.timerViewModel.getTimerState().observe(this, Observer<Int?>{timerState ->
            if (timerState == 2) {
                this.timerViewModel.setTimerNotRunning()
                Toast
                    .makeText(this, "Timer Finished!", Toast.LENGTH_SHORT)
                    .show()
            }
        })

        this.plusButton.setOnClickListener {
            if (this.timerViewModel.isTimerRunning()) {
                Toast
                    .makeText(this, "Timer is still running!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                this.timerViewModel.incrementCountdown()
            }
        }

        this.minusButton.setOnClickListener {
            if (this.timerViewModel.isTimerRunning()) {
                Toast
                    .makeText(this, "Timer is still running!", Toast.LENGTH_SHORT)
                    .show()
            } else {
                this.timerViewModel.decrementCountdown()
            }
        }

        this.startButton.setOnClickListener {
            when {
                this.timerViewModel.isTimerRunning() -> Toast
                    .makeText(this, "Timer is still running!", Toast.LENGTH_SHORT)
                    .show()
                this.timerViewModel.isCountdownNegativeOrZero() -> Toast
                    .makeText(this, "Countdown cannot be zero or negative!", Toast.LENGTH_SHORT)
                    .show()
                else -> this.timerViewModel.startCountdown()
            }
        }

        this.goToMainActivityButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.flags = FLAG_ACTIVITY_REORDER_TO_FRONT
            startActivity(intent)
        }
    }
}
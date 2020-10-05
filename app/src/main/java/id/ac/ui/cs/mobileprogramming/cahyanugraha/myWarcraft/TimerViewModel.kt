package id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft

import android.os.CountDownTimer
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TimerViewModel: ViewModel() {
    private var countdown: MutableLiveData<Int> = MutableLiveData()
    // timerState possible value are 0, 1, and 2
    // 0 denote that the timer is not running and the activity using this viewModel acknowledge that
    // 1 denote that the timer is running
    // 2 denote that the timer is just finished but the activity not yet acknowledge that
    private var timerState: MutableLiveData<Int> = MutableLiveData()

    fun startCountdown() {
        val setCountdownValue = this.countdown.value!!
        val timer = object: CountDownTimer(setCountdownValue.toLong() * 1000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                countdown.value = countdown.value!! - 1
            }

            override fun onFinish() {
                timerState.value = 2
            }
        }
        timerState.value = 1
        timer.start()
    }

    fun getCountdown(): MutableLiveData<Int> {
        return countdown
    }

    fun resetCountdown() {
        this.countdown.value = 0
    }

    fun getTimerState(): MutableLiveData<Int> {
        return timerState
    }

    fun setTimerNotRunning() {
        this.timerState.value = 0
    }

    fun incrementCountdown() {
        this.countdown.value = this.countdown.value?.plus(1)
    }

    fun decrementCountdown() {
        this.countdown.value = this.countdown.value?.minus(1)
    }

    fun isTimerRunning(): Boolean {
        return timerState.value != 0
    }

    fun isCountdownNegativeOrZero(): Boolean {
        return countdown.value!! <= 0
    }
}
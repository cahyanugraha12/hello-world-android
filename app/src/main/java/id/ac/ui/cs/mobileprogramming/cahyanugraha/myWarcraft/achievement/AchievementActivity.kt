package id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft.achievement

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft.achievement.ui.achievement.AchievementListFragment
import id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft.achievement.ui.achievement.AchievementDetailFragment
import id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft.R

class AchievementActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.achievement_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, AchievementListFragment.newInstance())
                .commitNow()
        }
    }
}
package id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft.achievement.ui.achievement

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft.achievement.data.model.Achievement

class AchievementViewModel : ViewModel() {
    private val AchievementList: List<Achievement> = listOf(
        Achievement(
            "Exploration",
            "Pandaria Explorer",
            "Explore the regions of Pandaria.",
            "https://render-us.worldofwarcraft.com/icons/56/expansionicon_mistsofpandaria.jpg"),
        Achievement(
            "Pandaria",
            "Loremaster of Pandaria",
            "Complete the Pandaria quest achievements.",
            "https://render-us.worldofwarcraft.com/icons/56/expansionicon_mistsofpandaria.jpg"),
        Achievement(
            "Battle for Azeroth",
            "Kul Tirans Don't Look at Explosions",
            "Complete the quest \"Express Delivery\" in the Alliance War Campaign.",
            "https://render-us.worldofwarcraft.com/icons/56/achievement_alliedrace_kultiranhuman.jpg"),
        Achievement(
            "Battle for Azeroth",
            "The Fourth War",
            "Complete the War Campaign in Battle for Azeroth.",
            "https://render-us.worldofwarcraft.com/icons/56/inv_tabard_battlepvps4_alliance.jpg"),
        Achievement(
            "Battle for Azeroth",
            "Champions of Azeroth",
            "Earn Exalted Status with the Champions of Azeroth.",
            "https://render-us.worldofwarcraft.com/icons/56/inv_faction_championsofazeroth.jpg")
    )
    private var CurrentAchievementId: MutableLiveData<Int> = MutableLiveData(1)

    fun getAchievementTitleList(): MutableList<String> {
        val titleList = mutableListOf<String>()
        this.AchievementList.forEach { achievement ->
            titleList.add(achievement.name)
        }
        return titleList
    }

    fun getAchievementById(id: Int): Achievement? {
        return this.AchievementList[id]
    }

    fun getCurrentAchievementId(): MutableLiveData<Int> {
        return this.CurrentAchievementId
    }

    fun setCurrentAchievementId(id: Int) {
        println("NEW ID : $id")
        println(this.CurrentAchievementId.value)
        this.CurrentAchievementId.value = id
        println(this.CurrentAchievementId.value!!)
    }
}
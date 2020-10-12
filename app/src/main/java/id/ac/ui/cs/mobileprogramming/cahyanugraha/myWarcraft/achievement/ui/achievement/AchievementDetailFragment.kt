package id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft.achievement.ui.achievement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft.databinding.AchievementDetailFragmentBinding

class AchievementDetailFragment : Fragment() {

    companion object {
        fun newInstance() = AchievementDetailFragment()
    }

    private var _binding: AchievementDetailFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AchievementViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AchievementDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(AchievementViewModel::class.java)

        viewModel.getCurrentAchievementId().observe(viewLifecycleOwner, Observer<Int?>{ id ->
            val currentAchievementDetails = id?.let { idNotNull -> viewModel.getAchievementById(idNotNull) }
            currentAchievementDetails?.let { curAchievement ->
                binding.achievementCategoryText.text = curAchievement.category
                binding.achievementNameText.text = curAchievement.name
                binding.achievementDescriptionText.text = curAchievement.description
                Picasso
                    .get()
                    .load(curAchievement.imageLink)
                    .resize(400, 400)
                    .into(binding.achievementImage)
            }
        })
    }

}
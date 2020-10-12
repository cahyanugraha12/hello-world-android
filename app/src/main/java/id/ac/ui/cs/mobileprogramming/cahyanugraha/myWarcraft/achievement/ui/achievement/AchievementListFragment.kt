package id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft.achievement.ui.achievement

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft.R
import id.ac.ui.cs.mobileprogramming.cahyanugraha.myWarcraft.databinding.AchievementListFragmentBinding

class AchievementListFragment : Fragment() {

    companion object {
        fun newInstance() = AchievementListFragment()
    }

    private var _binding: AchievementListFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: AchievementViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AchievementListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(requireActivity()).get(AchievementViewModel::class.java)

        val achievementTitleArray = viewModel.getAchievementTitleList()
        val adapter = context?.let { ArrayAdapter(it, android.R.layout.simple_list_item_1, achievementTitleArray) }
        binding.achievementList.adapter = adapter
        binding.achievementList.setOnItemClickListener { _, _, position, _ ->
            viewModel.setCurrentAchievementId(position)
            parentFragmentManager.beginTransaction()
                .replace(R.id.container, AchievementDetailFragment.newInstance())
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
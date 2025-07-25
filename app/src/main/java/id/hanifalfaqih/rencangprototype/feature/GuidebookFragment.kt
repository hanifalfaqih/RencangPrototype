package id.hanifalfaqih.rencangprototype.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import id.hanifalfaqih.rencangprototype.R
import id.hanifalfaqih.rencangprototype.databinding.FragmentGuidebookBinding

class GuidebookFragment : Fragment() {

    private var _binding: FragmentGuidebookBinding? = null
    private val binding get() = _binding!!

    private lateinit var guidebookAdapter: GuidebookAdapter
    private val problemList = listOf(
        ProblemGuideItem(R.drawable.ic_leaf, "Yellow Leaves"),
        ProblemGuideItem(R.drawable.ic_bug, "White Pests"),
        ProblemGuideItem(R.drawable.ic_leaf, "Wilting"),
        ProblemGuideItem(R.drawable.ic_water_drop, "Overwatering"), // Consider a more relevant icon if available
        ProblemGuideItem(R.drawable.ic_water_drop, "Leaf Spots"),
        ProblemGuideItem(R.drawable.ic_water_drop, "Dry Soil")
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGuidebookBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()

        // TODO: Implement SearchView functionality
    }

    private fun setupRecyclerView() {
        guidebookAdapter = GuidebookAdapter(problemList)
        binding.rvGuidebookGrid.apply {
            layoutManager = GridLayoutManager(requireContext(), 2)
            adapter = guidebookAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

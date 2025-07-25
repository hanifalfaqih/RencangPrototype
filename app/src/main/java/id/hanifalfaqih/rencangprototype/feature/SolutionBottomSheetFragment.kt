package id.hanifalfaqih.rencangprototype.feature

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import id.hanifalfaqih.rencangprototype.R
import id.hanifalfaqih.rencangprototype.databinding.BottomSheetSolutionBinding // Import ViewBinding

class SolutionBottomSheetFragment : BottomSheetDialogFragment() {

    private var _binding: BottomSheetSolutionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetSolutionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val problemName = arguments?.getString(ARG_PROBLEM_NAME)

        binding.tvProblemTitleDetail.text = problemName
        binding.btnCloseSheet.setOnClickListener {
            dismiss()
        }

        // Populate content based on problemName
        when (problemName) {
            "Yellow Leaves" -> {
                binding.ivProblemIconDetail.setImageResource(R.drawable.ic_leaf) // Example
                binding.tvCausesBody.text = "Usually caused by lack of nutrients, especially nitrogen, or improper watering."
                // Clear previous steps if any
                binding.llSolutionSteps.removeAllViews()
                addSolutionStep("Immediate Action: Spray with a light compost tea.")
                addSolutionStep("Soil Health: Add a layer of organic compost around the plant base to provide long-term nutrition.")
                addSolutionStep("Prevention: Plant nitrogen-fixing companion plants like beans nearby in the next cycle.")
            }
            "White Pests" -> {
                binding.ivProblemIconDetail.setImageResource(R.drawable.ic_bug) // Example
                binding.tvCausesBody.text = "Often aphids or whiteflies, sucking sap from the plant."
                binding.llSolutionSteps.removeAllViews()
                addSolutionStep("Spray with insecticidal soap or neem oil.")
                addSolutionStep("Introduce beneficial insects like ladybugs.")
            }
            // Add more cases for other problems
            else -> {
                binding.ivProblemIconDetail.setImageResource(R.drawable.ic_leaf) // Default
                binding.tvCausesBody.text = "Could be due to various reasons such as under-watering, over-watering, or disease."
                binding.llSolutionSteps.removeAllViews()
                addSolutionStep("Check soil moisture first.")
                addSolutionStep("Ensure proper drainage.")
            }
        }
    }

    private fun addSolutionStep(solutionText: String) {
        val textView = TextView(context).apply {
            text = solutionText
            setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_checkmark_circle_green, 0, 0, 0)
            compoundDrawablePadding = resources.getDimensionPixelSize(R.dimen.drawable_padding_small) // Example padding
            setTextAppearance(com.google.android.material.R.style.TextAppearance_Material3_BodyMedium)
            layoutParams = LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                bottomMargin = resources.getDimensionPixelSize(R.dimen.solution_step_margin_bottom) // Example margin
            }
        }
        binding.llSolutionSteps.addView(textView)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        const val TAG = "SolutionBottomSheet"
        private const val ARG_PROBLEM_NAME = "problem_name"

        fun newInstance(problemName: String): SolutionBottomSheetFragment {
            val args = Bundle()
            args.putString(ARG_PROBLEM_NAME, problemName)
            val fragment = SolutionBottomSheetFragment()
            fragment.arguments = args
            return fragment
        }
    }
}

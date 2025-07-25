package id.hanifalfaqih.rencangprototype.feature

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import id.hanifalfaqih.rencangprototype.R
import id.hanifalfaqih.rencangprototype.databinding.ItemGuidebookCardBinding

class GuidebookAdapter(private val problemList: List<ProblemGuideItem>) :
    RecyclerView.Adapter<GuidebookAdapter.GuidebookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GuidebookViewHolder {
        val binding = ItemGuidebookCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GuidebookViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GuidebookViewHolder, position: Int) {
        val problem = problemList[position]
        holder.bind(problem)
    }

    override fun getItemCount(): Int = problemList.size

    inner class GuidebookViewHolder(private val binding: ItemGuidebookCardBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(problem: ProblemGuideItem) {
            binding.ivProblemIcon.setImageResource(problem.iconResId)
            // Set icon tint to green
            binding.ivProblemIcon.setColorFilter(ContextCompat.getColor(itemView.context, R.color.green)) // Ensure R.color.green is defined
            binding.tvProblemName.text = problem.name

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "Clicked on: ${problem.name}", Toast.LENGTH_SHORT).show()
                val clickedProblem = problemList[adapterPosition] // Use adapterPosition for safety
                // THE KEY CHANGE IS HERE:
                val bottomSheet = SolutionBottomSheetFragment.newInstance(clickedProblem.name)
                val activity = itemView.context as? AppCompatActivity
                activity?.supportFragmentManager?.let { fragmentManager ->
                    bottomSheet.show(fragmentManager, SolutionBottomSheetFragment.TAG)
                }
            }
        }
    }
}

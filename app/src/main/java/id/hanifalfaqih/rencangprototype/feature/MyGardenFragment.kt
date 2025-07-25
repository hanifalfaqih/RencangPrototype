package id.hanifalfaqih.rencangprototype.feature

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import id.hanifalfaqih.rencangprototype.data.PlantJourneyRepository
import id.hanifalfaqih.rencangprototype.databinding.FragmentMyGardenBinding
import java.util.Calendar

/**
 * A simple [Fragment] subclass.
 */
class MyGardenFragment : Fragment() {

    private var _binding: FragmentMyGardenBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    private var currentDay: Int = 1
    private val totalDays by lazy { PlantJourneyRepository.getTotalDays() }
    private lateinit var sharedPrefs: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyGardenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize SharedPreferences
        sharedPrefs = requireActivity().getSharedPreferences("GARDEN_PREFS", Context.MODE_PRIVATE)

        // Load saved progress
        loadProgress()

        // Set up the button click listener with time-locking logic
        binding.btnCompleteTask.setOnClickListener {
            if (isTaskAvailable()) {
                // Update progress
                currentDay++
                saveProgress(System.currentTimeMillis())

                // Update UI and show feedback
                updateUi()
                Toast.makeText(requireContext(), "Kerja bagus! Sampai jumpa besok.", Toast.LENGTH_SHORT).show()
            }
        }

        // Perform the initial UI update
        updateUi()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateUi() {
        // Update greeting and progress text
        binding.tvGreeting.text = "Selamat Pagi! (Hari ke-$currentDay)"
        binding.tvDayCounter.text = "Hari ke-$currentDay dari $totalDays"
        binding.progressIndicator.max = totalDays
        binding.progressIndicator.progress = currentDay

        // Find and display the current task
        val task = PlantJourneyRepository.getTasks().find { it.day == currentDay }
        binding.tvTaskDescription.text = task?.taskDescription ?: "Perjalanan telah selesai!"
        // You can also update the task icon here if you have an ImageView

        // Control the button state based on time-lock
        if (currentDay > totalDays) {
            binding.btnCompleteTask.text = "Perjalanan Selesai!"
            binding.btnCompleteTask.isEnabled = false
            // Set button to a completed color (e.g., grey)
        } else if (isTaskAvailable()) {
            binding.btnCompleteTask.isEnabled = true
            binding.btnCompleteTask.text = "Tandai Selesai"
            // Set button to its active color (e.g., green)
        } else {
            binding.btnCompleteTask.isEnabled = false
            binding.btnCompleteTask.text = "Kembali Besok"
            // Set button to a disabled color (e.g., grey)
        }
    }

    private fun isTaskAvailable(): Boolean {
        val lastCompletionTimestamp = sharedPrefs.getLong("LAST_COMPLETION_TIMESTAMP", 0L)
        if (lastCompletionTimestamp == 0L) return true // First time user

        val lastCal = Calendar.getInstance().apply { timeInMillis = lastCompletionTimestamp }
        val currentCal = Calendar.getInstance()

        return currentCal.get(Calendar.DAY_OF_YEAR) > lastCal.get(Calendar.DAY_OF_YEAR) ||
                currentCal.get(Calendar.YEAR) > lastCal.get(Calendar.YEAR)
    }

    private fun saveProgress(timestamp: Long) {
        sharedPrefs.edit {
            putInt("CURRENT_DAY", currentDay)
            putLong("LAST_COMPLETION_TIMESTAMP", timestamp)
        }
    }

    private fun loadProgress() {
        currentDay = sharedPrefs.getInt("CURRENT_DAY", 1)
    }

}
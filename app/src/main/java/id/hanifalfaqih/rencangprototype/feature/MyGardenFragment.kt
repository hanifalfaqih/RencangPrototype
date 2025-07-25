package id.hanifalfaqih.rencangprototype.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import id.hanifalfaqih.rencangprototype.databinding.FragmentMyGardenBinding

/**
 * A simple [Fragment] subclass.
 * Use the [MyGardenFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyGardenFragment : Fragment() {

    private var _binding: FragmentMyGardenBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

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

        // Access views using binding
        // Example: binding.tvGreeting.text = "New Greeting"

        binding.btnCompleteTask.setOnClickListener {
            Toast.makeText(context, "Tugas telah ditandai selesai!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    // You can remove the newInstance companion object if not needed
    /*
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyGardenFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) = // Your existing newInstance code
            MyGardenFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    */
}
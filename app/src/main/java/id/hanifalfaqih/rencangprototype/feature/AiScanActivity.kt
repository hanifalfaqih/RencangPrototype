package id.hanifalfaqih.rencangprototype.feature

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.appbar.MaterialToolbar
import id.hanifalfaqih.rencangprototype.MainActivity
import id.hanifalfaqih.rencangprototype.R
import id.hanifalfaqih.rencangprototype.databinding.ActivityAiScanBinding

class AiScanActivity : AppCompatActivity() {
    private var _binding: ActivityAiScanBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityAiScanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.setNavigationOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
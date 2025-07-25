package id.hanifalfaqih.rencangprototype.feature

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import id.hanifalfaqih.rencangprototype.MainActivity
import id.hanifalfaqih.rencangprototype.R

class KitDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kit_detail)

        val kitName = intent.getStringExtra("KIT_NAME") ?: "Default Kit Name"
        val harvestTime = intent.getStringExtra("HARVEST_TIME") ?: "Default harvest time"
        val imageResId = intent.getIntExtra("EXTRA_IMAGE_RES_ID", R.drawable.ic_launcher_background) // Assuming you'll pass image too

        val tvKitTitle: TextView = findViewById(R.id.tv_kit_title)
        val tvKitSubtitle: TextView = findViewById(R.id.tv_kit_subtitle)
        val btnBack: ImageButton = findViewById(R.id.btn_back)
        val btnStartJourney: MaterialButton = findViewById(R.id.btn_start_journey)
        val ivKitHeaderImage: ImageView = findViewById(R.id.iv_kit_header_image) // If you want to set the image

        tvKitTitle.text = kitName
        tvKitSubtitle.text = harvestTime
        ivKitHeaderImage.setImageResource(imageResId) // If you pass and set image

        btnBack.setOnClickListener {
            finish()
        }

        btnStartJourney.setOnClickListener {
            Toast.makeText(this, "Navigating to Dashboard...", Toast.LENGTH_SHORT).show()
            // Intent to navigate to DashboardActivity can be added here
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}
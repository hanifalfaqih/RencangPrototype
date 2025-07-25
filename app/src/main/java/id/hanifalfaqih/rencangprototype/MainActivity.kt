package id.hanifalfaqih.rencangprototype

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.hanifalfaqih.rencangprototype.feature.GuidebookFragment
import id.hanifalfaqih.rencangprototype.feature.JournalFragment
import id.hanifalfaqih.rencangprototype.feature.MyGardenFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, MyGardenFragment()).commit()
        }

        bottomNav.setOnItemSelectedListener { item ->
            val selectedFragment: Fragment = when (item.itemId) {
                R.id.navigation_journal -> JournalFragment()
                R.id.navigation_guidebook -> GuidebookFragment()
                else -> MyGardenFragment() // Default to MyGardenFragment
            }
            supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment, selectedFragment).commit()
            true
        }
    }
}
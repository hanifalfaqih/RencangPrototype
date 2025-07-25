package id.hanifalfaqih.rencangprototype.feature

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import id.hanifalfaqih.rencangprototype.R

class ChooseKitActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_kit)

        val recyclerView: RecyclerView = findViewById(R.id.rv_kit_list)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val kitList = createDummyData()
        val adapter = KitAdapter(kitList)
        recyclerView.adapter = adapter
    }

    private fun createDummyData(): List<PlantingKit> {
        return listOf(
            PlantingKit(R.drawable.ic_launcher_background, "Spicy Chili Kit", "Harvest in 28 days"),
            PlantingKit(R.drawable.ic_launcher_background, "Speedy Kangkung Kit", "Harvest in 21 days"),
            PlantingKit(R.drawable.ic_launcher_background, "Cherry Tomato Kit", "Harvest in 35 days"),
            PlantingKit(R.drawable.ic_launcher_background, "Crispy Lettuce Kit", "Harvest in 25 days")
        )
    }
}
package id.hanifalfaqih.rencangprototype.feature

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.hanifalfaqih.rencangprototype.R

class KitAdapter(private val plantingKits: List<PlantingKit>) :
    RecyclerView.Adapter<KitAdapter.KitViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_kit_card, parent, false)
        return KitViewHolder(view)
    }

    override fun onBindViewHolder(holder: KitViewHolder, position: Int) {
        val kit = plantingKits[position]
        holder.bind(kit)
    }

    override fun getItemCount(): Int = plantingKits.size

    inner class KitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val kitImage: ImageView = itemView.findViewById(R.id.iv_kit_image)
        private val kitTitle: TextView = itemView.findViewById(R.id.tv_kit_title)
        private val harvestTime: TextView = itemView.findViewById(R.id.tv_harvest_time)

        fun bind(kit: PlantingKit) {
            kitImage.setImageResource(kit.imageResId)
            kitTitle.text = kit.title
            harvestTime.text = kit.harvestTime

            itemView.setOnClickListener {
                val context = itemView.context
                val intent = Intent(context, KitDetailActivity::class.java)
                // Anda bisa mengirim data ke KitDetailActivity jika diperlukan
                 intent.putExtra("KIT_NAME", kit.title)
                 intent.putExtra("HARVEST_TIME", kit.harvestTime)
                context.startActivity(intent)
            }
        }
    }
}
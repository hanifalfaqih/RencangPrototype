package id.hanifalfaqih.rencangprototype.data

import id.hanifalfaqih.rencangprototype.R
import id.hanifalfaqih.rencangprototype.model.DailyTask

// Kita menggunakan 'object' agar hanya ada satu instance dari Repository ini (singleton)
object PlantJourneyRepository {

    fun getTotalDays(): Int {
        return getTasks().size
    }

    // Fungsi ini berisi semua daftar tugas untuk perjalanan menanam cabai
    fun getTasks(): List<DailyTask> {
        return listOf(
            DailyTask(
                day = 1,
                taskDescription = "Siram media tanam hingga lembab, lalu taburkan 3-4 bibit cabai.",
                iconResId = R.drawable.ic_water_drop
            ),
//            DailyTask(
//                day = 2,
//                taskDescription = "Jaga media tanam tetap lembab. Cukup semprot dengan sedikit air.",
//                iconResId = R.drawable.ic_water_drop
//            ),
//            DailyTask(
//                day = 3,
//                taskDescription = "Observasi bibit. Belum ada yang perlu dilakukan selain menjaga kelembaban.",
//                iconResId = R.drawable.ic_observe
//            ),
//            DailyTask(
//                day = 4,
//                taskDescription = "Pastikan pot mendapat cukup cahaya matahari pagi, tapi tidak terlalu terik.",
//                iconResId = R.drawable.ic_observe
//            ),
//            DailyTask(
//                day = 5,
//                taskDescription = "Siram sedikit di pagi hari. Kelembaban adalah kunci di fase awal.",
//                iconResId = R.drawable.ic_water_drop
//            ),
//            DailyTask(
//                day = 6,
//                taskDescription = "Hari istirahat. Biarkan alam bekerja.",
//                iconResId = R.drawable.ic_observe
//            ),
//            DailyTask(
//                day = 7,
//                taskDescription = "Beri 1/4 sendok teh pupuk organik (kompos) di sekitar media tanam.",
//                iconResId = R.drawable.ic_fertilizer
//            )
            // ... Anda bisa menambahkan tugas untuk hari-hari berikutnya di sini
        )
    }
}
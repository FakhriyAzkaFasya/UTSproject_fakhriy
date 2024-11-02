package lat.pam.utsproject

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FoodAdapter
    private lateinit var foodList: List<Food>
    private lateinit var searchRecyclerView: RecyclerView
    private lateinit var searchButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_list_food)


        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Menyiapkan data makanan
        foodList = listOf(
            Food("Batagor", "Rp 5.000", R.drawable.batagor),
            Food("Black Salad", "Rp 10.000", R.drawable.black_salad),
            Food("Cappucino", "Rp 7.000", R.drawable.cappuchino),
            Food("Kopi Hitam", "Rp 5.000", R.drawable.kopi_hitam),
            Food("Es Kelapa", "Rp 6.000", R.drawable.es_kelapa),
            Food("CheeseCake", "Rp 6.000", R.drawable.cheesecake),
            Food("Donut", "Rp 4.000", R.drawable.donut),
            Food("Mochi", "Rp 3.000", R.drawable.mochi),
            Food("Bakpao Coklat", "Rp 2.000", R.drawable.bakpao_coklat),
            Food("Risoles Mayo", "Rp 3.000", R.drawable.risol),
            Food("Cireng Ayam", "Rp 2.000", R.drawable.cireng_ayam)
        )

        adapter = FoodAdapter(foodList, this::OnFoodItemClick)
        recyclerView.adapter = adapter


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        searchRecyclerView = findViewById(R.id.recyclerView)
    }

    private fun OnFoodItemClick(food: Food) {
        val intent = Intent(this, OrderActivity::class.java)
        intent.putExtra("foodName", food.name)
        startActivity(intent)
    }
}
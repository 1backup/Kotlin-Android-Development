import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinandoridpratice.Adapter.ItemAdapter

// on going recylcer view
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rec: RecyclerView = findViewById(R.id.recyclerView)
        /*
        * steps
        * 1. set the layout
        * 2. send the value to the adapter
        * 3. set the adapter
        * */

       /*
       * different list  design
       *  1. for horizontal
       *         rec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
       * 2. for vertical
       *         rec.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
       *
       *for grid view
       *
       * 1. pass context and the number of column you want
       *               rec.layoutManager = GridLayoutManager(this,2)
       *
       * for both
       *
       *
       * */

        rec.layoutManager = LinearLayoutManager(this)
        val itemAdapter = ItemAdapter(this, getItemsList())
        rec.adapter = itemAdapter

    }

    private fun getItemsList(): ArrayList<String>{
        val list = ArrayList<String>()
        for (i in 1..15){
            list.add("Item $i")
        }
        return list
    }


}

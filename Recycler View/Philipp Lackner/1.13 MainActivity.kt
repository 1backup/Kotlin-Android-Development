import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinrecyclerview.databinding.ActivityMainBinding
import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi


class MainActivity : AppCompatActivity() {
    private  lateinit var  binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var toDoList = mutableListOf(ToDo("Demo", false)) // demo list. Opens every time you start the app

        val adapter = ToDoAdapter(toDoList) // setting the list to the adapter
        binding.rv.adapter = adapter // setting the adapter
        binding.rv.layoutManager= LinearLayoutManager(this) //setting the lay out manager.

        binding.add.setOnClickListener {
            val title = binding.etTodo.text.toString()
            val todo = ToDo(title, false)
            toDoList.add(todo)
            adapter.notifyItemInserted(toDoList.size-1) // notifying data set changed
            dismissKeyboard(this)
            //adapter.notifyDataSetChanged()  > not recommended becasue it will go through all the items
        }
    }

    // keeps the keyboard down when you press
    @RequiresApi(Build.VERSION_CODES.M)
    fun dismissKeyboard(activity: Activity) {
        val imm: InputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        if (null != activity.currentFocus) imm.hideSoftInputFromWindow(
            activity.currentFocus!!
                .applicationWindowToken, 0
        )
    }

}

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinrecyclerview.databinding.ItemTodoBinding

class ToDoAdapter(var todos: List<ToDo>): RecyclerView.Adapter<ToDoAdapter.ToDoViewHolder>()
{
    /*
    * steps
    * 1. create a inner class(used viewBinding). which holds the view of items_todo.xml
    * 2. onCreateViewHolder > inflate the layout
    * 3. onBindViewHolder> access all the items of the custom list row
    * 4.  getItemCount()>  returns the list size
    * */
    inner class ToDoViewHolder(val binding: ItemTodoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ToDoViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemTodoBinding.inflate(layoutInflater, parent, false)
        return ToDoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ToDoViewHolder, position: Int) {
        holder.binding.apply {
            tvTitle.text = todos[position].title
            tvDone.isChecked = todos[position].isChecked
        }
    }
    override fun getItemCount(): Int {
        return todos.size
    }
}

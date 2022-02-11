import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinandoridpratice.R

/*
* when we took array
* class ItemAdapter(val context: Context, val items: ArrayList<String>) :
* RecyclerView.Adapter<ItemAdapter.ViewHolder>() {
* */
class ItemAdapter(val context: Context, val items: ArrayList<String>) :
    RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    /*
    * Notes
    * 1. take the context and the value you need in your class as a parameter
    * 2. Expand the class with Recycler View Adapter
    * 3. Import
    * 4. >onCreateViewHolder< declare the custom row lay out
    * 5. > class ViewHolder < findviewBy Id - all the necessary things
    * 6. > onBindViewHolder < use holder and get txt,btn from ViewHolder class and perform what action you want
    * 7. > getItemCount < just get the number of items
    * 8. > connect the recycler view to adapter in main activity.
    * */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {
        return  ViewHolder(
            LayoutInflater.from(context).inflate(
                R.layout.item_custom_row,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemAdapter.ViewHolder, position: Int) {

        val item = items.get(position)

        holder.tvItem.text = item // tv item came from the below viewholder class

        if(position %2 == 0){
            holder.cardViewItem.setBackgroundColor(
                ContextCompat.getColor(context, R.color.white)
            )
        }
        else{
            holder.cardViewItem.setBackgroundColor(
                ContextCompat.getColor(context, R.color.teal_700)
            )
        }
    }

    override fun getItemCount(): Int {
        return items.size
    } // returns the item of the list.

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // Holds the TextView that will add each item to
        // add all the element in the custom row.
        val tvItem = view.findViewById<TextView>(R.id.tv_item_name)
        val cardViewItem = view.findViewById<CardView>(R.id.card_view_item)
    }

}

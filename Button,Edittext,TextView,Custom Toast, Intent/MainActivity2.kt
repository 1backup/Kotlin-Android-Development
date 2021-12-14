import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var bundle: Bundle = intent.extras!!

        val id = bundle.get("id").toString()
        var name = bundle.get("name").toString()

        Toast.makeText(applicationContext,id+" : "+name ,Toast.LENGTH_SHORT).show()
    }
}

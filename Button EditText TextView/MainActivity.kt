class MainActivity : AppCompatActivity() {

    private  lateinit var  binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            var given_text: String = binding.editText.text.toString()

            if (given_text == null || given_text.trim() == "")
                Toast.makeText(this,"please input data, edit text cannot be blank",Toast.LENGTH_SHORT).show()
            else
                binding.textView4.setText(given_text)
        }


        binding.textView5.setOnClickListener {
            binding.editText.setText("")
            binding.textView4.setText("Text View")
        }

        /*binding.editText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Toast.makeText(applicationContext,"executed before making any change over EditText",Toast.LENGTH_SHORT).show()
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                Toast.makeText(applicationContext,"executed while making any change over EditText",Toast.LENGTH_SHORT).show()
            }
            override fun afterTextChanged(p0: Editable?) {
                Toast.makeText(applicationContext,"executed after change made over EditText",Toast.LENGTH_SHORT).show()
            }
        })*/
    }
}

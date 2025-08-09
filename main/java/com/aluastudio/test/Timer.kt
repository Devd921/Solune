class TimerActivity : AppCompatActivity() {

    private lateinit var hourPicker: NumberPicker
    private lateinit var minutePicker: NumberPicker
    private lateinit var secondPicker: NumberPicker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        hourPicker = findViewById(R.id.hourPicker)
        minutePicker = findViewById(R.id.minutePicker)
        secondPicker = findViewById(R.id.secondPicker)

        hourPicker.setFormatter { value -> String.format("%02d", value) }
        minutePicker.setFormatter { value -> String.format("%02d", value) }
        secondPicker.setFormatter { value -> String.format("%02d", value) }
    }
}

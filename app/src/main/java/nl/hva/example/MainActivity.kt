package nl.hva.example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import nl.hva.example.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val correctAnswer: String = "Giraffe"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            checkAnswer()
        }
    }

    private fun checkAnswer() {
        val givenAnswer = binding.etAnswer.text.toString().lowercase()

        val message = if (givenAnswer == correctAnswer.lowercase()) {
            getString(R.string.correct)
        } else {
            getString(R.string.incorrect) + " " + correctAnswer
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}
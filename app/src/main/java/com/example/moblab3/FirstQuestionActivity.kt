package com.example.moblab3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.moblab3.databinding.ActivityFirstQuestionBinding

class FirstQuestionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstQuestionBinding

    var correct = 0;
    var incorrect = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFirstQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        correct = intent.getIntExtra(Answer.CORRECT, correct)
        incorrect = intent.getIntExtra(Answer.INCORRECT, incorrect)

        binding.button.setOnClickListener {
            checkAnswer()
            val intent = Intent(this, SecondQuestionActivity::class.java)
            intent.putExtra(Answer.CORRECT, correct)
            intent.putExtra(Answer.INCORRECT, incorrect)
            startActivity(intent)
        }
    }


    private fun checkAnswer() {
        if (binding.editText.text.toString() == resources.getString(R.string.correctQuestion1)) {
            correct++
        } else {
            incorrect++
        }
    }
}

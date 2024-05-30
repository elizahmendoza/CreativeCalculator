package com.example.creativecalculator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    //Options for both lists
    private val pet = arrayOf("Dog", "Cat", "Bird")
    private val character = arrayOf("Batman", "Superman", "Captain America", "Sexy Nurse", "Robin")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Adapters values
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, pet)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, character)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item)

        //Variables
        val b1 = findViewById<Button>(R.id.button)
        val characterlist = findViewById<Spinner>(R.id.spinner2)
        val petlist = findViewById<Spinner>(R.id.spinner)

        //First Spinner
        characterlist.adapter = adapter2
        characterlist.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {}
        }

        //Second Spinner
        petlist.adapter = adapter
        petlist.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {}
        }

        //Result list
        b1.setOnClickListener {
            val characterPosition = characterlist.selectedItemPosition
            val petPosition = petlist.selectedItemPosition
            var resultText = ""
            var imageResId = 0

            //Dog
            if (characterPosition == 0 && petPosition == 0) {
                resultText = "Here is a Batman Dog :D"
                imageResId = R.drawable.batman_dog
            }
            if (characterPosition == 1 && petPosition == 0) {
                resultText = "Here is a Superman Dog :)"
                imageResId = R.drawable.superman_dog
            }
            if (characterPosition == 2 && petPosition == 0) {
                resultText = "Here is a Captain America Dog <3"
                imageResId = R.drawable.captainamerica_dog
            }
            if (characterPosition == 3 && petPosition == 0) {
                resultText = "Here is a Nurse Dog <3"
                imageResId = R.drawable.nurse_dog
            }
            if (characterPosition == 4 && petPosition == 0) {
                resultText = "Here is a Robin Dog :3"
                imageResId = R.drawable.robin_dog
            }

            //Cat
            if (characterPosition == 0 && petPosition == 1) {
                resultText = "Here is a Batman cat :D"
                imageResId = R.drawable.batman_cat
            }
            if (characterPosition == 1 && petPosition == 1) {
                resultText = "Here is a Superman cat <3"
                imageResId = R.drawable.superman_cat
            }
            if (characterPosition == 2 && petPosition == 1) {
                resultText = "Here is a Captain America Cat :>"
                imageResId = R.drawable.captainamerica_cat
            }
            if (characterPosition == 3 && petPosition == 1) {
                resultText = "Here is a Nurse cat ^_^"
                imageResId = R.drawable.nurse_cat
            }
            if (characterPosition == 4 && petPosition == 1) {
                resultText = "Here is a Robin Cat :3"
                imageResId = R.drawable.robin_cat
            }

            //Bird
            if (characterPosition == 0 && petPosition == 2) {
                resultText = "Here is a Batman Bird :D"
                imageResId = R.drawable.batman_bird
            }
            if (characterPosition == 1 && petPosition == 2) {
                resultText = "Here is a Superman bird ^_^"
                imageResId = R.drawable.superman_bird
            }
            if (characterPosition == 2 && petPosition == 2) {
                resultText = "Here is a Captain America Bird :>"
                imageResId = R.drawable.captainamerica_bird
            }
            if (characterPosition == 3 && petPosition == 2) {
                resultText = "Here is a Nurse Bird <3"
                imageResId = R.drawable.nurse_bird
            }
            if (characterPosition == 4 && petPosition == 2) {
                resultText = "Here is a Robin Bird :3"
                imageResId = R.drawable.robin_bird
            }

            // Show the dialog with the result text and image
            showDialog(resultText, imageResId)
        }
    }


    private fun showDialog(resultText: String, imageResId: Int) {
        // Inflate the dialog with popup view
        val dialogView = LayoutInflater.from(this).inflate(R.layout.popup, null)
        val builder = AlertDialog.Builder(this).setView(dialogView)
        val dialog = builder.create()

        // Find views within the dialog
        val resultTextView = dialogView.findViewById<TextView>(R.id.result)
        val characterPhoto = dialogView.findViewById<ImageView>(R.id.characterPhoto)
        val okayButton: Button = dialogView.findViewById(R.id.okayButton)

        // Set the text for the result TextView and image for the flowerPhoto ImageView
        resultTextView.text = resultText
        characterPhoto.setImageResource(imageResId)

        okayButton.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
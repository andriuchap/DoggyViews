package edu.ktu.doggyviews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DogFragment : Fragment() {

    // List of dogs
    private val dogs = listOf(
        Dog(
            "Sparky",
            5,
            DogBreed.GERMAN_SHEPHERD,
            R.drawable.german_shepherd_192
        ),
        Dog(
            "Brian",
            7,
            DogBreed.LABRADOR_RETRIEVER,
            R.drawable.labrador_retriever_192
        ),
        Dog(
            "Walter",
            1,
            DogBreed.GOLDEN_RETRIEVER,
            R.drawable.golden_retriever_192
        )
    )

    // Currently shown dog
    private var dogIndex = 0

    // Views that are used to show a dog's info
    private lateinit var nameText: TextView
    private lateinit var ageText: TextView
    private lateinit var breedText: TextView
    private lateinit var breedImageView: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dog, container, false)

        // Assign references to the views we'll need
        nameText = view.findViewById(R.id.name_text)
        ageText = view.findViewById(R.id.age_text)
        breedText = view.findViewById(R.id.breed_text)
        breedImageView = view.findViewById(R.id.breed_img)

        // Set click listeners to buttons
        view.findViewById<Button>(R.id.next_btn).setOnClickListener {
            nextDog()
        }
        view.findViewById<Button>(R.id.prev_btn).setOnClickListener {
            previousDog()
        }

        // Return the inflated view
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Once the views are created, show the current dog
        showDog()
    }

    // Set dog data to each of the views in the layout
    private fun showDog() {
        nameText.text = dogs[dogIndex].name
        ageText.text = dogs[dogIndex].age.toString()
        breedText.text = dogs[dogIndex].breed.breedName
        breedImageView.setImageResource(dogs[dogIndex].imgResId)
    }

    // Show next dog
    private fun nextDog() {
        dogIndex++
        if (dogIndex > dogs.lastIndex)
            dogIndex = 0
        showDog()
    }

    // Show previous dog
    private fun previousDog() {
        dogIndex--
        if (dogIndex < 0)
            dogIndex = dogs.lastIndex
        showDog()
    }
}
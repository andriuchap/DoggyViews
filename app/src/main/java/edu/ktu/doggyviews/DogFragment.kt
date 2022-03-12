package edu.ktu.doggyviews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import edu.ktu.doggyviews.databinding.FragmentDogBinding

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

    private lateinit var binding : FragmentDogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDogBinding.inflate(inflater, container, false)

        // Set click listeners to buttons
        binding.nextBtn.setOnClickListener {
            nextDog()
        }
        binding.prevBtn.setOnClickListener {
            previousDog()
        }

        // Return the inflated view
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Once the views are created, show the current dog
        showDog()
    }

    // Set dog data to each of the views in the layout
    private fun showDog() {
        binding.nameText.text = dogs[dogIndex].name
        binding.ageText.text = dogs[dogIndex].age.toString()
        binding.breedText.text = dogs[dogIndex].breed.breedName
        binding.breedImg.setImageResource(dogs[dogIndex].imgResId)
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
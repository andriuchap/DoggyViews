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

    // Reference to the data binding object
    lateinit var binding : FragmentDogBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentDogBinding.inflate(inflater, container, false)
        // Set the fragment variable to enable click listeners on buttons
        binding.fragment = this
        // Return the root view of the binding
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Once the views are created, show the current dog
        showDog()
    }

    private fun showDog() {
        // All we have to do is set the dog variable for the binding
        // The layout itself will decide how to use the object
        binding.dog = dogs[dogIndex]
    }

    // Show next dog
    fun nextDog() {
        dogIndex++
        if (dogIndex > dogs.lastIndex)
            dogIndex = 0
        showDog()
    }

    // Show previous dog
    fun previousDog() {
        dogIndex--
        if (dogIndex < 0)
            dogIndex = dogs.lastIndex
        showDog()
    }
}
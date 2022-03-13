package edu.ktu.doggyviews

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

// Binding adapter for the dog's image
@BindingAdapter("dogImage")
fun ImageView.setDogImage(dog: Dog)
{
    setImageResource(dog.imgResId)
}

// Binding adapter for the dog's name
@BindingAdapter("dogName")
fun TextView.setDogName(dog: Dog)
{
    text = dog.name
}

// Binding adapter for the dog's breed
@BindingAdapter("dogBreed")
fun TextView.setDogBreed(dog: Dog)
{
    text = dog.breed.breedName
}

// Binding adapter for the dog's age
@BindingAdapter("dogAge")
fun TextView.setDogAge(dog: Dog){
    text = "${dog.age}"
}
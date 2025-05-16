package com.example.kisileruygulamasi.utils

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.kisileruygulamasi.R

fun Navigation.gecisYap(it:View ,id:Int){ //extension, bu lekilde ulaşabilcez artık uzunca yazmadan
    findNavController(it).navigate(id)}
fun Navigation.gecisYap(it:View ,id:NavDirections){ //overloading ,navdirection tipinde
    findNavController(it).navigate(id)
}
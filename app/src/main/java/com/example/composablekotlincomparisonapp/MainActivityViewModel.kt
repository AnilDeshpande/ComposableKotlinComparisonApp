package com.example.composablekotlincomparisonapp

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    val textCounter = MutableLiveData<Int>(0)
    val error = MutableLiveData<String>()

    var increaseCounter = {
        error.value = null
        textCounter.value = textCounter.value?.plus(1)
        Log.i("MainActivity", "Increase counter: $textCounter.value")
    }


    var decreaseCounter = {
        if(textCounter.value == 0 ){
            if (error.value == null){
                error.value = "Counter cannot be less than 0"
            } else {
                //do nothing
            }
        }else{
            textCounter.value = textCounter.value?.minus(1)
            Log.i("MainActivity", "Decrease counter: $textCounter.value")
        }

    }
}
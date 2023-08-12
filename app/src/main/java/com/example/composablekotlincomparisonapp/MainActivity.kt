package com.example.composablekotlincomparisonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

fun showToast(message: String, context: ComponentActivity){
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

@Composable
fun MainScreen(){

    val context = LocalContext.current as ComponentActivity

    var counter by remember {
        Log.i("MainActivity", "Counter initialized")
        mutableStateOf(0)
    }

    Log.i("MainActivity", "Counter value in function $counter")

    var increaseCounter = {
        counter++
        Log.i("MainActivity", "Increase counter: ${counter}")
    }


    var decreaseCounter = {
        if(counter == 0 ){
            showToast("Counter cannot be less than 0", context)
        }else{
            counter--
            Log.i("MainActivity", "Decrease counter: ${counter}")
        }
    }

    Surface (
        //Aligns the content of this component along the specified [alignment] lines.
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(1.dp)) {

            Row (
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Button(onClick = { decreaseCounter.invoke() },
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(20.dp)) {
                    Text(text = "Decrease")
                }

                Text(text = "${counter}", modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(20.dp))

                Button(onClick = { increaseCounter.invoke() },
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(20.dp)) {
                    Text(text = "Increase")
                }
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}


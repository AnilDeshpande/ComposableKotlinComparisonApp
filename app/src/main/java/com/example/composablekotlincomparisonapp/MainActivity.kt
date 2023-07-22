package com.example.composablekotlincomparisonapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen( MainActivityViewModel())
        }

    }
}

@Composable
fun MainScreen(mainActivityViewModel: MainActivityViewModel){


    mainActivityViewModel.textCounter.observeAsState().value?.let {
        //Log.i("MainActivity","Counter value is $it")
    }

    mainActivityViewModel.error.observeAsState().value?.let {
        it?.let {
            Toast.makeText(LocalContext.current, it.toString(), Toast.LENGTH_SHORT).show()
        }

    }

    Surface (
        //Aligns the content of this component along the specified [alignment] lines.
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(1.dp)) {

            Row (
                verticalAlignment = Alignment.CenterVertically,

                ) {
                Button(onClick = { mainActivityViewModel.decreaseCounter.invoke() },
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .padding(20.dp)) {
                    Text(text = "Decrease")
                }

                Text(text = "${mainActivityViewModel.textCounter.value}", modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(20.dp))

                Button(onClick = { mainActivityViewModel.increaseCounter.invoke() },
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
    MainScreen(MainActivityViewModel())
}


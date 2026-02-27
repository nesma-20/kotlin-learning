package com.example.compose_lec1.statability

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_lec1.firstApp.Greeting
import kotlinx.coroutines.launch

class ScaffoldActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()

        setContent {
Snackbar(){
    Greeting("Android")
}

            var textState by remember {
                mutableStateOf("")
            }
            val snackbarHostState = remember {
                SnackbarHostState()
            }
            val scope = rememberCoroutineScope()
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                snackbarHost = {
                    SnackbarHost(snackbarHostState)
                }
            ) { innerPadding ->
                Column(
                    modifier =
                        Modifier.fillMaxSize().padding(innerPaddi
                                ng),
                    horizontalAlignment =
                        Alignment.CenterHorizontally,
                    verticalArrangement =
                        Arrangement.Center
                )
                {
                    TextField(
                        value = textState,
                        onValueChange = { textState =
                            it },

                        label = { Text("Name") },
                        placeholder = {
                            Text("enter your name")
                        },
                        modifier =
                            Modifier.fillMaxWidth()
                                .padding(16.dp),
                        singleLine = true,
                        enabled = true,

                        )
                    Spacer(modifier =
                        Modifier.height(10.dp))
                    Button(onClick = {
                        scope.launch {

                            snackbarHostState.showSnackbar("Hello
                                $textState")
                        }
                    }) {
                        Text("Ok")
                    }
                }
            }


        }
    }
}


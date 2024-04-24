package com.example.simplecompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.simplecompose.ui.theme.SimpleComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleComposeTheme {
                MailColumn()
            }
        }
    }
}


@Composable
fun MailColumn(modifier: Modifier = Modifier) {
    var name by remember {
        mutableStateOf("")
    }
    var names by remember {
        mutableStateOf(listOf<String>())
    }
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Row(modifier = modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = name, onValueChange = { text ->
                    name = text
                },
                modifier = modifier.weight(1f)
            )
            Spacer(modifier = modifier.width(16.dp))
            Button(onClick = {
                if (name.isNotBlank()) {
                    names = names + name
                    name = ""
                }
            }) {
                Text(text = "Add")
            }

            NameList(names = names)
        }
    }
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(names) { currentName ->
            Text(
                text = currentName,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
            Divider()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MailColumnPreview() {
    SimpleComposeTheme {
        MailColumn()
    }
}

//Icon
/*@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var count by remember {
        mutableIntStateOf(0)
    }
    Column(
    ) {
        for (i in 1..10) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = null
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleComposeTheme {
        Greeting()
    }
}*/

//Counter
/*@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var count by remember {
        mutableIntStateOf(0)
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = count.toString())
        Button(onClick = {
            count++
        }) {
            Text(text = "Click me $count")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SimpleComposeTheme {
        Greeting("Android")
    }
}*/
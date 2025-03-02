package com.example.layout01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.layout01.ui.theme.Layout01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Layout01Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Layout01()
                }
            }
        }
    }
}

@Composable
fun Layout01(){
    var title by remember { mutableStateOf("") }
    var selectedStatus by remember { mutableStateOf("Not Done") }
    var selectedPriority by remember { mutableStateOf("Low") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        Text("UILabs", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Enter Title", color = Color.Gray) },
            textStyle = TextStyle(color = Color.White),
            modifier = Modifier.fillMaxWidth()
        )

        Text("Status", color = Color.White)
        Row {
            listOf("Done", "Not Done").forEach { status ->
                Row(
                    modifier = Modifier.clickable { selectedStatus = status },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = selectedStatus == status, onClick = { selectedStatus = status })
                    Text(status, color = Color.White)
                }
            }
        }

        Text("Priority", color = Color.White)
        Row {
            listOf("Low", "Medium", "High").forEach { priority ->
                Row(
                    modifier = Modifier.clickable { selectedPriority = priority },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(selected = selectedPriority == priority, onClick = { selectedPriority = priority })
                    Text(priority, color = Color.White)
                }
            }
        }

        Text("Time and Date", color = Color.White)
        Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Button(onClick = {},
                modifier = Modifier.weight(1f)
            ) { Text("Choose Date") }
            Button(onClick = {},
                modifier = Modifier.weight(1f)
            ) { Text("Choose Time") }
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.fillMaxWidth(),
        ) {
            Button(onClick = {},
                modifier = Modifier.weight(1f)) { Text("Cancel") }
            Button(onClick = {},
                modifier = Modifier.weight(1f)) { Text("Reset") }
            Button(onClick = {},
                modifier = Modifier.weight(1f)) { Text("Submit") }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    Layout01Theme {
        Layout01()
    }
}
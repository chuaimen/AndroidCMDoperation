package com.example.cmdoperation.ui.theme


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun CMDpage(modifier: Modifier
){
    Column(modifier = Modifier
        //.fillMaxSize()
        .padding(5.dp)
    ) {
        Row(Modifier
            .height(720.dp)
            .fillMaxWidth()
            .background(color = Color.Black)
        ) {
            Text("gg")
        }
        Spacer(Modifier.height(5.dp))

        Row {
                OutlinedButton(
                    onClick = {}
                ) {
                    Text("test")
                }

        }
        Spacer(Modifier.padding(5.dp))
        Row{
            OutlinedTextField(value = "test", onValueChange = {})
        }

    }
}
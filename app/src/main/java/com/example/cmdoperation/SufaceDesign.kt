package com.example.cmdoperation


import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.ActivityCompat.startActivityForResult
import androidx.core.content.FileProvider
import android.os.Bundle
import android.provider.DocumentsContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import java.io.File


@Composable
fun CMDpage(modifier: Modifier){

    var selectedFileUri by remember {mutableStateOf<Uri?>(null)}

    val filePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) {
        uir:Uri? ->
        selectedFileUri = uir
    }

    val context = LocalContext.current


    Column(modifier = Modifier
        .fillMaxSize()
        .padding(5.dp)
    ) {
        Row(Modifier
            .height(720.dp)
            .fillMaxWidth()
        ) {

            Text(selectedFileUri.toString())
        }
        Spacer(Modifier.height(5.dp))

        Row {
                //获取文件
                OutlinedButton(
                    onClick = {
                        filePickerLauncher.launch(arrayOf("application/pdf"))
                    }
                ) {
                    Text("文件")
                }

                //打开文件
                OutlinedButton(
                    onClick = {

                        val uri = FileProvider.getUriForFile(
                            context,
                            "${context.packageName}.provider",
                            File(selectedFileUri.toString())
                            )

                        val urlIntent = Intent(
                            Intent.ACTION_VIEW,
                            Uri.parse("com.android.providers\n" +
                                    ".media.documents/document/image%3A1000000525")
                            )

                        context.startActivity(urlIntent)

                    }
                ) { Text(" Open") }

        }
        Spacer(Modifier.padding(2.dp))
        Row(){
            OutlinedTextField(value = "test", onValueChange = {})
        }
        Spacer(Modifier.padding(10.dp))

    }
}


@Composable
fun OpenFile(uri:Uri?){
    uri?.let{
        val intent = Intent(Intent.ACTION_VIEW).apply{
            //setDataAndNormalize()
            setDataAndType(it, "application/pdf")
            flags = Intent.FLAG_ACTIVITY_NO_HISTORY
        }
        LocalContext.current.startActivity(intent)
    }
}

@Preview(showBackground = true)
@Composable
fun CMDpagePreview(){
    CMDpage(modifier = Modifier)
}



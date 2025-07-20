package com.example.androidnative.ui.screens

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androidnative.R
import com.example.androidnative.ui.components.ButtonCustom
import com.example.androidnative.ui.components.TextField

@Composable
fun Screen1(
    onNextClick: (String) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var sentence by remember { mutableStateOf("") }
    val context = LocalContext.current

    Image(
        painter = painterResource(id = R.drawable.background), // ganti nama sesuai file kamu
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier.fillMaxSize()
    )

    Column (
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_photo),
            contentDescription = "ic_photo",
            modifier = Modifier
                .width(116.dp)
                .height(116.dp)
        )

        Spacer(modifier = Modifier.height(50.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            placeholder = "Name"
        )

        Spacer(modifier = Modifier.height(25.dp))

        TextField(
            value = sentence,
            onValueChange = { sentence = it },
            placeholder = "Palindrome"
        )

        Spacer(modifier = Modifier.height(50.dp))

        ButtonCustom(
            onClick = {
                val result = isPalindrome(sentence)
                val message = if (result) "isPalindrome" else "not palindrome"
                Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            },
            label = "CHECK"
        )

        Spacer(modifier = Modifier.height(25.dp))

        ButtonCustom(
            onClick = {onNextClick(name)},
            label = "NEXT"
        )
    }
}

fun isPalindrome(input: String): Boolean {
    val cleaned = input
        .replace("\\s".toRegex(), "")
        .lowercase()
    return cleaned == cleaned.reversed()
}



package com.example.androidnative.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ButtonCustom(
    onClick: () -> Unit,
    label: String
) {


    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(41.dp),
        shape = RoundedCornerShape(12.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF2B637B),
            contentColor = Color.White
        )

    ) {
        Text(text = label, fontWeight = FontWeight.Bold, style = MaterialTheme.typography.titleSmall)
    }
}


@Preview
@Composable
private fun test() {
    ButtonCustom(
        onClick = {},
        label = "Check"
    )

}
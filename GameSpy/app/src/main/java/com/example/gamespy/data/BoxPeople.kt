package com.example.gamespy.data

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BoxPeople(onClick: () -> Unit) {
    val iconPeople = Icons.Default.Person
    val painter = rememberVectorPainter(iconPeople)
    val isEnabled = remember { mutableStateOf(true) }
    val colorBox = remember {
        mutableStateOf(Color(0xffeeeeee))
    }
    Column(
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .padding(15.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(color = colorBox.value)
            .clickable(enabled = isEnabled.value) {
                onClick()
                isEnabled.value = false
                colorBox.value = Color.Red
            }

    ) {
        Icon(
            painter = painter,
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BoxPreview() {
    BoxPeople(onClick = {})
}
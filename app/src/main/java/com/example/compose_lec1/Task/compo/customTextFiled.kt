package com.example.compose_lec1.Task.compo

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.compose_lec1.R

@Composable
fun DecoratedTextFiled(label: String, initialValue: String = "") {
    var textContent by remember { mutableStateOf(initialValue) }

    StateLessDecoratedTextFiled(
        text = textContent,
        onTextChange = { textContent = it },
        placeholder = label
    )
}

@Composable
fun StateLessDecoratedTextFiled(
    text: String,
    onTextChange: (String) -> Unit,
    placeholder: String
) {
    OutlinedTextField(
        value = text,
        onValueChange = onTextChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        placeholder = {
            Text(
                text = placeholder,
                color = Color.LightGray
            )
        },
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.test),
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(20.dp)
            )
        },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF9F9F9),
            unfocusedContainerColor = Color(0xFFF9F9F9),
            focusedBorderColor = Color(0xFFEEEEEE),
            unfocusedBorderColor = Color(0xFFEEEEEE),
            focusedTextColor = Color.Gray,
            unfocusedTextColor = Color.Gray
        ),
        singleLine = true
    )



}


@Composable
fun SearchDecoratedTextField(
    label: String,
    initialValue: String = "",
    onCancelClick: () -> Unit = {}
) {
    var textContent by remember { mutableStateOf(initialValue) }

    OutlinedTextField(
        value = textContent,
        onValueChange = { textContent = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        placeholder = {
            Text(text = label, color = Color.LightGray)
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search),
                contentDescription = null,
                tint = Color.LightGray,
                modifier = Modifier.size(20.dp)
            )
        },

        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.outline_cancel_24),
                contentDescription = "Cancel",
                tint = Color.Gray,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .size(20.dp)
                    .clickable {
                        textContent = ""
                        onCancelClick()
                    }
            )
        },
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFF9F9F9),
            unfocusedContainerColor = Color(0xFFF9F9F9),
            focusedBorderColor = Color(0xFFEEEEEE),
            unfocusedBorderColor = Color(0xFFEEEEEE),
            focusedTextColor = Color.Gray,
            unfocusedTextColor = Color.Gray
        ),
        singleLine = true
    )
}
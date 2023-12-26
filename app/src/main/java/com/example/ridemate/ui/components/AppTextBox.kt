package com.example.ridemate.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.ridemate.R
import com.example.ridemate.ui.theme.lightGrey20
import com.example.ridemate.ui.theme.white

@Composable
fun OutlinedTextField(
    modifier: Modifier = Modifier, hint: String = "", onValueChange: (String) -> Unit
) {
    var value by remember { mutableStateOf("") }

    TextField(
        value = value,
        onValueChange = {
            value = it
            onValueChange(it)
        },
        placeholder = {
            Text(text = hint, color = Color.Gray)
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .border(1.dp, lightGrey20, shape = RoundedCornerShape(8.dp)),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        )
    )
}

@Composable
fun OutlinedMobileTextField(
    modifier: Modifier = Modifier,
    hint: String = stringResource(id = R.string.enter_mobile_number),
    onValueChange: (String) -> Unit
) {
    var value by remember { mutableStateOf("") }

    TextField(
        value = value,
        onValueChange = {
                value = it
                onValueChange(value)
        },
        placeholder = {
            Text(text = hint, color = Color.Gray)
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp)
            .border(1.dp, lightGrey20, shape = RoundedCornerShape(8.dp)),
        singleLine = true,
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            disabledContainerColor = Color.Transparent,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        ),
        leadingIcon = {
            Row(
                modifier = Modifier.padding(5.dp)
            ) {
                Text(text = "+91")
            }
        }
    )
}

@Composable
fun OTPTextField() {
    var otpCode by remember {
        mutableStateOf("")
    }

    BasicTextField(
        value = otpCode,
        onValueChange = { newValue ->
            if (newValue.length <= 4) {
                otpCode = newValue
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.NumberPassword
        ),
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            for (index in 0 until 4) {
                val number = when {
                    index >= otpCode.length -> ""
                    else -> otpCode[index].toString()
                }

                Box(
                    modifier = Modifier
                        .padding(10.dp)
                        .border(1.dp, color = lightGrey20, shape = RoundedCornerShape(8.dp))
                        .wrapContentHeight()
                        .width(48.dp)
                ) {
                    Text(
                        text = number,
                        style = MaterialTheme.typography.titleLarge,
                        color = Color.Black,
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun NVCOutlinedTextBoxPreview() {
    Surface(
        Modifier
            .wrapContentWidth()
            .background(white)
            .padding(10.dp)
    ) {
        Column {
            OutlinedTextField(onValueChange = {})
            OutlinedMobileTextField(onValueChange = {})
            OTPTextField()
        }
    }
}
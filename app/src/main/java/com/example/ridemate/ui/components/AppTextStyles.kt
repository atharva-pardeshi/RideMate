package com.example.ridemate.ui.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Indication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TitleBold(
    modifier: Modifier = Modifier,
    text: String = "",
    color: Color = Color.Black,
    alignment: TextAlign = TextAlign.Center,
    fontSize: TextUnit = 12.sp,
    onTextClick: () -> Unit = {},
    indication: Indication? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        modifier = modifier.clickable(
            interactionSource = interactionSource, indication = indication
        ) {
            onTextClick()
        },
        color = color,
        fontFamily = FontFamily(Font.gilroy_bold),
        textAlign = alignment,
        fontSize = fontSize
    )
}

@Composable
fun TextMedium(
    modifier: Modifier = Modifier,
    text: String = "",
    color: Color = black,
    alignment: TextAlign = TextAlign.Center,
    fontSize: TextUnit = 12.sp,
    onTextClick: () -> Unit = {},
    indication: Indication? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
            .clickable(
                interactionSource = interactionSource, indication = indication
            ) {
                onTextClick()
            },
        color = color,
        fontFamily = FontFamily(Font.gilroy_medium),
        textAlign = alignment,
        fontSize = fontSize,
        maxLines = 1
    )
}

@Composable
fun UserAgreementText(
    modifier: Modifier = Modifier,
    text: String = stringResource(id = R.string.read_user_license_agreement),
    color: Color = grey30,
    alignment: TextAlign = TextAlign.Center,
    fontSize: TextUnit = 12.sp
) {
    val context = LocalContext.current
    val intent = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")) }
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium,
        modifier = modifier
            .clickable {
                context.startActivity(intent)
            },
        color = color,
        fontFamily = FontFamily(Font.gilroy_medium),
        textAlign = alignment,
        fontSize = fontSize,
        maxLines = 1
    )
}

@Composable
fun TextNormal(
    modifier: Modifier = Modifier,
    text: String = "",
    color: Color = black,
    alignment: TextAlign = TextAlign.Center,
    fontSize: TextUnit = 12.sp,
    onTextClick: () -> Unit = {},
    indication: Indication? = null
) {
    val interactionSource = remember { MutableInteractionSource() }
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall,
        modifier = modifier.clickable(
            interactionSource = interactionSource, indication = indication
        ) {
            onTextClick()
        },
        color = color,
        fontFamily = FontFamily(Font.gilroy_regular),
        textAlign = alignment,
        fontSize = fontSize
    )
}

@MultiplePreviews
@Composable
fun PreviewTextStyles() {
    TitleBold(text = "Hello World")
}
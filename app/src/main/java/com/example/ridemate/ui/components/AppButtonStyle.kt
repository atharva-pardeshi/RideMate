package com.example.ridemate.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ridemate.R
import com.example.ridemate.ui.theme.lightBrown20
import com.example.ridemate.ui.theme.lightBrown30
import com.example.ridemate.ui.theme.lightGrey20
import com.example.ridemate.ui.theme.primaryBlack
import com.example.ridemate.ui.theme.primaryBrown
import com.example.ridemate.ui.theme.white

@Composable
fun SwitchButton(
    modifier: Modifier = Modifier,
    text: String = "",
    textSize: TextUnit = 14.sp,
    textColor: Color = primaryBrown
) {
    var isChecked by remember { mutableStateOf(false) }
    val switchColors = SwitchDefaults.colors(
        checkedThumbColor = primaryBrown,
        uncheckedThumbColor = white,
        checkedTrackColor = lightBrown20,
        uncheckedTrackColor = lightGrey20,
        checkedBorderColor = lightBrown30,
        uncheckedBorderColor = lightGrey20
    )

    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Switch(
            checked = isChecked, onCheckedChange = { isChecked = it }, colors = switchColors
        )

        Spacer(modifier = Modifier.width(10.dp))
        TextMedium(
            text = text, color = textColor, fontSize = textSize
        )
    }
}

@Composable
fun NVCButton(
    modifier: Modifier = Modifier,
    text: String = "",
    textSize: TextUnit = 18.sp,
    textColor: Color = primaryBrown,
    onButtonClick: () -> Unit = {},
    buttonColor: Color = primaryBrown,
    borderColor: Color = primaryBrown
) {

    Button(modifier = modifier, onClick = {
        onButtonClick()
    }, shape = RoundedCornerShape(5.dp), colors = ButtonDefaults.buttonColors(
        contentColor = textColor, containerColor = buttonColor
    ), border = BorderStroke(1.dp, borderColor), content = {
        TextMedium(text = text, color = textColor, fontSize = textSize, onTextClick = {
            onButtonClick()
        })
    })
}

/*@Composable
fun NVCImageButton(
    modifier: Modifier = Modifier,
    providerName: String = "",
    specialization: String = "",
    users: String = "",
    onButtonClick: () -> Unit = {},
    imageResourceId: Int = R.drawable.icon_person
) {
    val imagePainter: Painter = painterResource(id = imageResourceId)
    var clicked by remember { mutableStateOf(false) }

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                clicked = !clicked
                onButtonClick()
            }
            .border(1.dp, if (clicked) primaryBrown else lightGrey20),
        shape = RoundedCornerShape(5.dp),
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .height(73.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row {
                Image(
                    painter = imagePainter,
                    contentDescription = "Person Image",
                    modifier = Modifier.padding(16.dp),
                    colorFilter = if (clicked) ColorFilter.tint(primaryBrown) else ColorFilter.tint(
                        lightGrey20
                    ),
                )

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceEvenly
                ) {
                    TextMedium(text = providerName, fontSize = 12.sp, color = Color.Black)
                    TextNormal(
                        text = "Specialization-$specialization",
                        fontSize = 10.sp,
                        color = lightGrey20
                    )
                    TextNormal(text = "Coached $users+ users", fontSize = 8.sp, color = lightGrey20)
                }
            }

            val buttonText =
                if (clicked) stringResource(id = R.string.selected) else stringResource(id = R.string.select)

            if (clicked) {
                TitleBold(
                    text = buttonText, modifier = Modifier.padding(end = 16.dp)
                )
            } else {
                TextMedium(
                    text = buttonText, modifier = Modifier.padding(end = 16.dp)
                )
            }
        }
    }
}*/

@Composable
fun NVCCheckbox(
    modifier: Modifier = Modifier,
    text: String = "",
    textSize: TextUnit = 14.sp,
    color: Color = primaryBlack,
    onCheckBoxClick: (Boolean) -> Unit,
) {
    var checked by remember { mutableStateOf(false) }

    Row(
        modifier = modifier.padding(start = 16.dp), verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = checked, onCheckedChange = {
                checked = it
                onCheckBoxClick(it)
            }, modifier = Modifier
                .size(24.dp)
                .background(Color.Transparent)
        )

        Spacer(modifier = Modifier.width(5.dp))
        TextMedium(
            text = text, fontSize = textSize, color = color
        )
    }
}

@Preview
@Composable
fun PreviewNVCButton() {
    NVCButton(modifier = Modifier
        .fillMaxWidth()
        .border(
            width = 2.dp, color = Color.Transparent, shape = RoundedCornerShape(13.dp)
        ), text = "Sign In", textColor = white, onButtonClick = {})
}

@Preview
@Composable
fun PreviewButtonStyles() {
    Surface(
        Modifier
            .wrapContentWidth()
            .background(white)
    ) {
        SwitchButton()
    }
}

@Preview
@Composable
fun PreviewCheckBoxButton() {
    Surface(
        Modifier
            .fillMaxWidth()
            .background(white)
    ) {
        NVCCheckbox(text = "test", onCheckBoxClick = {})
    }
}

@Preview
@Composable
fun PreviewImageButton() {
    Surface(
        Modifier
            .fillMaxWidth()
            .background(white)
    ) {
        /*NVCImageButton(providerName = "test",
            specialization = "test",
            users = "100",
            onButtonClick = {})*/
    }
}
package com.example.ridemate.ui.presentation.onbording

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ridemate.R
import com.example.ridemate.ui.components.NVCButton
import com.example.ridemate.ui.components.OutlinedMobileTextField
import com.example.ridemate.ui.components.TextMedium
import com.example.ridemate.ui.components.TitleBold
import com.example.ridemate.ui.components.UserAgreementText
import com.example.ridemate.ui.theme.RideMateTheme
import com.example.ridemate.ui.theme.grey
import com.example.ridemate.ui.theme.primaryBrown
import com.example.ridemate.ui.theme.white

@Composable
fun LoginScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween
    ) {

        Column {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Spacer(modifier = Modifier.height(80.dp))

                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(id = R.drawable.ic_launcher_adaptive_fore),
                    contentDescription = "App Logo"
                )

                Spacer(modifier = Modifier.height(80.dp))
                TitleBold(
                    text = stringResource(id = R.string.sign_in),
                    fontSize = 20.sp,
                    color = primaryBrown
                )

                Spacer(modifier = Modifier.height(30.dp))
                OutlinedMobileTextField(
                    modifier = Modifier.fillMaxWidth(),
                    onValueChange = {

                    }
                )
            }

            Spacer(modifier = Modifier.height(30.dp))
            NVCButton(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
                text = stringResource(id = R.string.sign_in),
                textColor = white,
                onButtonClick = {
                    navController.navigate("Home Screen")
                })

            Spacer(modifier = Modifier.height(12.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextMedium(
                    text = stringResource(id = R.string.dont_have_an_account), color = grey
                )

                Spacer(modifier = Modifier.width(5.dp))
                TextMedium(text = stringResource(id = R.string.sign_up),
                    color = primaryBrown,
                    onTextClick = {
                        navController.navigate("SignUp Screen")
                    })
            }
        }

        UserAgreementText(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    RideMateTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(navController = navController)
        }
    }
}
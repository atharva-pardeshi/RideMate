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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.ridemate.R

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
                    painter = painterResource(id = R.drawable.ic_launcher),
                    contentDescription = "App Logo",
                    colorFilter = ColorFilter.tint(color = Color.Black)
                )

                Spacer(modifier = Modifier.height(80.dp))
                TitleBold(
                    text = stringResource(id = R.string.sign_in),
                    fontSize = 20.sp,
                    color = primaryBlue
                )

                Spacer(modifier = Modifier.height(dimen_30))
                NVCOutlinedEmailTextField(
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(dimen_24))
                NVCOutlinedPasswordTextField(
                    modifier = Modifier.fillMaxWidth()
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                SwitchButton(
                    text = stringResource(id = R.string.remember_me),
                    textColor = grey20,
                )

                TextMedium(text = stringResource(id = R.string.forgot_password),
                    color = grey20,
                    fontSize = 14.sp,
                    onTextClick = {
                        navController.navigate("Forgot Password Screen")
                    })
            }

            Spacer(modifier = Modifier.height(dimen_30))
            NVCButton(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
                text = stringResource(id = R.string.sign_in),
                textColor = white,
                onButtonClick = {
                    navController.navigate("Home Screen")
                })

            Spacer(modifier = Modifier.height(dimen_12))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                TextMedium(
                    text = stringResource(id = R.string.dont_have_an_account), color = grey30
                )

                Spacer(modifier = Modifier.width(dimen_5))
                TextMedium(text = stringResource(id = R.string.sign_up),
                    color = primaryBlue,
                    onTextClick = {
                        navController.navigate("SignUp Screen")
                    })
            }
        }

        UserAgreementText(
            color = grey30,
            modifier = Modifier.fillMaxWidth()
        )

        /*LaunchedEffect(key1 = userAgreement, block = {
            loginViewModel.fetchData()
        })*/
    }
}

@Preview
@Composable
fun LoginPreview() {
    val navController = rememberNavController()
    NVCPatientAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
        ) {
            LoginScreen(navController = navController)
        }
    }
}
package com.example.ridemate.ui.presentation.onbording

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
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
import com.example.ridemate.ui.components.TextBold
import com.example.ridemate.ui.components.TextMedium
import com.example.ridemate.ui.components.TextNormal
import com.example.ridemate.ui.components.UserAgreementText
import com.example.ridemate.ui.theme.RideMateTheme
import com.example.ridemate.ui.theme.grey
import com.example.ridemate.ui.theme.primaryBrown
import com.example.ridemate.ui.theme.white
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

@Composable
fun LoginScreen(navController: NavController) {

    val context = LocalContext.current
    val termsOfUse = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")) }
    val privacyPolicy =
        remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")) }
    val getHelp = remember { Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/")) }
    val phoneNumber = remember {
        mutableStateOf("")
    }
    val mAuth: FirebaseAuth = FirebaseAuth.getInstance()
    lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

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
                TextBold(
                    text = stringResource(id = R.string.sign_in),
                    fontSize = 24.sp,
                    color = primaryBrown
                )

                Spacer(modifier = Modifier.height(30.dp))
                OutlinedMobileTextField(modifier = Modifier.fillMaxWidth(), onValueChange = {
                    phoneNumber.value = it
                })

                Spacer(modifier = Modifier.height(12.dp))
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.Bottom,
                    ) {
                        TextNormal(
                            text = stringResource(id = R.string.by_continuing_i_agree_to_the),
                            fontSize = 14.sp
                        )

                        Spacer(modifier = Modifier.width(5.dp))
                        TextBold(
                            text = stringResource(id = R.string.terms_Of_use),
                            fontSize = 16.sp,
                            modifier = Modifier.clickable {
                                context.startActivity(termsOfUse)
                            },
                            color = primaryBrown
                        )

                        Spacer(modifier = Modifier.width(5.dp))
                        TextNormal(
                            text = "and", fontSize = 14.sp
                        )
                    }

                    TextBold(
                        text = stringResource(id = R.string.privacy_policy),
                        fontSize = 16.sp,
                        modifier = Modifier.clickable {
                            context.startActivity(privacyPolicy)
                        },
                        color = primaryBrown
                    )
                }
            }

            Spacer(modifier = Modifier.height(30.dp))
            NVCButton(modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
                text = stringResource(id = R.string.sign_in),
                textColor = white,
                onButtonClick = {
                    val number = "+91${phoneNumber.value}"
                    sendVerificationCode(number, mAuth, context as Activity, callbacks)
                    navController.navigate("OTP Screen")
                })

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                TextMedium(
                    text = stringResource(id = R.string.having_trouble_logging_in), color = grey
                )

                Spacer(modifier = Modifier.width(5.dp))
                TextBold(text = stringResource(id = R.string.get_help),
                    color = primaryBrown,
                    modifier = Modifier.clickable {
                        context.startActivity(getHelp)
                    })
            }
        }

        UserAgreementText(
            modifier = Modifier.fillMaxWidth()
        )
    }
}

fun sendVerificationCode(
    number: String,
    auth: FirebaseAuth,
    activity: Activity,
    callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks
) {

    val options = PhoneAuthOptions.newBuilder(auth).setPhoneNumber(number) // Phone number to verify
        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
        .setActivity(activity) // Activity (for callback binding)
        .setCallbacks(callbacks) // OnVerificationStateChangedCallbacks
        .build()
    PhoneAuthProvider.verifyPhoneNumber(options)
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
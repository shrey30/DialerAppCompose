package com.shrey.phoneapplication

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.shrey.phoneapplication.ui.theme.PhoneApplicationTheme
import com.shrey.phoneapplication.view.CircularButton
import com.shrey.phoneapplication.view.CircularButtonWithIcon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {

            PhoneApplicationTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    Dialer()
                }
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dialer(modifier: Modifier = Modifier) {
    var textFieldValue by remember { mutableStateOf(TextFieldValue()) }
    fun updateTextFieldValue(newValue: String) {
        textFieldValue = TextFieldValue(text = textFieldValue.text + newValue)
    }

    val context = LocalContext.current
    fun initiatePhoneCall(phone: String, context: Context) {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:$phone"))
        if (ActivityCompat.checkSelfPermission(
                context, Manifest.permission.CALL_PHONE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            context.startActivity(intent)
        } else {
            // Handle permission not granted
        }
        textFieldValue = textFieldValue.copy(text = "")
    }

    val requestPermissionLauncher = rememberLauncherForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        if (isGranted) {
            initiatePhoneCall(textFieldValue.toString(), context)
        }
    }
    val vibrate = context.getSystemService(Vibrator::class.java)

    Surface(color = Color(0xff000000), modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                colors = TextFieldDefaults.colors(
                    unfocusedTextColor = Color.White,
                    focusedTextColor = Color.White,
                    unfocusedContainerColor = Color(0xff000000),
                    focusedContainerColor = Color(0xff000000),
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(fontSize = 50.sp, textAlign = TextAlign.Center),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
            )
            Spacer(modifier = Modifier.height(60.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(45.dp)) {
                CircularButton(
                    onClick = {
                        updateTextFieldValue("1")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    backgroundColor = Color.White,
                    text = "1",
                    size = 55
                )
                CircularButton(
                    onClick = {
                        updateTextFieldValue("2")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    backgroundColor = Color.White,
                    text = "2",
                    size = 55
                )
                CircularButton(
                    onClick = {
                        updateTextFieldValue("3")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    backgroundColor = Color.White,
                    text = "3",
                    size = 55
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(45.dp)
            ) {
                CircularButton(
                    onClick = {
                        updateTextFieldValue("4")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    backgroundColor = Color.White,
                    text = "4",
                    size = 55
                )
                CircularButton(
                    onClick = {
                        updateTextFieldValue("5")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    backgroundColor = Color.White,
                    text = "5",
                    size = 55
                )
                CircularButton(
                    onClick = {
                        updateTextFieldValue("6")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    backgroundColor = Color.White,
                    text = "6",
                    size = 55
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(45.dp)) {
                CircularButton(
                    onClick = {
                        updateTextFieldValue("7")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    backgroundColor = Color.White,
                    text = "7",
                    size = 55
                )
                CircularButton(
                    onClick = {
                        updateTextFieldValue("8")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    backgroundColor = Color.White,
                    text = "8",
                    size = 55
                )
                CircularButton(
                    onClick = {
                        updateTextFieldValue("9")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    backgroundColor = Color.White,
                    text = "9",
                    size = 55
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(45.dp)) {
                CircularButton(
                    onClick = {
                        updateTextFieldValue("*")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    backgroundColor = Color.White,
                    text = "*",
                    size = 55
                )
                CircularButton(
                    onClick = {
                        updateTextFieldValue("0")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    backgroundColor = Color.White,
                    text = "0",
                    size = 55
                )
                CircularButton(
                    onClick = {
                        updateTextFieldValue("#")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    backgroundColor = Color.White,
                    text = "#",
                    size = 55
                )
            }
            Spacer(modifier = Modifier.height(40.dp))
            Row(Modifier.padding(start = 94.dp)) {
                CircularButtonWithIcon(
                    onClick = {
                        if (ContextCompat.checkSelfPermission(
                                context, Manifest.permission.CALL_PHONE
                            ) == PackageManager.PERMISSION_GRANTED
                        ) {
                            val phoneNumber = textFieldValue.text.trim()

                            if (phoneNumber.isNotEmpty()) {
                                initiatePhoneCall(phoneNumber, context)
                            }
                        } else {
                            requestPermissionLauncher.launch(Manifest.permission.CALL_PHONE)
                        }
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L,
                                VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    backgroundColor = Color.Green,
                    drawableicon = R.drawable.baseline_phone_24,
                    size = 75
                )

                Row(Modifier.padding(start = 25.dp)) {
                    CircularButtonWithIcon(
                        onClick = {
                            if (textFieldValue.text.isNotEmpty()) {
                                textFieldValue =
                                    textFieldValue.copy(text = textFieldValue.text.dropLast(1))
                            }
                            vibrate.vibrate(
                                VibrationEffect.createOneShot(
                                    10L,
                                    VibrationEffect.DEFAULT_AMPLITUDE
                                )
                            )
                        },
                        backgroundColor = Color(0xff669bbc),
                        drawableicon = R.drawable.backspace,
                        size = 65
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PhonePreview() {
    Dialer()
}

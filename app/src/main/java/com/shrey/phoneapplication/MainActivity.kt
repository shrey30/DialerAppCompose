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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.shrey.phoneapplication.ui.theme.PhoneApplicationTheme
import com.shrey.phoneapplication.ui.theme.PhoneApplicationTheme
import com.shrey.phoneapplication.view.CircleButton
import com.shrey.phoneapplication.view.CircleButtonWithIcon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {

            PhoneApplicationTheme{
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
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(35.dp))
            TextField(
                value = textFieldValue, maxLines = 2,
                onValueChange = { textFieldValue = it },
                colors = TextFieldDefaults.colors(
                    unfocusedContainerColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent,
                    unfocusedTextColor = MaterialTheme.colorScheme.secondary
                ),
                textStyle = TextStyle(fontSize = 50.sp, textAlign = TextAlign.Center),
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number, imeAction = ImeAction.Done
                ),
            )
            Spacer(modifier = Modifier.height(50.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(45.dp)) {
                CircleButton(
                    onClick = {
                        updateTextFieldValue("1")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L, VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    text = "1",

                    )
                CircleButton(
                    onClick = {
                        updateTextFieldValue("2")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L, VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },

                    text = "2",

                    )
                CircleButton(
                    onClick = {
                        updateTextFieldValue("3")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L, VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },

                    text = "3",

                    )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(45.dp)
            ) {
                CircleButton(
                    onClick = {
                        updateTextFieldValue("4")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L, VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },

                    text = "4",

                    )
                CircleButton(
                    onClick = {
                        updateTextFieldValue("5")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L, VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },

                    text = "5",

                    )
                CircleButton(
                    onClick = {
                        updateTextFieldValue("6")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L, VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },

                    text = "6",

                    )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(45.dp)) {
                CircleButton(
                    onClick = {
                        updateTextFieldValue("7")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L, VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },

                    text = "7",

                    )
                CircleButton(
                    onClick = {
                        updateTextFieldValue("8")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L, VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },

                    text = "8",

                    )
                CircleButton(
                    onClick = {
                        updateTextFieldValue("9")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L, VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    text = "9",

                    )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(45.dp)) {
                CircleButton(
                    onClick = {
                        updateTextFieldValue("*")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L, VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    }, text = "*"
                )
                CircleButton(
                    onClick = {
                        updateTextFieldValue("0")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L, VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    }, text = "0"
                )
                CircleButton(
                    onClick = {
                        updateTextFieldValue("#")
                        vibrate.vibrate(
                            VibrationEffect.createOneShot(
                                10L, VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    }, text = "#"
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            Row(Modifier.padding(start = 105.dp)) {
                CircleButtonWithIcon(
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
                                10L, VibrationEffect.DEFAULT_AMPLITUDE
                            )
                        )
                    },
                    drawableicon = R.drawable.baseline_phone_24,
                    modifier = Modifier,
                    tint = Color.Black,
                    backgroundColor = Color.Green

                    )

                Row(Modifier.padding(start = 25.dp)) {
                    CircleButtonWithIcon(
                        onClick = {
                            if (textFieldValue.text.isNotEmpty()) {
                                textFieldValue =
                                    textFieldValue.copy(text = textFieldValue.text.dropLast(1))
                            }
                            vibrate.vibrate(
                                VibrationEffect.createOneShot(
                                    10L, VibrationEffect.DEFAULT_AMPLITUDE
                                )
                            )
                        },
                        drawableicon = R.drawable.backspace,
                        backgroundColor = Color.Transparent,
                        modifier = Modifier,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PhonePreview() {
    PhoneApplicationTheme {
        Dialer()
    }
}

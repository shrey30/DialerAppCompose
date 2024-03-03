package com.shrey.phoneapplication.view

import android.os.VibrationEffect
import android.os.Vibrator
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    backgroundColor: Color,
    text: String,
    size: Int
) {
    var textfieldvalue by remember { mutableStateOf(TextFieldValue()) }
    val context = LocalContext.current
    val vibrate = context.getSystemService(Vibrator::class.java)
    Box(
        modifier = Modifier
            .size(size.dp)
            .background(backgroundColor, shape = CircleShape)
            .clickable(
                onClick = onClick), contentAlignment = Alignment.Center
    ) {
        Text(text = text, fontSize = 35.sp, color = Color.Black)
    }
}

@Composable
fun CircularButtonWithIcon(
    @DrawableRes drawableicon: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    backgroundColor: Color,
    size: Int,

    ) {
    Box(
        modifier = Modifier
            .size(size.dp)
            .background(backgroundColor, shape = CircleShape), contentAlignment = Alignment.Center
    ) {
        IconButton(onClick = {
            onClick()
        }) {
            Icon(painter = painterResource(id = drawableicon), contentDescription = "")
        }
    }

}


@Preview
@Composable
private fun Circularbuttonprev() {
    CircularButton(onClick = { /*TODO*/ }, backgroundColor = Color.White, text = "8", size = 55)
}

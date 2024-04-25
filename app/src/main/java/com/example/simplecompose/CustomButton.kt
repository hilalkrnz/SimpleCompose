package com.example.simplecompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.example.simplecompose.ui.theme.SimpleComposeTheme

@Composable
fun CustomButton(
    title: String,
    isOutline: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    if (isOutline) {
        OutlinedButton(
            onClick = onClick,
            shape = RectangleShape,
            contentPadding = PaddingValues(16.dp),
            modifier = modifier,
            border = BorderStroke(
                width = if (LocalInspectionMode.current) 3.dp else 1.dp,
                color = MaterialTheme.colorScheme.primary
            )
        ) {
            Text(text = title)
        }
    } else {
        Button(
            onClick = onClick,
            shape = RectangleShape,
            contentPadding = PaddingValues(16.dp),
            modifier = modifier
        ) {
            Text(text = title)
        }
    }
}

class OutlineParameterProvider : PreviewParameterProvider<Boolean> {
    override val values: Sequence<Boolean>
        get() = sequenceOf(false, true)
}

@Preview
@Composable
fun CustomButtonPreview(
    @PreviewParameter(OutlineParameterProvider::class) isOutline: Boolean
) {
    SimpleComposeTheme {
        CustomButton(title = "Hilal", isOutline = isOutline, onClick = {})
    }
}
package kotlinx.testing.common

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
actual fun MyButton(onClick: () -> Unit, content: @Composable () -> Unit) {
    Button(onClick) {
        content()
    }
}

@Composable
actual fun MyText(text: String) {
    Text(text)
}

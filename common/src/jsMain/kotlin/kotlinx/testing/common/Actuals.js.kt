package kotlinx.testing.common

import androidx.compose.runtime.Composable
import org.jetbrains.compose.web.dom.Button
import org.jetbrains.compose.web.dom.Text

@Composable
actual fun MyButton(onClick: () -> Unit, content: @Composable () -> Unit) {
    Button(attrs = {
        onClick { onClick() }
    }) {
        content()
    }
}

@Composable
actual fun MyText(text: String) {
    Text(text)
}

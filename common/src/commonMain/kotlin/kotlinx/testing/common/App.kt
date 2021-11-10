package kotlinx.testing.common

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }

    MyButton(onClick = {
        text = "Hello, ${decodeUser(getPlatformName())}"
    }) {
        MyText(text)
    }
}


@Composable
expect fun MyButton(onClick: () -> Unit, content: @Composable () -> Unit)

@Composable
expect fun MyText(text: String)

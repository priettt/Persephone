package co.francis.persephone

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import co.francis.persephone.ui.home.HomeScreen
import co.francis.persephone.ui.theme.PersephoneTheme

@Composable
fun PersephoneApp() {
    PersephoneTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            HomeScreen()
        }
    }
}


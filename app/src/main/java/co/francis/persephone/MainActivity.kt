package co.francis.persephone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import co.francis.persephone.ui.navigation.PersephoneNavGraph
import io.embrace.android.embracesdk.Embrace

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Embrace.getInstance().start(this)
        setContent { PersephoneNavGraph() }
    }
}
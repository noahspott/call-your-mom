
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppHeader(
    title: String,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        title = {
            Text(title)
        },
        actions = {
            IconButton(
                onClick = {println("Settings clicked!")}
            ) {
                Icon(Icons.Filled.Settings, "Account Settings")
            }
        },
    )
}
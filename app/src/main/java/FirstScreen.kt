import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@Composable
fun FirstScreen(modifier: Modifier, navController: NavController, authViewModel: AuthViewModel){
    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value){
        when(authState.value) {
            is AuthState.unAuthenticated -> navController.navigate("login")
            else -> Unit
        }
    }
    Column {
        Button(onClick={}){
            Text(text="Click on me")
        }
    }
}
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun NavGraph(modifier: Modifier,authViewModel: AuthViewModel) {
    val authState by authViewModel.authState.observeAsState(AuthState.unAuthenticated)
    // Create a navigation controller
    val navController: NavHostController = rememberNavController()

    val startDestination= when(authState){
        is AuthState.Authenticated ->"FirstScreen"
        else->"HomeScreen"
    }

    NavHost(
        navController = navController,
        startDestination =startDestination,builder={
            composable("login"){
                Login(modifier,navController,AuthViewModel())
            }
            composable("HomeScreen"){
                HomeScreen(navController,AuthViewModel())
            }
            composable("Create") {
                Signin(modifier,navController,AuthViewModel())
            }
            composable("FirstScreen") {
                WeatherScreen(
                    //modifier,navController,AuthViewModel()
            )
            }
        })
}

import android.widget.Toast
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Signin(modifier:Modifier,navController: NavController,authViewModel: AuthViewModel) {
    //ViewModel is added here
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var repassword by remember { mutableStateOf("") }

    val authState = authViewModel.authState.observeAsState()
    val context= LocalContext.current

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate("FirstScreen")
            is AuthState.error -> Toast.makeText(context,(authState.value as AuthState.error)
                .message,Toast.LENGTH_SHORT).show()
            else-> Unit
        }
    }
    BackHandler {
        navController.navigate("HomeScreen"){
            popUpTo("HomeScreen"){inclusive=true}
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color(0xFF5088C9)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text(
            text = "Sign in", fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(value = email,
            onValueChange = { email = it },
            shape = RoundedCornerShape(12.dp),
            label = { Text(text = "Enter the email") }
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(value = password,
            onValueChange = { password = it },
            shape = RoundedCornerShape(12.dp),
            label = { Text(text = "Enter password") }
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(value = repassword,
            onValueChange = { repassword = it },
            shape = RoundedCornerShape(12.dp),
            label = { Text(text = "Re enter password") }
        )
        Spacer(modifier = Modifier.height(15.dp))

        Button(onClick = {
            authViewModel.signin(email,password,repassword)
        }) {
            Text(text = "Signup")
        }
        Spacer(modifier = Modifier.height(15.dp))
        TextButton(onClick = {
            navController.navigate("Login"){
            }
        }) {
            Text(
                text = "Already have account log in",
                color = Color.Black
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SigninPreview(){
    val navController= rememberNavController()
    Signin(Modifier,navController = navController,AuthViewModel())
}
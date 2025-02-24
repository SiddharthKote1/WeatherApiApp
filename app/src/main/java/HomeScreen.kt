
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.weather_api.R


@Composable
fun HomeScreen(navController: NavController,authViewModel: AuthViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF5088C9)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.jp),
            contentDescription = "Sample Image",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(30.dp))

        Button(
            onClick = {
                navController.navigate("Create")
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .height(40.dp)
                .width(250.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4DBCA6),
                contentColor = Color.Black
            )
        ) {
            Text(text = "Sign in")
        }

        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = {
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .height(40.dp)
                .width(250.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF4DBCA6),
                contentColor = Color.Black
            )
        ) {
            Text(text = "Sign in with Google")
        }

        Spacer(modifier = Modifier.height(15.dp))

        TextButton(onClick = {
            navController.navigate("Login")
        }) {
            Text(text = "Log in")
        }
    }
}
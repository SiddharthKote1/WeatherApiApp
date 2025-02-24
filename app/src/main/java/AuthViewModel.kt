import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class AuthViewModel:ViewModel() {

    private val auth:FirebaseAuth=FirebaseAuth.getInstance()

    private val _authState=MutableLiveData<AuthState>()
    val authState: LiveData<AuthState> =_authState

    init{
        checkAuthStatus()
    }

    fun checkAuthStatus(){
        if(auth.currentUser==null){
            _authState.value= AuthState.unAuthenticated
        }
        else{
            _authState.value= AuthState.Authenticated
        }
    }
    fun login(email:String,password:String){

        if(email.isEmpty() || password.isEmpty()){
            _authState.value= AuthState.error("Email or password is empty")
            return
        }

        auth.signInWithEmailAndPassword(email,password)
            .addOnCompleteListener{task->
                if(task.isSuccessful){
                    _authState.value= AuthState.Authenticated
                }
                else{
                    _authState.value=
                        AuthState.error(task.exception?.message ?: "Something went wrong")
                }
            }
    }
    fun signin(email:String,password:String,repassword:String){

        if(email.isEmpty() || password.isEmpty() || repassword.isEmpty()){
            _authState.value= AuthState.error("Email or password is empty")
            return
        }
        if(password!=repassword){
            _authState.value= AuthState.error("Password is does not match")
        }
        else{
            _authState.value= AuthState.loading
        }

        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener{task->
                if(task.isSuccessful){
                    _authState.value= AuthState.Authenticated
                }
                else{
                    _authState.value=
                        AuthState.error(task.exception?.message ?: "Something went wrong")
                }
            }
    }
    fun signout(){
        auth.signOut()
        _authState.value= AuthState.unAuthenticated
    }

}

sealed class AuthState {
    object Authenticated : AuthState()
    object unAuthenticated : AuthState()
    object loading : AuthState()
    data class error(val message: String) : AuthState()
}
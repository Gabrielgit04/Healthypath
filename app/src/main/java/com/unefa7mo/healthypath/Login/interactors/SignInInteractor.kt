package interactors

interface SignInInteractor {

    suspend fun signInWithEmailAndPassword(userName: String, password: String)

}
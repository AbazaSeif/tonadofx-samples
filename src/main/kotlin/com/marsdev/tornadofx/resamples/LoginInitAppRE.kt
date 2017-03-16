package com.marsdev.tornadofx.resamples

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.util.Callback
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.javafx.JavaFx
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.run
import tornadofx.*

class LoginInitMainView : View() {

    val loginInitController: LoginInitController by inject()

    override val root = vbox()

    override fun onDock() {
        super.onDock()
        launchLogin()
    }

    fun launchLogin() = launch(JavaFx) {
        // launch new coroutine to perform login sequence
        try {
            loginInitController.preLoginInit()
            val loginDTO = getLoginInfo()
            if (loginDTO != null) {
                if (loginInitController.login(loginDTO.username, loginDTO.password)) {
                    // login success
                    loginInitController.postLoginInit()
                    println("finally finished!")
                } else {
                    println("login failed")
                }
            } else {
                println("the user exited w/o entering login info")
            }
        } catch (e: Throwable) {
            println("Something failed: $e")
        }
    }

    private fun getLoginInfo(): LoginDTO? {
        val loginForm = find(LoginForm::class)

        val loginButtonType = ButtonType("Login", ButtonBar.ButtonData.OK_DONE)

        val dialog = Dialog<LoginDTO>()
        dialog.dialogPane.buttonTypes += loginButtonType
        dialog.graphic = loginForm.root

        dialog.resultConverter = Callback {
            bt: ButtonType? ->
            if (bt != null && bt.buttonData == ButtonBar.ButtonData.OK_DONE) {
                LoginDTO(loginForm.username, loginForm.password)
            } else {
                null
            }
        }

        val loginDTO = dialog.showAndWait()

        return loginDTO.orElse(null)
    }
}

data class LoginDTO(val username: String, val password: String)

class LoginInitController : Controller() {

    val api: Rest by inject()

    suspend fun preLoginInit() = run(CommonPool) {
        api.get("customers.json")  // simulate real work
    }

    suspend fun login(username: String, password: String): Boolean = run(CommonPool) {
        api.get("customers.json") // simulate real work
        true
    }

    suspend fun postLoginInit() = run(CommonPool) {
        api.get("customers.json") // simulate real work
    }
}

class LoginForm : Fragment() {

    val loginInitController: LoginInitController by inject()

    val usernameProperty = SimpleStringProperty()
    var username by usernameProperty

    val passwordProperty = SimpleStringProperty()
    var password by passwordProperty

    override val root = vbox {
        padding = Insets(10.0)
        spacing = 4.0
        label("Username")
        textfield(usernameProperty)
        label("Password")
        textfield(passwordProperty)
    }
}

class LoginInitApp : App(LoginInitMainView::class) {

    val api: Rest by inject()

    override fun createPrimaryScene(view: UIComponent) = Scene(view.root, 568.0, 320.0)

    init {
        api.baseURI = "https://www.bekwam.net/data"
    }
}
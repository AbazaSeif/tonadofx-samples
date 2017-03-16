package com.marsdev.tornadofx.cwsamples

import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.ButtonBar
import javafx.scene.control.ButtonType
import javafx.scene.control.Dialog
import javafx.util.Callback
import tornadofx.*

class LoginInitMainView : View() {

    val loginInitController: LoginInitController by inject()

    override val root = vbox()

    override fun onDock() {
        super.onDock()

        runAsync {

            // keep this off the FX thread so the UI doesn't lock up
            loginInitController.preLoginInit()

        } ui {

            // stop everything; call out to the user (maybe suspend here with coroutines)?
            val loginDTO = getLoginInfo()

            if (loginDTO != null) {

                runAsync {

                    // keep this off the FX thread too
                    loginInitController.login(loginDTO.username, loginDTO.password)

                } ui {

                    if (it) { // login success

                        runAsync {

                            // also needs to be off the FX thread
                            loginInitController.postLoginInit()

                        } ui {
                            println("finally finished!")

                        } fail {
                            println("there was an error during postLoginInit")
                        }

                    } else {
                        println("login failed")
                    }

                } fail {
                    println("there was an error during login")
                }

            } else {
                println("the user exited w/o entering login info")
            }

        } fail {

            println("there was an error during preLoginInit")
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

    fun preLoginInit() {
        api.get("customers.json")  // simulate real work
    }

    fun login(username: String, password: String): Boolean {
        api.get("customers.json") // simulate real work
        return true
    }

    fun postLoginInit() {
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


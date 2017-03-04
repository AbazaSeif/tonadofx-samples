package com.marsdev.tornadofx.rssamples.forms

import javafx.beans.property.SimpleStringProperty
import javafx.scene.control.ButtonBar
import tornadofx.*

class Form2App : App(EnabledView::class)

class EnabledView : View("Basic form") {
    val model = ViewModel()
    val username = model.bind { SimpleStringProperty() }
    val password = model.bind { SimpleStringProperty() }

    override val root = form {
        fieldset {
            field("username") {
                textfield(username).required()
            }
            field("password") {
                passwordfield(password).required()
            }
            buttonbar {
                button("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE).setOnAction {
                    println("do nothing")
                }
                button("OK", ButtonBar.ButtonData.OK_DONE) {
                    enableWhen { model.valid }
                    setOnAction {
                        println("do something")
                    }
                }
            }
        }
        model.validate(decorateErrors = false)
    }
}


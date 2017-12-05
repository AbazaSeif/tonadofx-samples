package com.marsdev.tornadofx.samples.book

import javafx.scene.layout.BorderPane
import tornadofx.*

class PersonEditorApp:App(PersonEditor::class)

class PersonEditor : View("Person Editor") {
    override val root = BorderPane()
    val persons = listOf(PersonSME("John", "Manager"), PersonSME("Jay", "Worker bee")).observable()
    val model = PersonModel(PersonSME())

    init {
        with(root) {
            center {
                tableview(persons) {
                    column("Name", PersonSME::nameProperty)
                    column("Title", PersonSME::titleProperty)

                    // Update the person inside the view model on selection change
                    model.rebindOnChange(this) { selectedPerson ->
                        person = selectedPerson ?: PersonSME()
                    }
                }
            }

            right {
                form {
                    fieldset("Edit person") {
                        field("Name") {
                            textfield(model.name)
                        }
                        field("Title") {
                            textfield(model.title)
                        }
                        button("Save") {
                            disableProperty().bind(model.dirtyStateProperty().not())
                            setOnAction {
                                save()
                            }
                        }
                        button("Reset") {
                            setOnAction {
                                model.rollback()
                            }
                        }
                    }
                }
            }
        }
    }

    private fun save() {
        // Flush changes from the text fields into the model
        model.commit()

        // The edited person is contained in the model
        val person = model.person

        // A real application would persist the person here
        println("Saving ${person.name} / ${person.title}")
    }

}

class PersonModel(var person: PersonSME) : ViewModel() {
    val name = bind { person.nameProperty() }
    val title = bind { person.titleProperty() }
}

class PersonSME(name: String? = null, title: String? = null) {
    var name by property(name)
    fun nameProperty() = getProperty(PersonSME::name)

    var title by property(title)
    fun titleProperty() = getProperty(PersonSME::title)
}



package com.marsdev.tornadofx.cwsamples.asyncex


import javafx.beans.property.SimpleIntegerProperty
import javafx.beans.property.SimpleStringProperty
import tornadofx.*
import javax.json.JsonObject

class Customer : JsonModel {
    val lastNameProperty = SimpleStringProperty()
    var lastName by lastNameProperty

    val firstNameProperty = SimpleStringProperty()
    var firstName by firstNameProperty

    val idProperty = SimpleIntegerProperty()
    var id by idProperty

    override fun toString() = "$firstName $lastName"

    override fun updateModel(json: JsonObject) = with(json) {
        id = getInt("id")
        firstName = getString("firstName")
        lastName = getString("lastName")
    }
}
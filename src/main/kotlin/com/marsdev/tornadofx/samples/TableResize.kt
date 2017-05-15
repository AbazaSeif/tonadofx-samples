package com.marsdev.tornadofx.samples


import javafx.beans.property.SimpleStringProperty
import javafx.collections.FXCollections
import tornadofx.*


class TestApp : App(TestView::class)

class TestView : View("My View") {
    override val root = borderpane {
        center {
            val list = FXCollections.observableArrayList<String>()
            list.add("xxxxxxxxxx".replace("x", "Hello "))
            list.add("xxxxxxxxxx".replace("x", "World "))
            tableview(list) {
                column("Length", String::length)
                column<String, String>("Contents", { SimpleStringProperty(it.value) })
                column("Length", String::length)
                columnResizePolicy = SmartResize.POLICY
            }
        }
    }
}

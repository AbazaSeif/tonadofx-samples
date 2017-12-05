package com.marsdev.tornadofx.samples.book

import javafx.geometry.Pos
import javafx.scene.text.FontWeight
import tornadofx.*
import java.time.LocalDate
import java.time.Period

class ListViewCustomFormatting : App(ListViewCustomFormattingView::class)

class ListViewCustomFormattingView : View("ListViewCustomFormatting") {

    val persons = listOf(
            Person("John Marlow", LocalDate.of(1982, 11, 2)),
            Person("Samantha James", LocalDate.of(1973, 2, 4))
    ).observable()

    override val root = listview(persons) {
        cellCache {
            form {
                fieldset {
                    field("Name") {
                        label(it.name)
                    }
                    field("Birthday") {
                        label(it.birthday.toString())
                    }
                    label("${it.age} years old") {
                        alignment = Pos.CENTER_RIGHT
                        style {
                            fontSize = 22.px
                            fontWeight = FontWeight.BOLD
                        }
                    }
                }
            }
        }
    }
}

class Person(val name: String, val birthday: LocalDate) {
    val age: Int get() = Period.between(birthday, LocalDate.now()).years
}

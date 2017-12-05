package com.marsdev.tornadofx.samples.book

import javafx.scene.paint.Color
import tornadofx.*
import java.time.LocalDate
import java.time.Period

class TableViewExampleApp : App(TableViewExampleView::class)

class TableViewExampleView : View("TableView Example") {
    private val persons = listOf(
            TablePerson(1, "Samantha Stuart", LocalDate.of(1981, 12, 4)),
            TablePerson(2, "Tom Marks", LocalDate.of(2001, 1, 23)),
            TablePerson(3, "Stuart Gills", LocalDate.of(1989, 5, 23)),
            TablePerson(3, "Nicole Williams", LocalDate.of(1998, 8, 11))
    ).observable()

    override val root = borderpane {
        center {
            tableview<TablePerson> {
                items = persons
                column("ID", TablePerson::id)
                column("Name", TablePerson::name)
                column("Birthday", TablePerson::birthday)
                column("Age", TablePerson::age).cellFormat {
                    text = it.toString()
                    style {
                        if (it < 18) {
                            backgroundColor += c("#8b0000")
                            textFill = Color.WHITE
                        }
                    }
                }
            }
        }
    }
}

class TablePerson(val id: Int, val name: String, val birthday: LocalDate) {
    val age: Int get() = Period.between(birthday, LocalDate.now()).years
}

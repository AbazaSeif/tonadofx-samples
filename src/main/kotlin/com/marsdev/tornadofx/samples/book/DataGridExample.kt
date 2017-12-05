package com.marsdev.tornadofx.samples.book

import javafx.scene.paint.Color
import tornadofx.*

class DataGridExampleApp : App(DataGridExampleView::class)

class DataGridExampleView : View("DataGridExample") {
    val numbers = (1..25).toList()

    override val root = borderpane {
        center {
            datagrid(numbers) {
                cellHeight = 75.0
                cellWidth = 75.0

                multiSelect = true

                cellCache {
                    stackpane {
                        circle(radius = 25.0) {
                            fill = Color.FORESTGREEN
                        }
                        label(it.toString())
                    }
                }
            }        }
    }
}

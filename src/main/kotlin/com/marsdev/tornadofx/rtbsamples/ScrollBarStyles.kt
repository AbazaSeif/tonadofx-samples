package com.marsdev.tornadofx.rtbsamples

import javafx.scene.control.SelectionMode
import javafx.scene.paint.Color
import tornadofx.*

class ScrollApp : App(ScrollBarStylesView::class, Styles::class) {
    init {
        reloadStylesheetsOnFocus()
    }
}

class ScrollBarStylesView : View("Simple View") {
    override val root = borderpane {
        prefHeight = 100.0
        center {
            titledpane {
                listview<String> {
                    items.add("Batman")
                    items.add("Robin")
                    items.add("Nightwing")
                    items.add("Alfred")
                    items.add("Joker")
                    items.add("Superman")
                    items.add("Green Arrow")
                    items.add("The Flash")
                    items.add("Speedy")
                    items.add("Wonder Woman")
                    items.add("Green Lantern")
                    items.add("Supergirl")
                    items.add("Kid Flash")
                    items.add("Cyborg")
                    items.add("Raven")
                    selectionModel.selectionMode = SelectionMode.MULTIPLE
                }

            }
        }
    }
}

class Styles : Stylesheet() {

    companion object {
    }

    init {

        listView {
            virtualFlow {
                scrollBar and vertical {
                    s(incrementButton, decrementButton) {
                        backgroundColor += c(9, 5, 165, 0.81)
                        backgroundRadius += box(2.em)
                        padding = box(8.px)
                    }
                }

            }
        }

        titledPane {
            title {
                arrowButton {
                    arrow {
                        backgroundColor += Color.RED
                    }
                }
            }
        }

    }
}



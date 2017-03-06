package com.marsdev.tornadofx.samples.wordmenu

import javafx.scene.control.MenuButton
import javafx.scene.control.MenuItem
import javafx.scene.paint.Color
import tornadofx.*


/**
 * Inspired by http://stackoverflow.com/questions/28717343/javafx-create-a-vertical-menu-ribbon
 */
class WordMenuApp : App(WordMenuView::class, WordMenuCss::class)

class WordMenuView : View("Word Menu") {
    lateinit var menuButton: MenuButton

    init {
        menuButton = MenuButton()
        // todo needs to be determined by the longest width in it's children?
        menuButton.prefWidth = 59.0
        menuButton.items += MenuItem("Info")
        menuButton.items += MenuItem("New")
        menuButton.items += MenuItem("Save")
        menuButton.items += MenuItem("Save As")
        menuButton.items += MenuItem("Print")
        menuButton.items += MenuItem("Export")
        menuButton.items += MenuItem("Close")

    }

    override val root = borderpane {

        prefHeight = 350.0
        prefWidth = 75.0
        top = menuButton

    }
}

class WordMenuCss : Stylesheet() {

    init {
        menuButton {
            backgroundColor += c("#28559c")

            menuButton {
                backgroundColor += c("#28559c")
            }

            contextMenu {
                backgroundColor += c("#28559c")
            }

            menuItem {
                backgroundColor += c("#28559c")

                label {
                    textFill = Color.WHITE
                }

                and(hover) {
                    backgroundColor += c("#3b6bb7")
                }

            }
            backgroundRadius += box(0.px)

            arrowButton {
                backgroundColor += Color.WHITE
                backgroundColor += c("#28559c")
                backgroundInsets = multi(box(1.px), box(3.px))
                backgroundRadius = multi(box(16.px), box(16.px))
                padding = box(8.px)

                arrow {
                    backgroundColor += Color.WHITE
                    padding = box(8.px)
                    shape = "M0 6 l-6 -6 l0 -2 l6 -6 l2 0 l-6 6 l12 0 l0 2 l-12 0 l6 6 z"
                }
            }
        }
    }

}

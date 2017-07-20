package com.marsdev.tornadofx.so

import javafx.geometry.Pos
import javafx.scene.layout.StackPane
import javafx.scene.paint.Color
import javafx.stage.Stage
import tornadofx.*


class UserInputUI : App(InputView::class, UIStyles::class) {
    init {
        reloadStylesheetsOnFocus()
    }

    override fun start(stage: Stage) {
        stage.minWidth = 1024.0
        stage.minHeight = 768.0
        super.start(stage)
    }
}

class InputView : View() {
    override val root = StackPane()

    init {
        text("I wish to be centered") {
            stackpaneConstraints {
                alignment = Pos.CENTER
                addClass(UIStyles.headerFontStyle)
            }
        }
    }
}

class UIStyles : Stylesheet() {
    companion object {
        val headerFontStyle by cssclass()
        private val headerFontColor = Color.BLACK
    }

    init {
        headerFontStyle {
            fontSize = 48.px
        }
    }
}
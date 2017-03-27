package com.marsdev.tornadofx.css

import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.paint.Color
import tornadofx.*


class MetroUI : Stylesheet() {
    companion object {

    }

    init {

        button {
            padding = box(5.px, 22.px, 5.px, 22.px)
            borderStyle += BorderStrokeStyle.NONE
            borderColor += box(Color.TRANSPARENT)
            backgroundRadius += box(0.px)
            backgroundColor += c("#299bb4")
            borderInsets += box(0.px)
            fontFamily = "Segoe UI Semibold"
            fontSize = 12.px
            textFill = Color.WHITE

        }
    }
}

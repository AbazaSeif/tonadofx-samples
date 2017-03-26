package com.marsdev.tornadofx.style

import javafx.scene.paint.Color
import javafx.scene.text.FontWeight
import tornadofx.*

class DefaultStyle : Stylesheet() {

    companion object {
        val sectionLabel by cssclass()
    }

    init {
        sectionLabel {
            fontWeight = FontWeight.NORMAL
            textFill = Color.BLACK.derive(0.3)

        }
    }
}
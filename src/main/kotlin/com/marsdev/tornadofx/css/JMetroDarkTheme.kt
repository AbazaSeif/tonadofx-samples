package com.marsdev.tornadofx.css

import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.paint.Color
import tornadofx.*

/**
 * Based on the work done by Pedro Duque Vieira on JMetroDarkTheme.css
 */
class JMetroDarkTheme : Stylesheet() {
    companion object {
        val tfxBackgroundColor = c("1d1d1d")
        val background by cssclass()
        val header by cssclass()
        val itemTitle by cssclass()

    }

    init {
        background {
            backgroundColor += tfxBackgroundColor
        }

        header {
            fontSize = 42.pt
            fontFamily = "Segoe UI Light"
            textFill = Color.WHITE
        }

        itemTitle {
            fontSize = 11.pt
            fontFamily = "Segoe UI Semibold"
            textFill = Color.WHITE
            opacity = 0.6
        }

        button {
            padding = box(5.px, 22.px, 5.px, 22.px)
            borderColor += box(c("e2e2e2"))
            borderWidth += box(2.px)
            backgroundRadius += box(0.px)
            backgroundColor += tfxBackgroundColor
            fontFamily = "Segoe UI, Helvetica, Arial, sans-serif"
            fontSize = 11.pt
            textFill = c("#d8d8d8")

            and(hover) {
                backgroundColor += c("#3a3a3a")
            }
            and(pressed) {
                backgroundColor += Color.WHITE
                textFill = tfxBackgroundColor
            }
            and(focused) {
                borderColor += box(Color.WHITE, Color.WHITE)
                borderWidth += box(1.px, 2.px)
                borderStyle += BorderStrokeStyle.SOLID
                borderRadius += box(0.px, 0.px)
                borderInsets = multi(box(1.px), box(1.px), box(1.px), box(1.px), box(0.px))
            }
        }

    }
}


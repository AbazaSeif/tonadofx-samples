package com.marsdev.tornadofx.style

import javafx.scene.paint.Color
import javafx.scene.paint.CycleMethod
import javafx.scene.paint.LinearGradient
import javafx.scene.paint.Stop
import javafx.scene.text.FontWeight
import tornadofx.*

class DefaultStyle : Stylesheet() {

    companion object {
        // colors
        val tfxBase = c("#ececec")
        val tfxBackground = tfxBase.derive(26.4)
        val tfxDarkTextColor = c("#000000")
        val tfxMidTextColor = c("#333")
        val tfxLightTextColor = c("#ffffff")
        val tbcStops = arrayOf(
                Stop(0.45, tfxLightTextColor),
                Stop(0.46, tfxDarkTextColor),
                Stop(0.59, tfxDarkTextColor),
                Stop(0.60, tfxMidTextColor)
        )

        val tfxTextBackgroundColor = tfxBackground.ladder(*tbcStops)

        val tfxAccent = c("#0096c9")
        val tfxDefaultButton = c("#abd8ed")
        val tfxFocusColor = c("#039ed3")
        val tfxFaintFocusColor = c("#039ed322")
        val tfxColor = tfxBase

        // -fx-shadow-highlight-color ladder stops
        val shcStops = arrayOf(
                Stop(0.0, Color.rgb(255, 255, 255, 0.07)),
                Stop(0.2, Color.rgb(255, 255, 255, 0.07)),
                Stop(0.7, Color.rgb(255, 255, 255, 0.07)),
                Stop(0.9, Color.rgb(255, 255, 255, 0.7)),
                Stop(1.0, Color.rgb(255, 255, 255, 0.75))
        )
        // -fx-shadow-highlight-color
        val tfxShadowHighlightColor = tfxBackground.ladder(*shcStops)

        // -fx-outer-border
        val tfxOuterBorder = tfxColor.derive(-0.23)

        // -fx-inner-border stops
        val ibStops1 = arrayOf(
                Stop(0.0, tfxColor.derive(0.3)),
                Stop(0.4, tfxColor.derive(0.2)),
                Stop(0.6, tfxColor.derive(0.25)),
                Stop(0.8, tfxColor.derive(0.55)),
                Stop(0.9, tfxColor.derive(0.55)),
                Stop(1.0, tfxColor.derive(0.75))
        )
        val ibStops2 = arrayOf(
                Stop(0.0, tfxColor.derive(0.2)),
                Stop(0.2, tfxColor.derive(0.10)),
                Stop(0.4, tfxColor.derive(0.5)),
                Stop(0.6, tfxColor.derive(-0.2)),
                Stop(1.0, tfxColor.derive(-0.5))
        )

        // -fx-inner-border
        val tfxInnerBorder = LinearGradient(0.0, 0.0, 1.0, 0.0, false, CycleMethod.REFLECT, *ibStops1, *ibStops2)

        // -fx-body-color stops
        val bcStops = arrayOf(
                Stop(0.75, tfxColor.derive(0.08)),
                Stop(0.8, tfxColor.derive(0.1))
        )

        //-fx-body-color
        val tfxBodyColor = tfxColor.ladder(*bcStops)

        val sectionLabel by cssclass()
        val sectionBorder by cssclass()
    }

    init {
        sectionLabel {
            fontWeight = FontWeight.NORMAL
            textFill = tfxTextBackgroundColor.derive(0.30)
        }

        sectionBorder {
            val stops = arrayOf(
                    Stop(0.1, tfxBackground.derive(-0.1)),
                    Stop(-0.1, tfxBackground.derive(0.1))
            )
            borderColor += box(tfxBackground.ladder(*stops))
            padding = box(20.px)
        }

        // button
        button {
            backgroundColor = multi(tfxShadowHighlightColor, tfxOuterBorder, tfxInnerBorder, tfxBodyColor)
//            backgroundColor  += tfxBodyColor
            and(default) {

            }
        }
    }
}
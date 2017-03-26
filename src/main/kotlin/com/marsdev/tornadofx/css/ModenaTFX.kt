package com.marsdev.tornadofx.css

import javafx.scene.paint.Stop
import tornadofx.*

class ModenaTFX : Stylesheet() {

    companion object {
        /***************************************************************************
         *                                                                         *
         * The main color palette from which the rest of the colors are derived.   *
         *                                                                         *
         **************************************************************************/

        /* A light grey that is the base color for objects.  Instead of using
         * -fx-base directly, the sections in this file will typically use -fx-color.
         */
        val tfxBase = c("#ececec")

        /* A very light grey used for the background of windows.  See also
         * -fx-text-background-color, which should be used as the -fx-text-fill
         * value for text painted on top of backgrounds colored with -fx-background.
         */
        val tfxBackground = tfxBase.derive(26.4)

        val tfxDarkTextColor = c("#000000")
        val tfxMidTextColor = c("#333")
        val tfxLightTextColor = c("#FFFFFF")
        val tbcStops = arrayOf(
                Stop(0.45, tfxLightTextColor),
                Stop(0.46, tfxDarkTextColor),
                Stop(0.59, tfxDarkTextColor),
                Stop(0.60, tfxMidTextColor)
        )

        val tfxTextBackgroundColor = tfxBackground.ladder(*tbcStops)
    }

    init {
    }
}
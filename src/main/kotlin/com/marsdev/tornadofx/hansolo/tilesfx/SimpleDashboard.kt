package com.marsdev.tornadofx.hansolo.tilesfx

import eu.hansolo.tilesfx.Tile
import eu.hansolo.tilesfx.TileBuilder
import javafx.animation.AnimationTimer
import javafx.scene.paint.Color.rgb
import javafx.scene.paint.Stop
import tornadofx.*
import java.util.*

class SDApp : App(SDView::class)

class SDView : View("Simple Dashboard") {
    private val RND = Random()
    private val TILE_WIDTH = 4000.0
    private val TILE_HEIGHT = 4000.0
    var percentageTile: Tile = TileBuilder.create()
            .skinType(Tile.SkinType.PERCENTAGE)
            .prefSize(TILE_WIDTH, TILE_HEIGHT)
            .title("Percentage Tile")
            .unit("\u0025")
            .description("Test")
            .maxValue(60.0)
            .build()
    val sparkLineTile = TileBuilder.create()
            .skinType(Tile.SkinType.SPARK_LINE)
            .prefSize(TILE_WIDTH, TILE_HEIGHT)
            .title("SparkLine Tile")
            .unit("mb")
            .gradientStops(Stop(0.0, Tile.GREEN),
                    Stop(0.5, Tile.YELLOW),
                    Stop(1.0, Tile.RED))
            .strokeWithGradient(true)
            .smoothing(true)
            .build()

    var lastTimerCall = System.nanoTime()

    init {
        val timer = object : AnimationTimer() {
            override fun handle(now: Long) {
                if (now > lastTimerCall + 3_500_000_000L) {
                    percentageTile.value = RND.nextDouble() * percentageTile.range * 1.5 + percentageTile.minValue
                    sparkLineTile.value = RND.nextDouble() * sparkLineTile.range * 1.5 + sparkLineTile.minValue
                    lastTimerCall = now
                }
            }
        }
        timer.start()
    }

    override val root = gridpane {
        prefWidth = 800.0
        prefHeight = 400.0
        style {
            backgroundColor += rgb(42, 42, 42)
        }
        row {
            add(percentageTile)
            add(sparkLineTile)
        }
    }
}
package com.marsdev.tornadofx.ev.tiles

import com.marsdev.tornadofx.ev.tiles.Styles.Companion.gridPaneHolder
import javafx.scene.Node
import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import javafx.scene.layout.GridPane
import javafx.scene.paint.Color
import javafx.scene.shape.StrokeType
import tornadofx.*

class TilesApp : App(MyTiles::class, Styles::class)
class MyTiles : View("My tiles") {
    val tile1Color = c("#3ca6b2")
    val tile2Color = c("#b22a51")


    override val root = gridpane {
        addClass(gridPaneHolder)
        tile(0, 4, tile1Color, stroke = tile1Color, width = 290, height = 100, mainNode = createTileNode("Super Exciting App", "green"), secondNode = createTileNode("The real thing...", "blue"))
        tile(3, 3, tile2Color, stroke = tile2Color, width = 200, height = 200, mainNode = createTileNode("Another Cool App", "yellow"), secondNode = createTileNode("Really that nice?", "red"))
        tile(1, 0, c("#1ec3ff"), stroke = c("#1ec3ff"), mainNode = Label("here"), secondNode = Label("there"))
    }
}

fun GridPane.tile(rowIndex: Int, colIndex: Int, fill: Color = Color.WHITE, secondaryFill: Color = Color.LIGHTBLUE, stroke: Color = Color.WHITE, rowSpan: Int = 1, colSpan: Int = 1, width: Number = 90, height: Number = 90, mainNode: Node, secondNode: Node) {
    val surprise = ViewTransition.Flip(.1.seconds, true)
    mainNode.setOnMouseClicked {
        mainNode.replaceWith(secondNode, surprise)
    }
    secondNode.setOnMouseClicked { secondNode.replaceWith(mainNode, surprise) }
    stackpane {
        rectangle {
            this.stroke = stroke
            this.fill = fill
            this.width = width.toDouble()
            this.height = height.toDouble()
            this.strokeType = StrokeType.OUTSIDE
            addClass("module_tile")

        }
        GridPane.setRowIndex(this, rowIndex)
        GridPane.setRowSpan(this, rowSpan)
        GridPane.setColumnIndex(this, colIndex)
        GridPane.setColumnSpan(this, colSpan)
        add(mainNode)
    }
}

fun createTileNode(text: String, bgColor: String): Node {
    val tile = BorderPane()
    tile.style = "-fx-background-color:$bgColor"
    tile.center = Label(text)

    return tile
}

class Styles : Stylesheet() {

    companion object {
        val color = c("#b22a51")
        val tile2Color by cssclass()
        val gridPaneHolder by cssclass()
    }

    init {
        gridPaneHolder {
            backgroundColor += Color.BLACK
        }
    }
}
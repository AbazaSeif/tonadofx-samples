package com.marsdev.tornadofx.style

import com.marsdev.tornadofx.style.DefaultStyle.Companion.sectionLabel
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Label
import tornadofx.*


class ControlGallery : View("Controls") {
    override val root = gridpane {
        vgap = 25.0
        hgap = 15.0

        padding = insets(15.0)

        row {
            this += newSection("Label", Label("Label"), withState(Label("Disabled"), "disabled")!!)
        }

        row {
            this += newSection("Button",
                    Button("Button"),
                    withState(Button("Hover"), "hover")!!,
                    withState(Button("Armed"), "armed")!!,
                    withState(Button("Focused"), "focused")!!,
                    withState(Button("Focused & Hover"), "focused, hover")!!,
                    withState(Button("Focused & Armed"), "focused, armed")!!,
                    withState(Button("Disabled"), "disabled")!!
            )
        }

    }

    fun newSection(name: String, vararg children: Node): Node {
        val box = hbox(10.0) {
            label(name) {
                addClass(sectionLabel)
            }
        }
        box.children.addAll(children)
        return box
    }
}

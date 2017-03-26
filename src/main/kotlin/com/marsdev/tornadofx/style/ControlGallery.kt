package com.marsdev.tornadofx.style

import com.marsdev.tornadofx.css.JMetroDarkTheme
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Label
import tornadofx.*


class ControlGallery : View("Controls") {
    override val root = gridpane {
        addClass(JMetroDarkTheme.background)
        vgap = 25.0
        hgap = 15.0

        padding = insets(15.0)

        row {
            this += newSection("Label:", Label("Label"), withState(Label("Disabled"), "disabled")!!)
        }

        row {
            this += newSection("Button:",
                    Button("Button"),
                    withState(Button("Hover"), "hover")!!,
                    withState(Button("Armed"), "armed")!!,
                    withState(Button("Focused"), "focused")!!,
                    withState(Button("Focused & Hover"), "focused, hover")!!,
                    withState(Button("Focused & Armed"), "focused, armed")!!,
                    withState(Button("Disabled"), "disabled")!!
            )
        }

        row {
            val defaultButton = button("Default Button")
            defaultButton.isDefaultButton = true
            this += newSection("Default Button:",
                    defaultButton,
                    withState(Button("Hover"), "default, hover")!!,
                    withState(Button("Armed"), "default, armed")!!,
                    withState(Button("Focused"), "default, focused")!!,
                    withState(Button("Focused & Hover"), "default, focused, hover")!!,
                    withState(Button("Focused & Armed"), "default, focused, armed")!!,
                    withState(Button("Disabled"), "default disabled")!!

            )
        }


    }

    fun newSection(name: String, vararg children: Node): Node {
        val box = hbox(10.0) {
            label(name) {
                //                addClass(sectionLabel)
                setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE)
            }
        }
        box.children.addAll(children)
//        box.addClass(sectionBorder)
        return box
    }
}

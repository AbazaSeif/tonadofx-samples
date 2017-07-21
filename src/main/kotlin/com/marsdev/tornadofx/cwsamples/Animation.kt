package com.marsdev.tornadofx.cwsamples

import javafx.animation.Interpolator
import javafx.animation.SequentialTransition
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.util.Duration
import tornadofx.*

class STApp : App(STTest::class)

class STTest : View("My View") {

    val r1 = Rectangle(20.0, 20.0, Color.RED)
    val r2 = Rectangle(20.0, 20.0, Color.YELLOW)
    val r3 = Rectangle(20.0, 20.0, Color.GREEN)
    val r4 = Rectangle(20.0, 20.0, Color.BLUE)

    override val root = vbox {

        button("Animate") {
            setOnAction {

                val t1 = timeline(false) {
                    keyframe(Duration.seconds(0.5)) {
                        keyvalue(r1.translateXProperty(), 50.0, interpolator = Interpolator.EASE_BOTH)
                    }
                }
                val t2 = timeline(false) {
                    keyframe(Duration.seconds(0.5)) {
                        keyvalue(r2.translateXProperty(), 100.0, interpolator = Interpolator.EASE_BOTH)
                    }
                }
                val t3 = timeline(false) {
                    keyframe(Duration.seconds(0.5)) {
                        keyvalue(r3.translateXProperty(), 150.0, interpolator = Interpolator.EASE_BOTH)
                    }
                }
                val t4 = timeline(false) {
                    keyframe(Duration.seconds(0.5)) {
                        keyvalue(r4.translateXProperty(), 200.0, interpolator = Interpolator.EASE_BOTH)
                    }
                }

                val st = SequentialTransition()
                st.children += t1
                st.children += t2
                st.children += t3
                st.children += t4

                st.play()
            }
        }
        pane {
            add(r1)
            add(r2)
            add(r3)
            add(r4)
        }
    }

}
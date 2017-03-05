package com.marsdev.tornadofx.cwsamples

import tornadofx.*

/**
 * Example from Carl Walker (@carlw) on 3/5/2017 demonstrating a button now
 * showing up.
 */
class BadViewApp : App(BadView::class)

class BadView : View() {

    override val root = vbox {
        paddingAll = 60
        label("Hi") {
            stackpane {
                button("More Contents")
            }
        }
    }
}


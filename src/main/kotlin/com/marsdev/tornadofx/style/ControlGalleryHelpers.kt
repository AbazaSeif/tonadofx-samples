package com.marsdev.tornadofx.style

import javafx.css.PseudoClass
import javafx.scene.Node


fun <T : Node> withState(node: T?, state: String?): T? {
    if (node != null && state != null) {
        // stop user from being able to change state
        node.isMouseTransparent = true
        node.isFocusTraversable = false
        // set state to chosen state
        val pseudoClasses = state.split("[\\s,]+".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        for (pseudoClass in pseudoClasses) {
            node.pseudoClassStateChanged(PseudoClass.getPseudoClass(pseudoClass), true)
        }
    }
    return node
}
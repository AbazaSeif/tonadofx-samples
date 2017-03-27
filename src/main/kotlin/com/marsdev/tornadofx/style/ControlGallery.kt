package com.marsdev.tornadofx.style

import com.marsdev.tornadofx.style.DefaultStyle.Companion.sectionBorder
import com.marsdev.tornadofx.style.DefaultStyle.Companion.sectionLabel
import javafx.css.PseudoClass
import tornadofx.*


class ControlGallery : View("Controls") {
    override val root = gridpane {
        vgap = 25.0
        hgap = 15.0
        padding = insets(15.0)


        row {
            label("Label:") {
                addClass(sectionLabel)
                setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE)
            }
            hbox(10.0) {
                addClass(sectionBorder)
                label("Label") {
                    isMouseTransparent = true
                    isFocusTraversable = false
                }
                label("Disabled") {
                    isMouseTransparent = true
                    isFocusTraversable = false
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("disabled"), true)
                }
            }
        }

        row {
            label("Button:") {
                addClass(sectionLabel)
                setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE)
            }
            hbox(10.0) {
                addClass(sectionBorder)
                button("Button") {
                    isMouseTransparent = true
                    isFocusTraversable = false
                }
                button("Hover") {
                    isMouseTransparent = true
                    isFocusTraversable = false
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("hover"), true)
                }
                button("Armed") {
                    isMouseTransparent = true
                    isFocusTraversable = false
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("armed"), true)
                }
                button("Focused") {
                    isMouseTransparent = true
                    isFocusTraversable = false
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("focused"), true)
                }
                button("Focused & Hover") {
                    isMouseTransparent = true
                    isFocusTraversable = false
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("focused"), true)
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("hover"), true)
                }
                button("Focused & Armed") {
                    isMouseTransparent = true
                    isFocusTraversable = false
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("focused"), true)
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("armed"), true)
                }
                button("Disabled") {
                    isMouseTransparent = true
                    isFocusTraversable = false
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("disabled"), true)
                }
            }
        }

        row {
            label("Default Button:") {
                addClass(sectionLabel)
                setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE)
            }
            hbox(10.0) {
                addClass(sectionBorder)
                button("Button") {
                    isDefaultButton = true
                    isMouseTransparent = true
                    isFocusTraversable = false
                }
                button("Hover") {
                    isDefaultButton = true
                    isMouseTransparent = true
                    isFocusTraversable = false
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("hover"), true)
                }
                button("Armed") {
                    isDefaultButton = true
                    isMouseTransparent = true
                    isFocusTraversable = false
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("armed"), true)
                }
                button("Focused") {
                    isDefaultButton = true
                    isMouseTransparent = true
                    isFocusTraversable = false
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("focused"), true)
                }
                button("Focused & Hover") {
                    isDefaultButton = true
                    isMouseTransparent = true
                    isFocusTraversable = false
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("focused"), true)
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("hover"), true)
                }
                button("Focused & Armed") {
                    isDefaultButton = true
                    isMouseTransparent = true
                    isFocusTraversable = false
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("focused"), true)
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("armed"), true)
                }
                button("Disabled") {
                    isDefaultButton = true
                    isMouseTransparent = true
                    isFocusTraversable = false
                    pseudoClassStateChanged(PseudoClass.getPseudoClass("disabled"), true)
                }
            }
        }

        row {
            label("Nice Colors:") {
                addClass(sectionLabel)
                setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE)
            }
            hbox(10.0) {
                addClass(sectionBorder)
                button("Button") {
                    style += "-fx-base:#f3622d"
                    isMouseTransparent = true
                    isFocusTraversable = false
                }
                button("Button") {
                    style += "-fx-base:#fba71b"
                    isMouseTransparent = true
                    isFocusTraversable = false
                }
                button("Button") {
                    style += "-fx-base:#57b757"
                    isMouseTransparent = true
                    isFocusTraversable = false
                }
                button("Button") {
                    style += "-fx-base:#41a9c9"
                    isMouseTransparent = true
                    isFocusTraversable = false
                }
                button("Button") {
                    style += "-fx-base:#888"
                    isMouseTransparent = true
                    isFocusTraversable = false
                }
            }
        }

        row {
            label("Greys:") {
                addClass(sectionLabel)
                setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE)
            }
            hbox(0.0) {
                addClass(sectionBorder)
                stackpane {
                    style += "-fx-base: rgba(${0.0 * 255},${0.0 * 255},${0.0 * 255},1); -fx-background-color: -fx-background;"
                    padding = insets(8.0)
                    button("0%") {
                        isMouseTransparent = true
                        isFocusTraversable = false
                    }
                }
                stackpane {
                    style += "-fx-base: rgba(${0.1 * 255},${0.1 * 255},${0.1 * 255},1); -fx-background-color: -fx-background;"
                    padding = insets(8.0)
                    button("10%") {
                        isMouseTransparent = true
                        isFocusTraversable = false
                    }
                }
                stackpane {
                    style += "-fx-base: rgba(${0.2 * 255},${0.2 * 255},${0.2 * 255},1); -fx-background-color: -fx-background;"
                    padding = insets(8.0)
                    button("20%") {
                        isMouseTransparent = true
                        isFocusTraversable = false
                    }
                }
                stackpane {
                    style += "-fx-base: rgba(${0.3 * 255},${0.3 * 255},${0.3 * 255},1); -fx-background-color: -fx-background;"
                    padding = insets(8.0)
                    button("30%") {
                        isMouseTransparent = true
                        isFocusTraversable = false
                    }
                }
                stackpane {
                    style += "-fx-base: rgba(${0.4 * 255},${0.4 * 255},${0.4 * 255},1); -fx-background-color: -fx-background;"
                    padding = insets(8.0)
                    button("40%") {
                        isMouseTransparent = true
                        isFocusTraversable = false
                    }
                }
                stackpane {
                    style += "-fx-base: rgba(${0.5 * 255},${0.5 * 255},${0.5 * 255},1); -fx-background-color: -fx-background;"
                    padding = insets(8.0)
                    button("50%") {
                        isMouseTransparent = true
                        isFocusTraversable = false
                    }
                }
                stackpane {
                    style += "-fx-base: rgba(${0.6 * 255},${0.6 * 255},${0.6 * 255},1); -fx-background-color: -fx-background;"
                    padding = insets(8.0)
                    button("60%") {
                        isMouseTransparent = true
                        isFocusTraversable = false
                    }
                }
                stackpane {
                    style += "-fx-base: rgba(${0.7 * 255},${0.7 * 255},${0.7 * 255},1); -fx-background-color: -fx-background;"
                    padding = insets(8.0)
                    button("70%") {
                        isMouseTransparent = true
                        isFocusTraversable = false
                    }
                }
                stackpane {
                    style += "-fx-base: rgba(${0.8 * 255},${0.8 * 255},${0.8 * 255},1); -fx-background-color: -fx-background;"
                    padding = insets(8.0)
                    button("80%") {
                        isMouseTransparent = true
                        isFocusTraversable = false
                    }
                }
                stackpane {
                    style += "-fx-base: rgba(${0.9 * 255},${0.9 * 255},${0.9 * 255},1); -fx-background-color: -fx-background;"
                    padding = insets(8.0)
                    button("90%") {
                        isMouseTransparent = true
                        isFocusTraversable = false
                    }
                }
                stackpane {
                    style += "-fx-base: rgba(${1.0 * 255},${1.0 * 255},${1.0 * 255},1); -fx-background-color: -fx-background;"
                    padding = insets(8.0)
                    button("100%") {
                        isMouseTransparent = true
                        isFocusTraversable = false
                    }
                }


            }
        }


    }

}

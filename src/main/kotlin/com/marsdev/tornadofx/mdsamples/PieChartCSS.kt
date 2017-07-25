package com.marsdev.tornadofx.mdsamples

import tornadofx.*

class ChartApp : App(ChartView::class, ChartCSS::class)

class ChartCSS : Stylesheet() {

    companion object {
        val defaultPieChart by cssclass()
    }

    init {
        defaultPieChart {
            defaultColor0 { backgroundColor += c("#ffd700") }
            defaultColor1 { backgroundColor += c("#ffa500") }
            defaultColor2 { backgroundColor += c("#860061") }
            defaultColor3 { backgroundColor += c("#adff2f") }
            defaultColor4 { backgroundColor += c("#adff2f") }
        }
    }
}

class ChartView : View("Chart View") {
    override val root = borderpane {
        center {
            piechart("Desktop/Laptop OS Market Share") {
                addClass(ChartCSS.defaultPieChart)
                data("Windows", 77.62)
                data("OS X", 9.52)
                data("Other", 3.06)
                data("Linux", 1.55)
                data("Chrome OS", 0.55)
            }
        }
    }
}
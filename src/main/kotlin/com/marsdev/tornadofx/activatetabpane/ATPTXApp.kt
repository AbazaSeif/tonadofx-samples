/*
 * Copyright (c) 2017 Mercuria Energy America, Inc.
 *  All rights reserved.
 *
 *  This software is the confidential and proprietary information of
 *  Mercuria Energy America, Inc ("Confidential Information").  You
 *  shall not disclose such Confidential Information and shall use
 *  it only in accordance with the terms of the license agreement you
 *  entered into with Mercuria Energy America, Inc.
 *
 *  ATPTXApp
 *  jchildress
 */
package com.marsdev.tornadofx.activatetabpane

import javafx.scene.control.Tab
import javafx.scene.control.TabPane
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import tornadofx.*

class ATPTXApp : App(ATPTXView::class)

class ATPTXView : View("Tab Test") {

    val tabPane = TabPane()
    val tab0 = Tab("blue")
    val tab1 = Tab("green")

    init {
        tab0.content = Rectangle(200.0, 200.0, Color.BLUE)
        tab1.content = Rectangle(200.0, 200.0, Color.GREEN)
        tabPane.tabs.addAll(tab0, tab1)
    }

    override val root = borderpane {
        top {
            hbox(5.0) {
                button("Select blue") {
                    setOnAction { tabPane.selectionModel.select(tab0) }
                }
                button("Select green") {
                    setOnAction { tabPane.selectionModel.select(tab1) }
                }
            }
        }
        center = tabPane

    }
}
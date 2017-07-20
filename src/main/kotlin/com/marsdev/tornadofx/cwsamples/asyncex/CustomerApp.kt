package com.marsdev.tornadofx.cwsamples.asyncex

import javafx.scene.Scene
import tornadofx.*


class CustomerApp : App(MainView::class) {
    val api: Rest by inject()

    override fun createPrimaryScene(view: UIComponent) = Scene(view.root, 568.0, 320.0)

    init {
        api.baseURI = "https://www.bekwam.net/data"
    }
}
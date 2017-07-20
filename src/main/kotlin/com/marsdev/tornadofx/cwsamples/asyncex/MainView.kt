package com.marsdev.tornadofx.cwsamples.asyncex

import tornadofx.*


class MainView : View("Customer App") {
    val status: TaskStatus by inject()

    override val root = vbox {
        splitpane {
            add(CustomerListFragment::class)
            add(CustomerDetailsFragment::class)
            paddingAll = 4
        }

        hbox(4.0) {
            progressbar(status.progress)
            label(status.message)
            visibleWhen { status.running }
            paddingAll = 4
        }
    }
}
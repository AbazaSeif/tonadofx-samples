package com.marsdev.tornadofx.cwsamples.asyncex

import tornadofx.*


class CustomerListFragment : Fragment() {
    val customerViewModel: CustomerViewModel by inject()

    override val root = vbox(4.0) {
        button("Refresh") {
            setOnAction { refresh() }
        }
        listview<Customer> {
            itemsProperty().bind(customerViewModel.customers)
            bindSelected(customerViewModel)
        }

        paddingAll = 10
    }

    fun refresh() {
        customerViewModel.refresh()
    }

}
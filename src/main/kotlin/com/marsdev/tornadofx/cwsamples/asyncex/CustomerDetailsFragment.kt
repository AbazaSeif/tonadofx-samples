package com.marsdev.tornadofx.cwsamples.asyncex

import tornadofx.*


class CustomerDetailsFragment : Fragment() {
    val customerViewModel: CustomerViewModel by inject()

    override val root = vbox {
        label("First Name")
        textfield(customerViewModel.selectedFirstName)
        label("Last Name")
        textfield(customerViewModel.selectedLastName)
        paddingAll = 10.0
    }
}
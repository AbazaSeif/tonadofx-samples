package com.marsdev.tornadofx.cwsamples.asyncex

import javafx.beans.property.SimpleObjectProperty
import javafx.collections.ObservableList
import tornadofx.*


class CustomerViewModel : ItemViewModel<Customer>() {
    val customerModel: CustomerModel by inject()
    val customers = SimpleObjectProperty<ObservableList<Customer>>()
    val selectedFirstName = bind { item?.firstNameProperty }
    val selectedLastName = bind { item?.lastNameProperty }

    fun refresh() {
        runAsync {
            updateMessage("Loading customers")
            updateProgress(0.4, 1.0)
            customerModel.loadCustomers()
        } ui {
            customers.set(customerModel.customers.observable())
        }
    }
}
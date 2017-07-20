package com.marsdev.tornadofx.cwsamples.asyncex

import tornadofx.*


class CustomerModel : Controller() {
    val api: Rest by inject()
    val customers = mutableListOf<Customer>()

    fun loadCustomers() {
        customers.clear()
        customers.addAll(api.get("customers.json").list().toModel())
    }
}
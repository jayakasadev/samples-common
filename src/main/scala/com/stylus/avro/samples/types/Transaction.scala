package com.stylus.avro.samples.types

case class Transaction(tranactionId: String = "",
                       payer : Account,
                       payee : Account,
                       initiatedDateTime : String = "",
                       amount: Double = 0.0)

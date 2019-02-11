package com.stylus.avro.samples.types

case class Account(bankId : String = "",
                   accountNumber : String = "",
                   dateCreated : String = "",
                   balance : Double = 0.0)

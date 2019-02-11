package com.stylus.samples.avro.types

case class Account(bankId : String = "",
                   accountNumber : String = "",
                   dateCreated : String = "",
                   balance : Double = 0.0)
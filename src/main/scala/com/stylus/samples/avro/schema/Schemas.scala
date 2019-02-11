package com.stylus.samples.avro.schema

import com.stylus.samples.avro.types.{Account, Transaction}

object Schemas {

  // v1.6.4
  // @transient lazy val account = new AvroSerDeSchema[Account](classOf[Account], SchemaFor[Account], ToRecord[Account], FromRecord[Account], AccountDecoder, AccountEncoder)
  // @transient lazy val transaction = new AvroSerDeSchema[Transaction](classOf[Transaction], SchemaFor[Transaction], ToRecord[Transaction], FromRecord[Transaction], TransactionDecoder, TransactionEncoder)

  // v2.0.4
  @transient lazy val account = new AvroSchema2[Account](classOf[Account])
  @transient lazy val transaction = new AvroSchema2[Transaction](classOf[Transaction])

  def getSchema(schema : String) : Option[SerDeSchema[_]] = {
    schema match {
      case "com.stylus.samples.avro.types.Account" => Some(account)
      case "com.stylus.samples.avro.types.Transaction" => Some(transaction)
      case _ => None // default case
    }
  }
}
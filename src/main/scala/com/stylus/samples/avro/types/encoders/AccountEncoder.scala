package com.stylus.samples.avro.types.encoders

import com.sksamuel.avro4s.Encoder
import com.stylus.samples.avro.types.Account
import org.apache.avro.Schema
import org.apache.avro.generic.GenericData

object AccountEncoder extends Encoder[Account]{
  override def encode(account: Account, schema: Schema): AnyRef = {
    val record = new GenericData.Record(schema)
    // val record = new ImmutableRecord(schema, Vector[AnyRef](Vector("bankId", account.bankId), Vector("accountNumber", account.accountNumber), Vector("dateCreated", account.dateCreated), Vector("balance", account.balance)))

    record.put("bankId", account.bankId)
    record.put("accountNumber", account.accountNumber)
    record.put("dateCreated", account.dateCreated)
    record.put("balance", account.balance)
    record
  }
}

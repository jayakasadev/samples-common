import java.util.stream.IntStream

import com.stylus.avro.samples.serialization.SerDe
import com.stylus.avro.samples.types.Account

object Main extends App{
  val account = new Account("TEST", "TEST", "TEST", 0.0)

  val serDe = new SerDe[Account]("com.stylus.avro.samples.types.Account")

  // do some performance testing
  val start = System.currentTimeMillis()
  // Vector.range(0, 1000000).map(x => serDe.deserialize(serDe.serialize(account)))
  // ParVector.range(0, 10000000).map(x => serDe.deserialize(serDe.serialize(account)))
  IntStream.range(0, 10000000).parallel.forEach((x: Int) => serDe.deserialize(serDe.serialize(account)))
  val stop = ((System.currentTimeMillis() - start) / 1000.0).asInstanceOf[Double]
  val tps = (10000000.0 / stop).asInstanceOf[Double]

  // v1.6.4
  // Single Thread
  // TPS : 30338.885349352266
  // TPS : 31009.67501860581
  // TPS : 31516.90882158278
  // MultiThreaded
  // TPS : 61042.60774020266
  // TPS : 64884.505580067475
  // Runtime: 14.663
  // TPS : 68198.86789879287
  // Runtime: 131.865
  //TPS : 75835.13441777576

  // v2.0.4
  // Multi Threaded
  // Runtime: 29.127
  // TPS : 343324.0635836166
  // Runtime: 27.318
  // TPS : 366059.0087122044
  // switching to IntStream
  // Runtime: 12.574
  // TPS : 795291.872117067
  // Runtime: 12.271
  // TPS : 814929.5085975062
  // Runtime: 12.634
  // TPS : 791514.959632737
  // Runtime: 12.718
  // TPS : 786287.1520679352
  // Runtime: 11.872
  // TPS : 842318.0592991913
  // Runtime: 11.805
  // TPS : 847098.6869970352
  println("Runtime: " + stop)
  println("TPS : " + tps)
}

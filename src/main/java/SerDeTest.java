import com.stylus.avro.samples.serialization.SerDe;
import com.stylus.avro.samples.types.Account;

import java.util.stream.IntStream;

public class SerDeTest {
    public static void main(String[] args){
        Account account = new Account("TEST", "TEST", "TEST", 0.0);

        SerDe<Account> serDe = new SerDe<Account>("com.stylus.avro.samples.types.Account");

        // do some performance testing
        long start = System.currentTimeMillis();
        IntStream.range(0, 10000000).parallel().forEach(x -> serDe.deserialize(serDe.serialize(account)));
        double stop = ((System.currentTimeMillis() - start) / 1000.0);
        double tps = (10000000.0 / stop);

        // v1.6.4
        // Single Thread
        // TPS : 31145.856043853368
        // TPS : 31788.416301099882
        // TPS : 29503.746975865935
        // MultiThreaded
        // TPS : 65526.50547146321
        // TPS : 66006.600660066
        // Runtime: 14.182
        // TPS : 70511.91651389084
        // Runtime: 119.817
        // TPS : 83460.61076474958

        // v2.0.4
        // Multi Threaded
        // Runtime: 12.116
        // TPS : 825354.9026081215
        // Runtime: 12.932
        // TPS : 773275.5954222084
        // Runtime: 12.645
        // TPS : 790826.4136022143
        // Runtime: 13.217
        // TPS : 756601.3467503972
        // Runtime: 12.793
        // TPS : 781677.479871805
        // Runtime: 12.756
        // TPS : 783944.8102853559
        // Runtime: 12.783
        // TPS : 782288.9775483063
        // Runtime: 12.048
        // TPS : 830013.2802124834
        // Runtime: 12.19
        // TPS : 820344.5447087777
        // Runtime: 12.2
        // TPS : 819672.131147541
        // Runtime: 12.147
        // TPS : 823248.5387338437
        System.out.println("Runtime: " + stop);
        System.out.println("TPS : " + tps);
    }
}

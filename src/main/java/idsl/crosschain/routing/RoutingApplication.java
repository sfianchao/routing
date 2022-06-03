package idsl.crosschain.routing;

import idsl.crosschain.routing.contract.Proxy;
import idsl.crosschain.routing.model.QuorumInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.kafka.KafkaAutoConfiguration;
import org.springframework.context.ApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
//@SpringBootApplication
@SpringBootApplication(exclude = KafkaAutoConfiguration.class)
public class RoutingApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(RoutingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    }

}

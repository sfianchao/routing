package idsl.crosschain.routing;

import idsl.crosschain.routing.contract.Proxy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.EthFilter;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.quorum.Quorum;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.io.File;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@SpringBootApplication
public class RoutingApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoutingApplication.class, args);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

//        try {
//            // connect to ganache
//            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9045"));
//            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
//            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//            log.info("client version: " + clientVersion);
//
//            // set up credentials
//            Credentials credentials = Credentials.create("a7c04cf56f4b4d08a5728b94419382a7bc3dbf108e52fada2ff655479befe2f3");
//            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
//            log.info("account address: " + credentials.getAddress()); // 0x67598f3f6ab21b913ee7ad7a57cc952a8b6afdf4
//
//            // deploy contract
////            Proxy proxy = Proxy.deploy(quorum, credentials, new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L))).send();
////            log.info("deployed contract address: " + proxy.getContractAddress());
//
//            // load contract
//            Proxy proxy = Proxy.load("0xf428a680E39eB0BEf1adf777FF6fBC29FFC681D4", quorum, credentials, gasProvider);
//            log.info("loaded contract address: " + proxy.getContractAddress());
//
//            // block listen
////            EthFilter filter = new EthFilter(DefaultBlockParameterName.EARLIEST, DefaultBlockParameterName.LATEST, "0x9868831d5c4154b70cc2713a9fbd1b59dda7e3bb");
////            quorum.ethLogFlowable(filter).subscribe(log -> System.out.println("transaction log: " + log.getData()));
////            proxy.modifiedEventFlowable(filter).subscribe(log -> System.out.println("transaction: " + log.newGreeting));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

}

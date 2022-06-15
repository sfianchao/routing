package idsl.crosschain.routing.config;

import idsl.crosschain.routing.model.QuorumInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.quorum.Quorum;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

@Slf4j
@Configuration
public class QuorumConfig {

    private String idslInternalIp = "http://192.168.66.74:8545";
    private String idslExternalIp = "http://140.118.9.214:9045";
    private String masterPlanIp = "http://104.118.9.226:23001";

    @Bean(name = "relayChainBuilder")
    public QuorumInfo relayChainBuilder() {

        QuorumInfo quorumInfo = new QuorumInfo();

        try {
            // connect to blockchain
            Quorum quorum = Quorum.build(new HttpService(idslInternalIp));
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            log.info("[relay] chain client version: " + clientVersion);

            // set up credentials
            Credentials credentials = Credentials.create("ba394d6ecde04efb7bce0001f130d878794d890b9da8a27eb950a4b6aa58dd76");
            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
            log.info("[relay] chain account address: " + credentials.getAddress());

            // connect to sfianchao relay chain
//            Quorum quorum = Quorum.build(new HttpService("http://192.168.47.130:22000"));
//            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
//            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
//            log.info("[relay] chain client version: " + clientVersion);

            // set up credentials
//            Credentials credentials = WalletUtils.loadCredentials("node", new File("C:/Users/hmnic/Documents/GitHub/routing/wallets-relay/wallet1"));
//            StaticGasProvider gasProvider = new StaticGasProvider(DefaultGasProvider.GAS_PRICE, DefaultGasProvider.GAS_LIMIT);
//            log.info("[relay] chain account address: " + credentials.getAddress());
//            log.info("[relay} network version: {}", quorum.netVersion().send().getNetVersion());

            quorumInfo.setQuorum(quorum);
            quorumInfo.setCredentials(credentials);
            quorumInfo.setGasProvider(gasProvider);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return quorumInfo;
    }

}

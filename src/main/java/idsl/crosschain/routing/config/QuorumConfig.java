package idsl.crosschain.routing.config;

import idsl.crosschain.routing.model.QuorumInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${quorum.chain.relay.ip}")
    private String chainIp;

    @Bean(name = "relayChainBuilder")
    public QuorumInfo relayChainBuilder() {

        QuorumInfo quorumInfo = new QuorumInfo();

        try {
            // connect to blockchain
            Quorum quorum = Quorum.build(new HttpService(chainIp));
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            log.info("[relay] chain client version: " + clientVersion);

            // set up credentials
            Credentials credentials = Credentials.create("ba394d6ecde04efb7bce0001f130d878794d890b9da8a27eb950a4b6aa58dd76");
            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
            log.info("[relay] chain account address: " + credentials.getAddress());

            quorumInfo.setQuorum(quorum);
            quorumInfo.setCredentials(credentials);
            quorumInfo.setGasProvider(gasProvider);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return quorumInfo;
    }

}

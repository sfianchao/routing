package idsl.crosschain.routing.config;

import idsl.crosschain.routing.model.QuorumInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.quorum.Quorum;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

@Slf4j
@Configuration
public class QuorumConfig {

    @Bean(name = "quorumBuilder")
    public QuorumInfo quorumBuilder () {

        QuorumInfo quorumInfo = new QuorumInfo();

        try {
            // connect to blockchain
            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9045"));
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            log.info("client version: " + clientVersion);

            // set up credentials
            Credentials credentials = Credentials.create("a7c04cf56f4b4d08a5728b94419382a7bc3dbf108e52fada2ff655479befe2f3");
            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
            log.info("account address: " + credentials.getAddress());

            quorumInfo.setQuorum(quorum);
            quorumInfo.setCredentials(credentials);
            quorumInfo.setGasProvider(gasProvider);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return quorumInfo;
    }
}

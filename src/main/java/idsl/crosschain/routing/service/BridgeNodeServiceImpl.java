package idsl.crosschain.routing.service;

import idsl.crosschain.routing.contract.Proxy;
import idsl.crosschain.routing.model.BridgeNode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.quorum.Quorum;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;

@Slf4j
@Service
public class BridgeNodeServiceImpl implements BridgeNodeService {

    @Override
    public String setBridgeNode(BridgeNode bridgeNode) {

        try {

            // connect to ganache
            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9045"));
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            log.info("client version: " + clientVersion);

            // set up credentials
            Credentials credentials = Credentials.create("a7c04cf56f4b4d08a5728b94419382a7bc3dbf108e52fada2ff655479befe2f3");
            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
            log.info("account address: " + credentials.getAddress()); // 0x67598f3f6ab21b913ee7ad7a57cc952a8b6afdf4

            // deploy contract
//            Proxy proxy = Proxy.deploy(quorum, credentials, new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L))).send();
//            log.info("deployed contract address: " + proxy.getContractAddress());

            // load contract
            Proxy proxy = Proxy.load("0xf428a680E39eB0BEf1adf777FF6fBC29FFC681D4", quorum, credentials, gasProvider);
            log.info("loaded contract address: " + proxy.getContractAddress());

            proxy.setBridgeNode(bridgeNode.id, bridgeNode.chainName, bridgeNode.ip).send();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return "null";
    }

    @Override
    public BridgeNode getBridgeNode(String chainName) {

        BridgeNode bridgeNode = new BridgeNode();

        try {

            // connect to ganache
            Quorum quorum = Quorum.build(new HttpService("http://140.118.9.214:9045"));
            Web3ClientVersion web3ClientVersion = quorum.web3ClientVersion().send();
            String clientVersion = web3ClientVersion.getWeb3ClientVersion();
            log.info("client version: " + clientVersion);

            // set up credentials
            Credentials credentials = Credentials.create("a7c04cf56f4b4d08a5728b94419382a7bc3dbf108e52fada2ff655479befe2f3");
            StaticGasProvider gasProvider = new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L));
            log.info("account address: " + credentials.getAddress()); // 0x67598f3f6ab21b913ee7ad7a57cc952a8b6afdf4

            // deploy contract
//            Proxy proxy = Proxy.deploy(quorum, credentials, new StaticGasProvider(BigInteger.valueOf(20000000000L), BigInteger.valueOf(6721975L))).send();
//            log.info("deployed contract address: " + proxy.getContractAddress());

            // load contract
            Proxy proxy = Proxy.load("0x5526d1b02FFb0B68A73249A63Dd65170dff7b99c", quorum, credentials, gasProvider);
            log.info("loaded contract address: " + proxy.getContractAddress());

            Tuple3<String, String, String> nodeInfo = proxy.getBridgeNodeWithChainName(chainName).send();
            System.out.println(nodeInfo);
            bridgeNode.setId(nodeInfo.component1());
            bridgeNode.setChainName(nodeInfo.component2());
            bridgeNode.setIp(nodeInfo.component3());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bridgeNode;
    }
}

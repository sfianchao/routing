package idsl.crosschain.routing.service;

import idsl.crosschain.routing.contract.Proxy;
import idsl.crosschain.routing.model.BridgeNode;
import idsl.crosschain.routing.model.QuorumInfo;
import idsl.crosschain.routing.model.RoutingInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.ChainId;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;

import java.math.BigInteger;

@Slf4j
@Service
public class BridgeNodeServiceImpl implements BridgeNodeService {

    @Value("${contract.address.relay}")
    private String PROXY_CONTRACT_ADDRESS;

    @Autowired
    private ApplicationContext applicationContext;

    public BridgeNodeServiceImpl() {
    }

    @Override
    public String setBridgeNode(BridgeNode bridgeNode) {

        RoutingInfo routingInfo = new RoutingInfo();

        try {
            QuorumInfo quorumInfo = (QuorumInfo) applicationContext.getBean("relayChainBuilder");

            // load contract
            Proxy proxy = Proxy.load(PROXY_CONTRACT_ADDRESS,
                    quorumInfo.getQuorum(), quorumInfo.getCredentials(), quorumInfo.getGasProvider());
            log.info("loaded contract address: " + proxy.getContractAddress());

            proxy.setBridgeNode(routingInfo.getId(), routingInfo.getChainName(), routingInfo.getIp()).send();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "set bridge node success !";
    }

    @Override
    public RoutingInfo getBridgeNode(String chainName) {

        RoutingInfo routingInfo = new RoutingInfo();

        try {
            QuorumInfo quorumInfo = (QuorumInfo) applicationContext.getBean("relayChainBuilder");

            // load contract
            Proxy proxy = Proxy.load(PROXY_CONTRACT_ADDRESS,
                    quorumInfo.getQuorum(), quorumInfo.getCredentials(), quorumInfo.getGasProvider());
            log.info("loaded contract address: " + proxy.getContractAddress());

            Tuple3<String, String, String> nodeInfo = proxy.getBridgeNodeWithChainName(chainName).send();
            log.debug("bridge node info: {}, {}, {}", nodeInfo.component1(), nodeInfo.component2(), nodeInfo.component3());
            routingInfo.setId(nodeInfo.component1());
            routingInfo.setChainName(nodeInfo.component2());
            routingInfo.setIp(nodeInfo.component3());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return routingInfo;
    }
}

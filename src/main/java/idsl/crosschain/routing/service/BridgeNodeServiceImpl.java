package idsl.crosschain.routing.service;

import idsl.crosschain.routing.contract.Proxy;
import idsl.crosschain.routing.model.BridgeNode;
import idsl.crosschain.routing.model.QuorumInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.web3j.tuples.generated.Tuple3;

@Slf4j
@Service
public class BridgeNodeServiceImpl implements BridgeNodeService {

    private final String PROXY_CONTRACT_ADDRESS = "0x8eb932851a340ede1158c960f5a2a04fd3c2babc";

    @Autowired
    private ApplicationContext applicationContext;

    public BridgeNodeServiceImpl() {
    }

    @Override
    public String setBridgeNode(BridgeNode bridgeNode) {

        try {
            QuorumInfo quorumInfo = (QuorumInfo) applicationContext.getBean("quorumBuilder");

            // load contract
            Proxy proxy = Proxy.load(PROXY_CONTRACT_ADDRESS,
                    quorumInfo.getQuorum(), quorumInfo.getCredentials(), quorumInfo.getGasProvider());
            log.info("loaded contract address: " + proxy.getContractAddress());

            proxy.setBridgeNode(bridgeNode.id, bridgeNode.chainName, bridgeNode.ip).send();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "set bridge node success !";
    }

    @Override
    public BridgeNode getBridgeNode(String chainName) {

        BridgeNode bridgeNode = new BridgeNode();

        try {
            QuorumInfo quorumInfo = (QuorumInfo) applicationContext.getBean("quorumBuilder");

            // load contract
            Proxy proxy = Proxy.load(PROXY_CONTRACT_ADDRESS,
                    quorumInfo.getQuorum(), quorumInfo.getCredentials(), quorumInfo.getGasProvider());
            log.info("loaded contract address: " + proxy.getContractAddress());

            Tuple3<String, String, String> nodeInfo = proxy.getBridgeNodeWithChainName(chainName).send();
            log.debug("bridge node info: {}, {}, {}", nodeInfo.component1(), nodeInfo.component2(), nodeInfo.component3());
            bridgeNode.setId(nodeInfo.component1());
            bridgeNode.setChainName(nodeInfo.component2());
            bridgeNode.setIp(nodeInfo.component3());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bridgeNode;
    }
}

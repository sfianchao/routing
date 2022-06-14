package idsl.crosschain.routing.service;

import com.alibaba.fastjson2.JSONObject;
import idsl.crosschain.routing.util.ProxyContractUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeployServiceImpl implements DeployService {

    @Autowired
    private ProxyContractUtil proxyContractUtil;


    @Override
    public JSONObject deployContract(String chainName) {
        String chain = chainBuilderSelector(chainName);
        return proxyContractUtil.deploy(chain);
    }

    private String chainBuilderSelector(String chainName) {
        if (chainName.equalsIgnoreCase("src")) {
            return "sourceChainBuilder";
        } else if (chainName.equalsIgnoreCase("dest")) {
            return "destinationChainBuilder";
        } else if (chainName.equalsIgnoreCase("relay")) {
            return "relayChainBuilder";
        } else {
            return "relayChainBuilder";
        }
    }
}

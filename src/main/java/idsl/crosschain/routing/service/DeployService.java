package idsl.crosschain.routing.service;

import com.alibaba.fastjson2.JSONObject;

public interface DeployService {

    JSONObject deployContract(String chainName);
}

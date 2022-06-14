package idsl.crosschain.routing.util;

import com.alibaba.fastjson2.JSONObject;
import idsl.crosschain.routing.contract.Proxy;
import idsl.crosschain.routing.model.QuorumInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;
import org.web3j.tx.gas.StaticGasProvider;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@Data
@EqualsAndHashCode(callSuper = false)
@Component
public class ProxyContractUtil extends ContractUtil {

    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    public ProxyContractUtil() {

    }

    @Override
    public JSONObject deploy(String chainBuilder) {

        String contractAddress = null;
        JSONObject jsonObject = new JSONObject();

        QuorumInfo quorumInfo = (QuorumInfo) applicationContext.getBean(chainBuilder);
        quorumInfo.setGasProvider(new StaticGasProvider(BigInteger.ZERO, DefaultGasProvider.GAS_LIMIT));

        // deploy contract
        try {
            TransactionManager transactionManager = new RawTransactionManager(
                    quorumInfo.getQuorum(), quorumInfo.getCredentials(), chainId);
            Proxy proxy = Proxy.deploy(quorumInfo.getQuorum(), transactionManager, quorumInfo.getGasProvider()).send();
            contractAddress = proxy.getContractAddress();
            log.info("[{}] deployed contract address: {}", chainBuilder, contractAddress);
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e.getMessage());
        }

        jsonObject.put("msg", String.format("[%s] deployed contract address: %s", LocalDateTime.now().format(dateTimeFormatter), contractAddress));

        return jsonObject;
    }

    @Override
    public JSONObject load(String chainBuilder) {
        return null;
    }

}

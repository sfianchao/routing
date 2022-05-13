package idsl.crosschain.routing.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 1.4.1.
 */
@SuppressWarnings("rawtypes")
public class Proxy extends Contract {
    public static final String BINARY = "608060405234801561001057600080fd5b506109b6806100206000396000f3fe608060405234801561001057600080fd5b50600436106100365760003560e01c80630d0bc8591461003b5780639d20d66314610057575b600080fd5b610055600480360381019061005091906105bc565b610089565b005b610071600480360381019061006c9190610573565b6101b1565b6040516100809392919061077a565b60405180910390f35b600060028460405161009b919061074c565b90815260200160405180910390209050838160000190805190602001906100c39291906103d3565b50828160010190805190602001906100dc9291906103d3565b50818160020190805190602001906100f59291906103d3565b5080600285604051610107919061074c565b908152602001604051809103902060008201816000019080546101299061089a565b610134929190610459565b5060018201816001019080546101499061089a565b610154929190610459565b5060028201816002019080546101699061089a565b610174929190610459565b5090505083600184604051610189919061074c565b908152602001604051809103902090805190602001906101aa9291906103d3565b5050505050565b6060806060600060026001866040516101ca919061074c565b90815260200160405180910390206040516101e59190610763565b908152602001604051809103902060405180606001604052908160008201805461020e9061089a565b80601f016020809104026020016040519081016040528092919081815260200182805461023a9061089a565b80156102875780601f1061025c57610100808354040283529160200191610287565b820191906000526020600020905b81548152906001019060200180831161026a57829003601f168201915b505050505081526020016001820180546102a09061089a565b80601f01602080910402602001604051908101604052809291908181526020018280546102cc9061089a565b80156103195780601f106102ee57610100808354040283529160200191610319565b820191906000526020600020905b8154815290600101906020018083116102fc57829003601f168201915b505050505081526020016002820180546103329061089a565b80601f016020809104026020016040519081016040528092919081815260200182805461035e9061089a565b80156103ab5780601f10610380576101008083540402835291602001916103ab565b820191906000526020600020905b81548152906001019060200180831161038e57829003601f168201915b5050505050815250509050806000015181602001518260400151935093509350509193909250565b8280546103df9061089a565b90600052602060002090601f0160209004810192826104015760008555610448565b82601f1061041a57805160ff1916838001178555610448565b82800160010185558215610448579182015b8281111561044757825182559160200191906001019061042c565b5b50905061045591906104e6565b5090565b8280546104659061089a565b90600052602060002090601f01602090048101928261048757600085556104d5565b82601f1061049857805485556104d5565b828001600101855582156104d557600052602060002091601f016020900482015b828111156104d45782548255916001019190600101906104b9565b5b5090506104e291906104e6565b5090565b5b808211156104ff5760008160009055506001016104e7565b5090565b6000610516610511846107eb565b6107c6565b90508281526020810184848401111561053257610531610960565b5b61053d848285610858565b509392505050565b600082601f83011261055a5761055961095b565b5b813561056a848260208601610503565b91505092915050565b6000602082840312156105895761058861096a565b5b600082013567ffffffffffffffff8111156105a7576105a6610965565b5b6105b384828501610545565b91505092915050565b6000806000606084860312156105d5576105d461096a565b5b600084013567ffffffffffffffff8111156105f3576105f2610965565b5b6105ff86828701610545565b935050602084013567ffffffffffffffff8111156106205761061f610965565b5b61062c86828701610545565b925050604084013567ffffffffffffffff81111561064d5761064c610965565b5b61065986828701610545565b9150509250925092565b600061066e82610831565b610678818561083c565b9350610688818560208601610867565b6106918161096f565b840191505092915050565b60006106a782610831565b6106b1818561084d565b93506106c1818560208601610867565b80840191505092915050565b600081546106da8161089a565b6106e4818661084d565b945060018216600081146106ff576001811461071057610743565b60ff19831686528186019350610743565b6107198561081c565b60005b8381101561073b5781548189015260018201915060208101905061071c565b838801955050505b50505092915050565b6000610758828461069c565b915081905092915050565b600061076f82846106cd565b915081905092915050565b600060608201905081810360008301526107948186610663565b905081810360208301526107a88185610663565b905081810360408301526107bc8184610663565b9050949350505050565b60006107d06107e1565b90506107dc82826108cc565b919050565b6000604051905090565b600067ffffffffffffffff8211156108065761080561092c565b5b61080f8261096f565b9050602081019050919050565b60008190508160005260206000209050919050565b600081519050919050565b600082825260208201905092915050565b600081905092915050565b82818337600083830152505050565b60005b8381101561088557808201518184015260208101905061086a565b83811115610894576000848401525b50505050565b600060028204905060018216806108b257607f821691505b602082108114156108c6576108c56108fd565b5b50919050565b6108d58261096f565b810181811067ffffffffffffffff821117156108f4576108f361092c565b5b80604052505050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b600080fd5b600080fd5b600080fd5b600080fd5b6000601f19601f830116905091905056fea26469706673582212205abbb69f0f46ab50358c2a25e2bd943863c53de00a8d81cd0dffd747ea1ea29064736f6c63430008070033";

    public static final String FUNC_GETBRIDGENODEWITHCHAINNAME = "getBridgeNodeWithChainName";

    public static final String FUNC_SETBRIDGENODE = "setBridgeNode";

    @Deprecated
    protected Proxy(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Proxy(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Proxy(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Proxy(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<Tuple3<String, String, String>> getBridgeNodeWithChainName(String _chainName) {
        final Function function = new Function(FUNC_GETBRIDGENODEWITHCHAINNAME, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_chainName)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteFunctionCall<Tuple3<String, String, String>>(function,
                new Callable<Tuple3<String, String, String>>() {
                    @Override
                    public Tuple3<String, String, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, String, String>(
                                (String) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (String) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> setBridgeNode(String _id, String _chainName, String _ip) {
        final Function function = new Function(
                FUNC_SETBRIDGENODE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_id), 
                new org.web3j.abi.datatypes.Utf8String(_chainName), 
                new org.web3j.abi.datatypes.Utf8String(_ip)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static Proxy load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Proxy(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Proxy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Proxy(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Proxy load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Proxy(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Proxy load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Proxy(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Proxy> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Proxy.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Proxy> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Proxy.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Proxy> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Proxy.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Proxy> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Proxy.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}

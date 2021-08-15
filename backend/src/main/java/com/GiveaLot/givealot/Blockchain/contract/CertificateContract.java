
package com.GiveaLot.givealot.Blockchain.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

import org.jetbrains.annotations.Contract;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.RemoteFunctionCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tuples.generated.Tuple3;
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
public class CertificateContract extends Contract {
    public static final String BINARY = "6080604052600060015534801561001557600080fd5b50600080546001600160a01b03191633179055610757806100376000396000f3fe608060405234801561001057600080fd5b50600436106100575760003560e01c8063263b6ffd1461005c578063663b3e2214610087578063ad218a571461009a578063dc2ed564146100af578063ff96cad2146100c2575b600080fd5b61006f61006a366004610600565b6100e3565b60405161007e93929190610622565b60405180910390f35b61006f610095366004610590565b6101fb565b6100ad6100a83660046105a9565b6102a6565b005b6100ad6100bd366004610542565b61032b565b6100d56100d0366004610590565b6103a7565b60405190815260200161007e565b6000805460609082906001600160a01b0316331461010057600080fd5b6000858152600260205260409020548414156101cd5760008581526002602081905260409091208054918101546001909101805490919082906101429061069f565b80601f016020809104026020016040519081016040528092919081815260200182805461016e9061069f565b80156101bb5780601f10610190576101008083540402835291602001916101bb565b820191906000526020600020905b81548152906001019060200180831161019e57829003601f168201915b505050505091509250925092506101f4565b50506040805180820190915260088152671b9bdd119bdd5b9960c21b602082015260009150815b9250925092565b6002602052600090815260409020805460018201805491929161021d9061069f565b80601f01602080910402602001604051908101604052809291908181526020018280546102499061069f565b80156102965780601f1061026b57610100808354040283529160200191610296565b820191906000526020600020905b81548152906001019060200180831161027957829003601f168201915b5050505050908060020154905083565b6000546001600160a01b031633146102bd57600080fd5b60008481526002602052604090205482141561032557604080516060810182528381526020808201868152828401859052600088815260028352939093208251815592518051929392610316926001850192019061041c565b50604082015181600201559050505b50505050565b6000546001600160a01b0316331461034257600080fd5b61034a610403565b60408051606081018252838152602080820186815282840185905260018054600090815260028452949094208351815590518051939491936103949392850192919091019061041c565b5060408201518160020155905050505050565b600080546001600160a01b031633146103bf57600080fd5b60005b60015481116103f9576000818152600260205260409020548314156103e75792915050565b806103f1816106da565b9150506103c2565b5061270f92915050565b60018060008282546104159190610687565b9091555050565b8280546104289061069f565b90600052602060002090601f01602090048101928261044a5760008555610490565b82601f1061046357805160ff1916838001178555610490565b82800160010185558215610490579182015b82811115610490578251825591602001919060010190610475565b5061049c9291506104a0565b5090565b5b8082111561049c57600081556001016104a1565b600082601f8301126104c657600080fd5b813567ffffffffffffffff808211156104e1576104e161070b565b604051601f8301601f19908116603f011681019082821181831017156105095761050961070b565b8160405283815286602085880101111561052257600080fd5b836020870160208301376000602085830101528094505050505092915050565b60008060006060848603121561055757600080fd5b833567ffffffffffffffff81111561056e57600080fd5b61057a868287016104b5565b9660208601359650604090950135949350505050565b6000602082840312156105a257600080fd5b5035919050565b600080600080608085870312156105bf57600080fd5b84359350602085013567ffffffffffffffff8111156105dd57600080fd5b6105e9878288016104b5565b949794965050505060408301359260600135919050565b6000806040838503121561061357600080fd5b50508035926020909101359150565b83815260006020606081840152845180606085015260005b818110156106565786810183015185820160800152820161063a565b81811115610668576000608083870101525b5060408401949094525050601f91909101601f19160160800192915050565b6000821982111561069a5761069a6106f5565b500190565b600181811c908216806106b357607f821691505b602082108114156106d457634e487b7160e01b600052602260045260246000fd5b50919050565b60006000198214156106ee576106ee6106f5565b5060010190565b634e487b7160e01b600052601160045260246000fd5b634e487b7160e01b600052604160045260246000fdfea2646970667358221220c5ad472e5dcda37d3029d75f7ba8267f3f0a1633c39195bb207bbc8d8275374a64736f6c63430008070033";

    public static final String FUNC_ADDCERTIFICATE = "addCertificate";

    public static final String FUNC_CERTIFICATES = "certificates";

    public static final String FUNC_FINDCERTIFICATEINDEX = "findCertificateIndex";

    public static final String FUNC_RETRIEVECERTIFICATE = "retrieveCertificate";

    public static final String FUNC_UPGRADECERTIFICATE = "upgradeCertificate";

    @Deprecated
    protected CertificateContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected CertificateContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected CertificateContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected CertificateContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteFunctionCall<TransactionReceipt> addCertificate(String _certificateHash, BigInteger _organisationId, BigInteger _level) {
        final Function function = new Function(
                FUNC_ADDCERTIFICATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_certificateHash), 
                new org.web3j.abi.datatypes.generated.Uint256(_organisationId), 
                new org.web3j.abi.datatypes.generated.Uint256(_level)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteFunctionCall<Tuple3<BigInteger, String, BigInteger>> certificates(BigInteger param0) {
        final Function function = new Function(FUNC_CERTIFICATES, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(param0)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, String, BigInteger>>(function,
                new Callable<Tuple3<BigInteger, String, BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<BigInteger> findCertificateIndex(BigInteger _organisationId) {
        final Function function = new Function(FUNC_FINDCERTIFICATEINDEX, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_organisationId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteFunctionCall<Tuple3<BigInteger, String, BigInteger>> retrieveCertificate(BigInteger _index, BigInteger _organisationId) {
        final Function function = new Function(FUNC_RETRIEVECERTIFICATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(_index), 
                new org.web3j.abi.datatypes.generated.Uint256(_organisationId)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteFunctionCall<Tuple3<BigInteger, String, BigInteger>>(function,
                new Callable<Tuple3<BigInteger, String, BigInteger>>() {
                    @Override
                    public Tuple3<BigInteger, String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<BigInteger, String, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (String) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteFunctionCall<TransactionReceipt> upgradeCertificate(BigInteger index, String _certificateHash, BigInteger _organisationId, BigInteger _level) {
        final Function function = new Function(
                FUNC_UPGRADECERTIFICATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.generated.Uint256(index), 
                new org.web3j.abi.datatypes.Utf8String(_certificateHash), 
                new org.web3j.abi.datatypes.generated.Uint256(_organisationId), 
                new org.web3j.abi.datatypes.generated.Uint256(_level)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    @Deprecated
    public static CertificateContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new CertificateContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static CertificateContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new CertificateContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static CertificateContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new CertificateContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static CertificateContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new CertificateContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<CertificateContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CertificateContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<CertificateContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(CertificateContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CertificateContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CertificateContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<CertificateContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(CertificateContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}


package com.GiveaLot.givealot.Blockchain.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Bool;
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
public class CertificateContract extends Contract {
    public static final String BINARY = "6080604052600060015534801561001557600080fd5b50600080546001600160a01b0319163317905561092d806100376000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c8063263b6ffd146100675780634e202a6414610092578063663b3e22146100b5578063ad218a57146100c8578063dc2ed564146100dd578063ff96cad2146100f0575b600080fd5b61007a610075366004610715565b610111565b604051610089939291906107ef565b60405180910390f35b6100a56100a036600461061a565b610229565b6040519015158152602001610089565b61007a6100c33660046106a5565b6102d3565b6100db6100d63660046106be565b61037e565b005b6100db6100eb366004610657565b610403565b6101036100fe3660046106a5565b61047f565b604051908152602001610089565b6000805460609082906001600160a01b0316331461012e57600080fd5b6000858152600260205260409020548414156101fb57600085815260026020819052604090912080549181015460019091018054909190829061017090610875565b80601f016020809104026020016040519081016040528092919081815260200182805461019c90610875565b80156101e95780601f106101be576101008083540402835291602001916101e9565b820191906000526020600020905b8154815290600101906020018083116101cc57829003601f168201915b50505050509150925092509250610222565b50506040805180820190915260088152671b9bdd119bdd5b9960c21b602082015260009150815b9250925092565b600080546001600160a01b0316331461024157600080fd5b60005b60015481116102ca578260405160200161025e9190610737565b60408051601f198184030181528282528051602091820120600085815260028352929092209192610293926001019101610753565b6040516020818303038152906040528051906020012014156102b85750600192915050565b806102c2816108b0565b915050610244565b50600092915050565b600260205260009081526040902080546001820180549192916102f590610875565b80601f016020809104026020016040519081016040528092919081815260200182805461032190610875565b801561036e5780601f106103435761010080835404028352916020019161036e565b820191906000526020600020905b81548152906001019060200180831161035157829003601f168201915b5050505050908060020154905083565b6000546001600160a01b0316331461039557600080fd5b6000848152600260205260409020548214156103fd576040805160608101825283815260208082018681528284018590526000888152600283529390932082518155925180519293926103ee92600185019201906104f4565b50604082015181600201559050505b50505050565b6000546001600160a01b0316331461041a57600080fd5b6104226104db565b604080516060810182528381526020808201868152828401859052600180546000908152600284529490942083518155905180519394919361046c939285019291909101906104f4565b5060408201518160020155905050505050565b600080546001600160a01b0316331461049757600080fd5b60005b60015481116104d1576000818152600260205260409020548314156104bf5792915050565b806104c9816108b0565b91505061049a565b5061270f92915050565b60018060008282546104ed9190610831565b9091555050565b82805461050090610875565b90600052602060002090601f0160209004810192826105225760008555610568565b82601f1061053b57805160ff1916838001178555610568565b82800160010185558215610568579182015b8281111561056857825182559160200191906001019061054d565b50610574929150610578565b5090565b5b808211156105745760008155600101610579565b600082601f83011261059e57600080fd5b813567ffffffffffffffff808211156105b9576105b96108e1565b604051601f8301601f19908116603f011681019082821181831017156105e1576105e16108e1565b816040528381528660208588010111156105fa57600080fd5b836020870160208301376000602085830101528094505050505092915050565b60006020828403121561062c57600080fd5b813567ffffffffffffffff81111561064357600080fd5b61064f8482850161058d565b949350505050565b60008060006060848603121561066c57600080fd5b833567ffffffffffffffff81111561068357600080fd5b61068f8682870161058d565b9660208601359650604090950135949350505050565b6000602082840312156106b757600080fd5b5035919050565b600080600080608085870312156106d457600080fd5b84359350602085013567ffffffffffffffff8111156106f257600080fd5b6106fe8782880161058d565b949794965050505060408301359260600135919050565b6000806040838503121561072857600080fd5b50508035926020909101359150565b60008251610749818460208701610849565b9190910192915050565b600080835481600182811c91508083168061076f57607f831692505b602080841082141561078f57634e487b7160e01b86526022600452602486fd5b8180156107a357600181146107b4576107e1565b60ff198616895284890196506107e1565b60008a81526020902060005b868110156107d95781548b8201529085019083016107c0565b505084890196505b509498975050505050505050565b8381526060602082015260008351806060840152610814816080850160208801610849565b604083019390935250601f91909101601f19160160800192915050565b60008219821115610844576108446108cb565b500190565b60005b8381101561086457818101518382015260200161084c565b838111156103fd5750506000910152565b600181811c9082168061088957607f821691505b602082108114156108aa57634e487b7160e01b600052602260045260246000fd5b50919050565b60006000198214156108c4576108c46108cb565b5060010190565b634e487b7160e01b600052601160045260246000fd5b634e487b7160e01b600052604160045260246000fdfea2646970667358221220c7748e8d523345c11a0cbaee66e1c224be8e5d9f9240048b76ef5c2e2544d37764736f6c63430008070033";

    public static final String FUNC_ADDCERTIFICATE = "addCertificate";

    public static final String FUNC_CERTIFICATES = "certificates";

    public static final String FUNC_COMPARECERTIFICATE = "compareCertificate";

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

    public RemoteFunctionCall<Boolean> compareCertificate(String _certificateHash) {
        final Function function = new Function(FUNC_COMPARECERTIFICATE, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_certificateHash)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
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
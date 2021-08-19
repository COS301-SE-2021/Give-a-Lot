package com.GiveaLot.givealot.Blockchain.service;

import com.GiveaLot.givealot.Blockchain.Repository.BlockChainRepository;
import com.GiveaLot.givealot.Blockchain.contract.CertificateContract;
import com.GiveaLot.givealot.Certificate.dataclass.ContractConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tuples.generated.Tuple3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class BlockchainServiceImpl implements BlockchainService {


    public final BlockChainRepository blockChainRepository;

    @Autowired
    BlockchainServiceImpl(  BlockChainRepository blockChainRepository)
    {
        this.blockChainRepository = blockChainRepository;
    }

    @Override
    public String[] uploadCertificate(long orgId, File certificate) throws Exception {
        CertificateContract certificateContract = loadSmartContract();
        String hashedCertificate = hashCertificate(certificate);
        BigInteger _orgId = BigInteger.valueOf(orgId);
        BigInteger _level = BigInteger.valueOf(0);
        try {
            TransactionReceipt latestTransaction = certificateContract
                    .addCertificate(hashedCertificate, _orgId, _level)
                    .send();
            String[] result = new String[2];
            result[0] = hashedCertificate;
            result[1] = latestTransaction.getTransactionHash();

            return result;
        }catch (Exception e){
            throw new Exception("Exception: Blockchain transaction failed: " + e);
        }    }

    @Override
    public String[] upgradeCertificate(long index, long orgId, File certificate, long level) throws Exception {
        CertificateContract certificateContract = loadSmartContract();
        String hashedCertificate = hashCertificate(certificate);
        BigInteger _index = BigInteger.valueOf(index);
        BigInteger _orgId = BigInteger.valueOf(orgId);
        BigInteger _level = BigInteger.valueOf(level);
        try {
            TransactionReceipt latestTransaction = certificateContract
                    .upgradeCertificate(_index, hashedCertificate, _orgId, _level)
                    .send();
            String[] result = new String[2];
            result[0] = hashedCertificate;
            result[1] = latestTransaction.getTransactionHash();
            return result;
        }catch (Exception e){
            throw new Exception("Exception: Blockchain transaction failed");
        }    }

    @Override
    public long findCertificateIndex(long orgId) throws Exception {
        BigInteger _orgId = BigInteger.valueOf(orgId);
        CertificateContract certificateContract = loadSmartContract();
        try {
            for (int j = 0; j < (int) orgId; j++) {
                if (certificateContract.certificates(BigInteger.valueOf(j)).send().component1().equals(_orgId)) {
                    return j;
                }
            }
        }catch (Exception e) {
            throw new Exception("Exception: Blockchain transaction failed: " + e);
        }
        return 9999;
//        try {
//            return certificateContract.findCertificateIndex(_orgId).send().longValue();
//        }catch (Exception e){
//            throw new Exception("Exception: Blockchain transaction failed: " + e);
//        }
    }

    @Override
    public String retrieveCertificateHash(long index, long orgId) throws Exception {
        BigInteger _index = BigInteger.valueOf(index);
        BigInteger _orgId = BigInteger.valueOf(orgId);
        CertificateContract certificateContract = loadSmartContract();
        try {
            Tuple3<BigInteger, String, BigInteger> test = certificateContract.retrieveCertificate(_index, _orgId).send();
            return test.component2();
        }catch (Exception e){
            throw new Exception("Exception: Blockchain transaction failed");
        }    }

    @Override
    public boolean compareCertificateHash(long index, long orgId, File certificate) throws Exception {
        String blockchainCertificateHash = retrieveCertificateHash(index, orgId);
        String uploadCertificateHash = hashCertificate(certificate);
        return blockchainCertificateHash.equals(uploadCertificateHash);
    }

    @Override
    public String hashCertificate(File certificate) throws IOException, NoSuchAlgorithmException {
        MessageDigest shaDigest = MessageDigest.getInstance("SHA-256");
        FileInputStream inputStream = new FileInputStream(certificate);
        byte[] byteArray = new byte[1024];
        int bytes = 0;
        while ((bytes = inputStream.read(byteArray)) != -1){
            shaDigest.update(byteArray, 0, bytes);
        }
        inputStream.close();
        byte[] hashBytes = shaDigest.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < hashBytes.length; i++) {
            stringBuilder.append(Integer.toString((hashBytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return stringBuilder.toString();    }

    @Override
    public Web3j buildWeb3jClient() {
        return Web3j.build(new HttpService("HTTP://127.0.0.1:7545"));
    }

    @Override
    public String deploySmartContract() throws Exception {
        ContractConfig config = new ContractConfig();
        Web3j client = buildWeb3jClient();
        try {
            return CertificateContract.deploy(client, getCredentialsFromPrivateKey(), config.getGasPrice(), config.getGasLimit())
                    .send()
                    .getContractAddress();
        }catch (Exception e){
            throw new Exception("Exception: Blockchain transaction failed");
        }    }

    @Override
    public CertificateContract loadSmartContract() {
        ContractConfig config = new ContractConfig();
        Web3j client = buildWeb3jClient();
        return CertificateContract.load(config.getCONTRACT_ADDRESS(), client, getCredentialsFromPrivateKey(), config.getGasPrice(), config.getGasLimit());    }

    @Override
    public Credentials getCredentialsFromPrivateKey() {
        ContractConfig config = new ContractConfig();
        return Credentials.create(config.getPRIVATE_KEY());    }

}

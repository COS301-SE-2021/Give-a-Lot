package com.GiveaLot.givealot.Blockchain.service;
import com.GiveaLot.givealot.Blockchain.Repository.*;
import com.GiveaLot.givealot.Certificate.model.SmartContractConfig;
import org.springframework.beans.factory.annotation.Autowired;
import com.GiveaLot.givealot.Blockchain.contract.CertificateContract;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.util.function.Tuple3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class BlockchainServiceImpl implements BlockchainService {


    public final BlockchainDAOInterface blockchainDAOInterface;

    @Autowired
    BlockchainServiceImpl(  BlockchainDAOInterface blockchainDAOInterface)
    {
        this.blockchainDAOInterface = blockchainDAOInterface;
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
            throw new Exception("Exception: Blockchain transaction failed");
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
            return certificateContract.findCertificateIndex(_orgId).send().longValue();
        }catch (Exception e){
            throw new Exception("Exception: Blockchain transaction failed");
        }    }

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
        return blockchainCertificateHash.equals(uploadCertificateHash);    }

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
        SmartContractConfig config = new SmartContractConfig();
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
        SmartContractConfig config = new SmartContractConfig();
        Web3j client = buildWeb3jClient();
        return CertificateContract.load(config.getCONTRACT_ADDRESS(), client, getCredentialsFromPrivateKey(), config.getGasPrice(), config.getGasLimit());    }

    @Override
    public Credentials getCredentialsFromPrivateKey() {
        SmartContractConfig config = new SmartContractConfig();
        return Credentials.create(config.getPRIVATE_KEY());    }
}

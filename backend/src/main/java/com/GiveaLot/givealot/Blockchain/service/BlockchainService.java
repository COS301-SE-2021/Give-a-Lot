
package com.GiveaLot.givealot.Blockchain.service;

import com.GiveaLot.givealot.Blockchain.contract.CertificateContract;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Service
public interface BlockchainService {


    public String[] uploadCertificate(long orgId, File certificate) throws Exception;

    public String[] upgradeCertificate(long index, long orgId, File certificate, long level) throws Exception;

    public long findCertificateIndex(long orgId) throws Exception;

    public String retrieveCertificateHash(long index, long orgId) throws Exception;

    public boolean compareCertificateHash(long index, long orgId, File certificate) throws Exception;

    public String hashCertificate(File certificate) throws IOException, NoSuchAlgorithmException;

    public Web3j buildWeb3jClient();

    public String deploySmartContract() throws Exception;

    public CertificateContract loadSmartContract();

    public Credentials getCredentialsFromPrivateKey();

}


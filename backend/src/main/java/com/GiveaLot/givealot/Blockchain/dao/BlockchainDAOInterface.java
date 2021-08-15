
package com.GiveaLot.givealot.Blockchain.dao;

import com.GiveaLot.givealot.Blockchain.contract.CertificateContract;
import com.GiveaLot.givealot.Organisation.model.Organisation;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public interface BlockchainDAOInterface {

    public String[] uploadCertificate(long orgId, File certificate) throws Exception;

    public String[] upgradeCertificate(long index, long orgId, File certificate, long level) throws Exception;

    public long findCertificateIndex(long orgId) throws Exception;

    public String retrieveCertificateHash(long index, long orgId) throws Exception;

    //public boolean compareCertificateHash(long index, long orgId, File certificate) throws Exception;

    public boolean compareCertificateHash(File certificate) throws Exception;

    public String hashCertificate(File certificate) throws IOException, NoSuchAlgorithmException;

    public Web3j buildWeb3jClient();

    public String deploySmartContract() throws Exception;

    public CertificateContract loadSmartContract();

    public Credentials getCredentialsFromPrivateKey();

    public String[] upgradeBlockchainCertificate(long index, long orgId, File certificate, long level) throws Exception;

}


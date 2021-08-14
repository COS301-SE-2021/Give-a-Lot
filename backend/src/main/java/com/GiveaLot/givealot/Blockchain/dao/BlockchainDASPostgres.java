package com.GiveaLot.givealot.Blockchain.dao;

import com.GiveaLot.givealot.Blockchain.contract.CertificateContract;
import org.springframework.stereotype.Repository;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;

import java.io.File;


@Repository("BlockchainPostgres")
public class BlockchainDASPostgres implements BlockchainDAOInterface{
    @Override
    public String[] uploadCertificate(long orgId, File certificate) {
        return null;
    }

    @Override
    public String[] upgradeCertificate(long index, long orgId, File certificate, long level) {
        return null;
    }

    @Override
    public long findCertificateIndex(long orgId) {
        return 0;
    }

    @Override
    public String retrieveCertificateHash(long index, long orgId) {
        return null;
    }

    @Override
    public boolean compareCertificateHash(long index, long orgId, File certificate) throws Exception {
        return false;
    }

    @Override
    public String hashCertificate(File certificate) {
        return null;
    }

    @Override
    public Web3j buildWeb3jClient() {
        return null;
    }

    @Override
    public String deploySmartContract() {
        return null;
    }

    @Override
    public CertificateContract loadSmartContract() {
        return null;
    }

    @Override
    public Credentials getCredentialsFromPrivateKey() {
        return null;
    }
}

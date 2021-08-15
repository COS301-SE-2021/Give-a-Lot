/*
package com.GiveaLot.givealot.Blockchain.service;

import com.GiveaLot.givealot.Blockchain.contract.CertificateContract;
import com.GiveaLot.givealot.Blockchain.dao.BlockchainDAOInterface;
import com.GiveaLot.givealot.Certificate.dao.CertificateDAOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;

import java.io.File;

@Service
public class BlockchainService {

    public final BlockchainDAOInterface blockchainDAOInterface;

    @Autowired
    public BlockchainService(@Qualifier("BlockchainTemp") BlockchainDAOInterface blockchainDAOInterface){
        this.blockchainDAOInterface = blockchainDAOInterface;
    }

    public String[] uploadCertificate(long orgId, File certificate) throws Exception{
        return blockchainDAOInterface.uploadCertificate(orgId, certificate);
    }

    public String[] upgradeCertificate(long index, long orgId, File certificate, long level) throws Exception{
        return blockchainDAOInterface.upgradeCertificate(index,orgId,certificate,level);
    }

    public long findCertificateIndex(long orgId) throws Exception{
        return blockchainDAOInterface.findCertificateIndex(orgId);
    }

    public String retrieveCertificateHash(long index, long orgId) throws Exception{
        return blockchainDAOInterface.retrieveCertificateHash(index,orgId);
    }

    public boolean compareCertificateHash(long index, long orgId, File certificate) throws Exception {
        return blockchainDAOInterface.compareCertificateHash(index,orgId,certificate);
    }
}
*/

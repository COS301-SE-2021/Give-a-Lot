
package com.GiveaLot.givealot.Blockchain.Repository;

import com.GiveaLot.givealot.Blockchain.contract.*;
import com.GiveaLot.givealot.Blockchain.dataclass.Blockchain;
import com.GiveaLot.givealot.Organisation.dataclass.OrganisationRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Repository
public interface BlockChainRepository extends JpaRepository{

    /** (SELECT * FROM Blockchain WHERE orgId = ?) **/
    @Query("select i FROM Blockchain i  WHERE i.orgId = ?1")
    Blockchain selectBlockchainOrgId(long orgId);

    /** (SELECT * FROM Blockchain WHERE certificateHash = ?) **/
    @Query("select i FROM Blockchain i  WHERE i.certificateHash = ?1")
    Blockchain selectBlockchainCertificateHash(String certificateHash);

    /** (UPDATE Blockchain SET index = ?, level = ?, transactionHash = ?, certificateHash = ? WHERE orgId = ?) **/
    @Modifying
    @Transactional
    @Query("UPDATE Blockchain i SET i.index = ?1, i.level = ?2, i.transactionHash = ?3, i.certificateHash = ?4 WHERE i.orgId = ?5")
    Boolean UpdateBlockchain(long index,long level,String transactionHash,String certificateHash,long orgId);


    @Query("SELECT i FROM Blockchain i WHERE i.certificateHash=?1")
    int getOrgIdWithCertificate(String certificateHash);


    /** (INSERT INTO Blockchain (index, level, transactionHash, certificateHash) VALUES (?,?,?,?) P.S. it should go in the blockchain service **/
   //We use the save functionality for this
}


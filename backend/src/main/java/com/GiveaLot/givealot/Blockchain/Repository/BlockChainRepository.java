
package com.GiveaLot.givealot.Blockchain.Repository;

import com.GiveaLot.givealot.Blockchain.dataclass.Blockchain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BlockChainRepository extends JpaRepository<Blockchain,Long>{

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
    int UpdateBlockchain(long index,long level,String transactionHash,String certificateHash,long orgId);


    @Query("SELECT i FROM Blockchain i WHERE i.certificateHash=?1")
    int getOrgIdWithCertificate(String certificateHash);


    /** (INSERT INTO Blockchain (index, level, transactionHash, certificateHash) VALUES (?,?,?,?) P.S. it should go in the blockchain service **/
   //We use the save functionality for this
}


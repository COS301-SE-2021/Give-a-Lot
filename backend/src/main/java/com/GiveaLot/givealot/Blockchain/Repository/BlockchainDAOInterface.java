
package com.GiveaLot.givealot.Blockchain.Repository;

import com.GiveaLot.givealot.Blockchain.contract.*;
import com.GiveaLot.givealot.Organisation.dataclass.OrganisationRepo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

@Repository
public interface BlockchainDAOInterface extends JpaRepository{



}


package com.GiveaLot.givealot.Certificate.dataclass;

import com.GiveaLot.givealot.Blockchain.service.BlockchainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.math.BigInteger;

public class ContractConfig {

    @Autowired
    BlockchainServiceImpl blockchainService;

    String PRIVATE_KEY = "cd1fce0bb8c6c3127d949b2962846d2613fdb4c00724ce6b6e5bcb26bee0cfcf";
    String CONTRACT_ADDRESS = "";

    private final BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);

    private final BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);

    public String getPRIVATE_KEY() {
        return PRIVATE_KEY;
    }

    public String getCONTRACT_ADDRESS() throws Exception {

        try
        {
            this.CONTRACT_ADDRESS = blockchainService.deploySmartContract();
        }
        catch(Exception e)
        {
            throw new Exception("contract address not set");
        }

        return this.CONTRACT_ADDRESS;
    }

    public BigInteger getGasLimit() {
        return GAS_LIMIT;
    }

    public BigInteger getGasPrice() {
        return GAS_PRICE;
    }

}

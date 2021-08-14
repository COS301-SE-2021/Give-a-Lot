package com.GiveaLot.givealot.Certificate.model;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigInteger;

public class SmartContractConfig {
    @Value("${blockchain.privateKey}")
    String PRIVATE_KEY;

    @Value("${blockchain.contractAddress")
    String CONTRACT_ADDRESS;

    private final BigInteger GAS_LIMIT = BigInteger.valueOf(3000000L);

    private final BigInteger GAS_PRICE = BigInteger.valueOf(20000000000L);

    public String getPRIVATE_KEY() {
        return PRIVATE_KEY;
    }

    public String getCONTRACT_ADDRESS() {
        return CONTRACT_ADDRESS;
    }

    public BigInteger getGasLimit() {
        return GAS_LIMIT;
    }

    public BigInteger getGasPrice() {
        return GAS_PRICE;
    }




}

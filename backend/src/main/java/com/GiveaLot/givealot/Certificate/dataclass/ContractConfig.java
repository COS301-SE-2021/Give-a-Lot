package com.GiveaLot.givealot.Certificate.dataclass;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigInteger;

public class ContractConfig {

    String PRIVATE_KEY = "1d0767d796aac06f2582b0190340428ccb106f5acd41ec1576ea3c7241e3e2cb";


    String CONTRACT_ADDRESS = "0x304f32f0cd60dcc3724121768150d0d5034ee2f0";

    private final BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);

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

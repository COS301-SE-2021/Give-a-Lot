package com.GiveaLot.givealot.Certificate.dataclass;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigInteger;

public class ContractConfig {

    String PRIVATE_KEY = "0xef42cf3aa656ece07be8864c62d2124a0a8009b5728423ea3280910b46d192e9";


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

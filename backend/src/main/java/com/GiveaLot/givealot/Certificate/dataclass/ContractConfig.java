package com.GiveaLot.givealot.Certificate.dataclass;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigInteger;

public class ContractConfig {

    String PRIVATE_KEY = "c7e96f79cddd7a184434c2a94700205ef257a0fbb3bef2df4281652288aea660";


    String CONTRACT_ADDRESS = "0xcb87c473520f8b73d8340b729b6b7cfb81aab181";

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

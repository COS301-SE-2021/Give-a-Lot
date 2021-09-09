package com.GiveaLot.givealot.Certificate.dataclass;

import org.springframework.beans.factory.annotation.Value;

import java.math.BigInteger;

public class ContractConfig {

    String PRIVATE_KEY = "1480f6e77aad7b16723788216022ae0fd700a74850463a6f40fb12515228ad39";


    String CONTRACT_ADDRESS = "0x93f25a35fbb80e2d21621dbb88216fd72cd8aec7";

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

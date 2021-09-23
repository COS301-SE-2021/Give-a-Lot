package com.GiveaLot.givealot.UnitTests;

import com.GiveaLot.givealot.Blockchain.Repository.BlockChainRepository;
import com.GiveaLot.givealot.Blockchain.contract.CertificateContract;
import com.GiveaLot.givealot.Blockchain.service.BlockchainServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.ECKeyPair;

import java.math.BigInteger;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

@ContextConfiguration(classes = {BlockchainServiceImpl.class})
@ExtendWith(SpringExtension.class)
class BlockchainServiceImplTest {
    @MockBean
    private BlockChainRepository blockChainRepository;

    @Autowired
    private BlockchainServiceImpl blockchainServiceImpl;

    @Test
    void testFindCertificateIndex() throws Exception {
        assertThrows(Exception.class, () -> this.blockchainServiceImpl.findCertificateIndex(123L));
        assertEquals(9999L, this.blockchainServiceImpl.findCertificateIndex(0L));
    }

    @Test
    void testRetrieveCertificateHash() throws Exception {
        assertThrows(Exception.class, () -> this.blockchainServiceImpl.retrieveCertificateHash(81985529216486895L, 123L));
        assertThrows(Exception.class, () -> this.blockchainServiceImpl.retrieveCertificateHash(-1474836480L, 123L));
        assertThrows(Exception.class,
                () -> this.blockchainServiceImpl.retrieveCertificateHash(81985529216486895L, -1474836480L));
    }

    @Test
    void testCompareCertificateHash() throws Exception {
        assertThrows(Exception.class, () -> this.blockchainServiceImpl.compareCertificateHash(81985529216486895L, 123L,
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
        assertThrows(Exception.class, () -> this.blockchainServiceImpl.compareCertificateHash(-1474836480L, 123L,
                Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
        assertThrows(Exception.class, () -> this.blockchainServiceImpl.compareCertificateHash(81985529216486895L,
                -1474836480L, Paths.get(System.getProperty("java.io.tmpdir"), "test.txt").toFile()));
    }

    @Test
    void testBuildWeb3jClient() {
        assertTrue(this.blockchainServiceImpl.buildWeb3jClient() instanceof org.web3j.protocol.core.JsonRpc2_0Web3j);
    }

    @Test
    void testDeploySmartContract() throws Exception {
        assertThrows(Exception.class, () -> this.blockchainServiceImpl.deploySmartContract());
    }

    @Test
    void testLoadSmartContract() throws Exception {
        CertificateContract actualLoadSmartContractResult = this.blockchainServiceImpl.loadSmartContract();
        assertEquals("0x49976132c0f3853649eeaf19b96413e549420e84", actualLoadSmartContractResult.getContractAddress());
        assertEquals(180000L, actualLoadSmartContractResult.getSyncThreshold());
        assertEquals(
                "6080604052600060015534801561001557600080fd5b50600080546001600160a01b0319163317905561092d80610037600"
                        + "0396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c8063263b6ffd146100675780"
                        + "634e202a6414610092578063663b3e22146100b5578063ad218a57146100c8578063dc2ed564146100dd578063ff96cad21"
                        + "46100f0575b600080fd5b61007a610075366004610715565b610111565b604051610089939291906107ef565b6040518091"
                        + "0390f35b6100a56100a036600461061a565b610229565b6040519015158152602001610089565b61007a6100c3366004610"
                        + "6a5565b6102d3565b6100db6100d63660046106be565b61037e565b005b6100db6100eb366004610657565b610403565b61"
                        + "01036100fe3660046106a5565b61047f565b604051908152602001610089565b6000805460609082906001600160a01b031"
                        + "6331461012e57600080fd5b6000858152600260205260409020548414156101fb5760008581526002602081905260409091"
                        + "2080549181015460019091018054909190829061017090610875565b80601f0160208091040260200160405190810160405"
                        + "28092919081815260200182805461019c90610875565b80156101e95780601f106101be5761010080835404028352916020"
                        + "01916101e9565b820191906000526020600020905b8154815290600101906020018083116101cc57829003601f168201915"
                        + "b50505050509150925092509250610222565b50506040805180820190915260088152671b9bdd119bdd5b9960c21b602082"
                        + "015260009150815b9250925092565b600080546001600160a01b0316331461024157600080fd5b60005b60015481116102c"
                        + "a578260405160200161025e9190610737565b60408051601f19818403018152828252805160209182012060008581526002"
                        + "8352929092209192610293926001019101610753565b6040516020818303038152906040528051906020012014156102b85"
                        + "750600192915050565b806102c2816108b0565b915050610244565b50600092915050565b60026020526000908152604090"
                        + "2080546001820180549192916102f590610875565b80601f016020809104026020016040519081016040528092919081815"
                        + "260200182805461032190610875565b801561036e5780601f106103435761010080835404028352916020019161036e565b"
                        + "820191906000526020600020905b81548152906001019060200180831161035157829003601f168201915b5050505050908"
                        + "060020154905083565b6000546001600160a01b0316331461039557600080fd5b6000848152600260205260409020548214"
                        + "156103fd5760408051606081018252838152602080820186815282840185905260008881526002835293909320825181559"
                        + "25180519293926103ee92600185019201906104f4565b50604082015181600201559050505b50505050565b600054600160"
                        + "0160a01b0316331461041a57600080fd5b6104226104db565b6040805160608101825283815260208082018681528284018"
                        + "59052600180546000908152600284529490942083518155905180519394919361046c939285019291909101906104f4565b"
                        + "5060408201518160020155905050505050565b600080546001600160a01b0316331461049757600080fd5b60005b6001548"
                        + "1116104d1576000818152600260205260409020548314156104bf5792915050565b806104c9816108b0565b91505061049a"
                        + "565b5061270f92915050565b60018060008282546104ed9190610831565b9091555050565b82805461050090610875565b9"
                        + "0600052602060002090601f0160209004810192826105225760008555610568565b82601f1061053b57805160ff19168380"
                        + "01178555610568565b82800160010185558215610568579182015b828111156105685782518255916020019190600101906"
                        + "1054d565b50610574929150610578565b5090565b5b808211156105745760008155600101610579565b600082601f830112"
                        + "61059e57600080fd5b813567ffffffffffffffff808211156105b9576105b96108e1565b604051601f8301601f199081166"
                        + "03f011681019082821181831017156105e1576105e16108e1565b816040528381528660208588010111156105fa57600080"
                        + "fd5b836020870160208301376000602085830101528094505050505092915050565b60006020828403121561062c5760008"
                        + "0fd5b813567ffffffffffffffff81111561064357600080fd5b61064f8482850161058d565b949350505050565b60008060"
                        + "006060848603121561066c57600080fd5b833567ffffffffffffffff81111561068357600080fd5b61068f8682870161058"
                        + "d565b9660208601359650604090950135949350505050565b6000602082840312156106b757600080fd5b5035919050565b"
                        + "600080600080608085870312156106d457600080fd5b84359350602085013567ffffffffffffffff8111156106f25760008"
                        + "0fd5b6106fe8782880161058d565b949794965050505060408301359260600135919050565b600080604083850312156107"
                        + "2857600080fd5b50508035926020909101359150565b60008251610749818460208701610849565b9190910192915050565"
                        + "b600080835481600182811c91508083168061076f57607f831692505b602080841082141561078f57634e487b7160e01b86"
                        + "526022600452602486fd5b8180156107a357600181146107b4576107e1565b60ff198616895284890196506107e1565b600"
                        + "08a81526020902060005b868110156107d95781548b8201529085019083016107c0565b505084890196505b509498975050"
                        + "505050505050565b8381526060602082015260008351806060840152610814816080850160208801610849565b604083019"
                        + "390935250601f91909101601f19160160800192915050565b60008219821115610844576108446108cb565b500190565b60"
                        + "005b8381101561086457818101518382015260200161084c565b838111156103fd5750506000910152565b600181811c908"
                        + "2168061088957607f821691505b602082108114156108aa57634e487b7160e01b600052602260045260246000fd5b509190"
                        + "50565b60006000198214156108c4576108c46108cb565b5060010190565b634e487b7160e01b60005260116004526024600"
                        + "0fd5b634e487b7160e01b600052604160045260246000fdfea2646970667358221220c7748e8d523345c11a0cbaee66e1c2"
                        + "24be8e5d9f9240048b76ef5c2e2544d37764736f6c63430008070033",
                actualLoadSmartContractResult.getContractBinary());
        BigInteger gasPrice = actualLoadSmartContractResult.getGasPrice();
        assertEquals("20000000000", gasPrice.toString());
        BigInteger sqrtResult = gasPrice.sqrt();
        assertEquals("141421", sqrtResult.toString());
        BigInteger sqrtResult1 = sqrtResult.sqrt();
        assertEquals("376", sqrtResult1.toString());
        BigInteger sqrtResult2 = sqrtResult1.sqrt();
        assertEquals("19", sqrtResult2.toString());
        BigInteger sqrtResult3 = sqrtResult2.sqrt();
        assertEquals("4", sqrtResult3.toString());
        BigInteger sqrtResult4 = sqrtResult3.sqrt();
        assertEquals("2", sqrtResult4.toString());
        BigInteger sqrtResult5 = sqrtResult4.sqrt();
        assertEquals("1", sqrtResult5.toString());
        assertEquals("1", sqrtResult5.sqrt().toString());
    }

    @Test
    void testGetCredentialsFromPrivateKey() {
        Credentials actualCredentialsFromPrivateKey = this.blockchainServiceImpl.getCredentialsFromPrivateKey();
        assertEquals("0xa8be03b231262f97deff94995f354a8b326d6e21", actualCredentialsFromPrivateKey.getAddress());
        ECKeyPair ecKeyPair = actualCredentialsFromPrivateKey.getEcKeyPair();
        BigInteger privateKey = ecKeyPair.getPrivateKey();
        assertEquals("78337984223596099681928494980669218682961334033308618174645820302609524138676",
                privateKey.toString());
        BigInteger publicKey = ecKeyPair.getPublicKey();
        assertEquals("6543615266245016533463587882106932274734571685651030438524561038584794875647444772388662878221967730"
                + "692497932629165565870232504372245777049265700053457511", publicKey.toString());
        BigInteger sqrtResult = publicKey.sqrt();
        assertEquals("80892615647196231167706880562725344091564911884063501262712070890094581049491",
                sqrtResult.toString());
        BigInteger sqrtResult1 = privateKey.sqrt();
        assertEquals("279889235633662945772815746441957278957", sqrtResult1.toString());
        BigInteger sqrtResult2 = sqrtResult.sqrt();
        assertEquals("284416271769384233955719750476398798948", sqrtResult2.toString());
        BigInteger sqrtResult3 = sqrtResult1.sqrt();
        assertEquals("16729890484807811370", sqrtResult3.toString());
        BigInteger sqrtResult4 = sqrtResult2.sqrt();
        assertEquals("16864645616477810647", sqrtResult4.toString());
        BigInteger sqrtResult5 = sqrtResult3.sqrt();
        assertEquals("4090218879", sqrtResult5.toString());
        assertEquals("63954", sqrtResult5.sqrt().toString());
        BigInteger sqrtResult6 = sqrtResult4.sqrt();
        assertEquals("4106658692", sqrtResult6.toString());
        assertEquals("64083", sqrtResult6.sqrt().toString());
    }
}


package server;

import java.math.BigInteger;

public record RSA(java.math.BigInteger bigInteger, java.math.BigInteger integer, java.math.BigInteger bigInteger1) {
    public BigInteger decrypt(BigInteger cipher) {

        return cipher;
    }
}

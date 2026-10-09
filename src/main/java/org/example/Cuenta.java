package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Cuenta {
    private String numCuenta;
    private String titular;
    private BigDecimal saldo;
    private String pin;

    public Cuenta(String numCuenta, String titular, BigDecimal saldo) {
        this.numCuenta = numCuenta;
        this.titular = titular;
        this.saldo = saldo;
        this.pin = "1234";
    }

    public boolean validar_pin(String pin){
        return this.pin.equals(pin);
    }
}

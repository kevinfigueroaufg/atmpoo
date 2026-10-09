package org.example;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

@Getter
@Setter
public class Transaccion extends Operacion{
    private String referencia;

    public Transaccion(Cuenta cuenta, LocalDateTime fecha_hora, String naturaleza, BigDecimal monto, String referencia) {
        super(cuenta, fecha_hora, naturaleza, monto);
        this.referencia = referencia;
    }

    public boolean guardarTxn(){
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        System.out.println("Enviando transaccion...");
        setReferencia(String.valueOf(new Random().nextInt((99999999 - 10000000) + 1) + 10000000));
        System.out.println("Transaccion guardada, ");
        System.out.println("*-------------------------------------------------------------------*");
        System.out.println(
                              ("Ref: ").concat(getReferencia())
                .concat("\nMonto: $").concat(String.valueOf(getMonto()))
                .concat("\nFecha_hora: ".concat(getFecha_hora().format(formateador)))
                .concat("\nTipo: ".concat(getNaturaleza()))
                .concat("\nCuenta: ".concat(getCuenta().getNumCuenta())));
        System.out.println("*-------------------------------------------------------------------*");
        return true;
    }
}

package org.example;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
public class Operacion {
    private Cuenta cuenta;
    private LocalDateTime fecha_hora;
    private String naturaleza;
    private BigDecimal monto;

    public Operacion(Cuenta cuenta, LocalDateTime fecha_hora, String naturaleza, BigDecimal monto) {
        this.cuenta = cuenta;
        this.fecha_hora = fecha_hora;
        this.naturaleza = naturaleza;
        this.monto = monto;
    }

    public void consulta(){
        System.out.println("*-------------------------------------------------------------------*");
        System.out.println("Su saldo actual es: $".concat(cuenta.getSaldo().toString()));
        Transaccion txn=new Transaccion(cuenta,fecha_hora,naturaleza,monto,"");
        txn.guardarTxn();
        System.out.println(getNaturaleza().concat(" exitoso"));
        System.out.println("*-------------------------------------------------------------------*");
    }

    public boolean deposito(){
        System.out.println("*-------------------------------------------------------------------*");
        System.out.println("Su saldo actual es: $".concat(cuenta.getSaldo().toString()));
        System.out.println("Iniciado "+getNaturaleza()+"...");
        if (getMonto().compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Monto debe ser mayor a 0.00");
            return false;
        }else{
            getCuenta().setSaldo(getCuenta().getSaldo().add(getMonto()));
            System.out.println("Saldo actualizado");
            Transaccion txn=new Transaccion(cuenta,fecha_hora,naturaleza,monto,"");
            txn.guardarTxn();
            System.out.println(getNaturaleza().concat(" exitoso"));
            System.out.println("*-------------------------------------------------------------------*");
            System.out.println("Su saldo actual es: $".concat(cuenta.getSaldo().toString()));
            return true;
        }
    }

    public boolean retiro(){
        System.out.println("*-------------------------------------------------------------------*");
        System.out.println("Su saldo actual es: $".concat(cuenta.getSaldo().toString()));
        System.out.println("Iniciado "+getNaturaleza()+"...");
        if (getMonto().compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Monto debe ser mayor a 0.00");
            return false;
        }else{
            if (getMonto().compareTo(getCuenta().getSaldo()) >= 0){
                System.out.println("Monto debe ser menor al saldo de la cuenta");
                return false;
            }else{
                getCuenta().setSaldo(getCuenta().getSaldo().subtract(getMonto()));
                System.out.println("Saldo actualizado");
                Transaccion txn=new Transaccion(cuenta,fecha_hora,naturaleza,monto,"");
                txn.guardarTxn();
                System.out.println(getNaturaleza().concat(" exitoso"));
                System.out.println("*-------------------------------------------------------------------*");
                System.out.println("Su saldo actual es: $".concat(cuenta.getSaldo().toString()));
                return true;
            }
        }
    }
}

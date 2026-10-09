package org.example;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.logging.Logger;

@Setter
@Getter
public class Cajero {
    private static final Logger log = Logger.getLogger(Cajero.getName());

    private static String getName() {
        return "Cajero";    }

    private String ubicacion;

    public Cajero(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void iniciar() {
        System.out.println("Bienvenido a cajero ".concat(ubicacion));
        Scanner scanner=new Scanner(System.in);
        Cuenta cuenta = new Cuenta("00082733113", "Kevin Menjivar",new BigDecimal(0.00));
        boolean pinok=false;
        do{
            System.out.println("Digite su pin (-1 para salir):");
            String pin = scanner.next();
            if(pin.equals("-1")){
                break;
            }else{
                pinok=cuenta.validar_pin(pin);
            }
            if (pinok) {
                int opcion=0;
                System.out.println(cuenta.getTitular());
                do{
                System.out.println("Selecccione una opcion: ");
                System.out.println(
                                "1. CONSULTA DE SALDO\n" +
                                "2. DEPOSITO DE SALDO\n" +
                                "3. RETIRO DE SALDO\n" +
                                "4. SALIR\n");
                opcion = scanner.nextInt();
                BigDecimal montoIn;
                switch (opcion) {
                    case 1:
                        new Operacion(cuenta, LocalDateTime.now(), "Consulta", new BigDecimal(0.00)).consulta();
                        break;
                    case 2:
                        System.out.println("Digite la cantidad a depositar (#.##)");
                        montoIn = scanner.nextBigDecimal();
                        new Operacion(cuenta, LocalDateTime.now(), "Deposito", montoIn).deposito();
                        break;
                    case 3:
                        System.out.println("Digite la cantidad a retirar (#.##)");
                        montoIn = scanner.nextBigDecimal();
                        new Operacion(cuenta, LocalDateTime.now(), "Retiro", montoIn).retiro();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
                }while(opcion!=4);
            }
        }while(!pinok);

        scanner.close();
    }
    public void finalizar() {
        System.out.println("Gracias por utilizar su cajero ");
    }
}

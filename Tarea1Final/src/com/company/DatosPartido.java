package com.company;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class DatosPartido {
    private int numeroPartido;
    private int codigoEquipo1;
    private int codigoEquipo2;
    private String nombreEquipo1;
    private String nombreEquipo2;
    private String fechaHora;
    private double factorEquipo1;
    private double factorEquipo2;
    private double factorEmpate;
    private int golesEquipo1;
    private int golesEquipo2;


    // setter and getter numeroPartido //
    private void setNumeroPartido() {
        numeroPartido = validaInt(1, 100, "Ingrese el número de partido: ");
        System.out.println("Número procesado. ");
        System.out.println();
    }

    // setter and getter codigoEquipo1
    private void setCodigoEquipo1() {
        codigoEquipo1 = validaInt(1, 100, "Ingrese el código del Equipo 1: ");
        System.out.println("Código procesado. ");
    }

    // setter and getter codigoEquipo2
    private void setCodigoEquipo2() {
        int tempValue = validaInt(1, 100, "Ingrese el código del Equipo 2: ");
        while (codigoEquipo1 == tempValue) {
            System.out.println("El código del Equipo 2 no puede ser igual al del equipo 1");
            tempValue = validaInt(1, 100, "Ingrese el código del Equipo 2: ");
        }
        codigoEquipo2 = tempValue;
        System.out.println("Código procesado. ");
    }


    public int getCodigoEquipo2() {
        return codigoEquipo2;
    }

    // setter and getter GolesEquipo1
    private void setGolesEquipo1() {
        golesEquipo1 = validaInt(0, 20, "Ingrese los goles del equipo 1: ");
        System.out.println("Valor procesado. ");
    }

    int getGolesEquipo1() {
        return golesEquipo1;
    }

    // setter and getter GolesEquipo2
    private void setGolesEquipo2() {
        golesEquipo2 = validaInt(0, 20, "Ingrese los goles del Equipo 2: ");
        System.out.println("Valor procesado. ");
    }

    int getGolesEquipo2() {
        return golesEquipo2;
    }

    // setter and getter NombreEquipo1
    private void setNombreEquipo1() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite el nombre del equipo 1: ");
        nombreEquipo1 = input.nextLine();
        System.out.println("Nombre del equipo 1 procesado.");
        System.out.println();
    }

    private String getNombreEquipo1() {
        return nombreEquipo1;
    }

    // setter and getter NombreEquipo2
    private void setNombreEquipo2() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite el nombre del equipo 2: ");
        nombreEquipo2 = input.nextLine();
        System.out.println("Nombre del equipo 2 procesado.");
        System.out.println();
    }

    private String getNombreEquipo2() {
        return nombreEquipo2;
    }

    // Validacion de fecha
    private  String validaFecha() {
        //https://docs.oracle.com/javase/7/docs/api/java/text/DateFormat.html#isLenient()//

        // define formato de fecha
        DateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        // setea parsing cuando el formato  es exacto
        formatoFecha.setLenient(false);
        Scanner input = new Scanner(System.in);
        String fechaUsuario = null;
        String fecha = null;
        boolean pass = true;
        while (pass) {
            try {
                System.out.print("Digite la fecha y la hora (formato dd/mm/yyyy hh:mm):  ");
                fechaUsuario = input.nextLine();
                formatoFecha.parse(fechaUsuario);
                fecha = fechaUsuario;
                System.out.println("Fecha procesada.");
                pass = false;
            } catch (ParseException e) {
                System.out.println("Fecha  y/u hora ingresada:  '" + fechaUsuario + "' no es correcta. Intente de nuevo.");
            }
        }

        return fecha;
    }


    // setter and getter FechaHora
    private void setFechaHora() {

        fechaHora = validaFecha();
    }

    public String getFechaHora() {
        return fechaHora;
    }

    // setter and getter FactorEquipo1
    private void setFactorEquipo1() {
        factorEquipo1 = validaDouble(0.01, 100.00, "Ingrese el factor para el equipo 1: ");
        System.out.println("El valor fue procesado correctamente.");
        System.out.println();
    }

    private double getFactorEquipo1() {
        return factorEquipo1;
    }


    // setter and getter FactorEquipo2
    private void setFactorEquipo2() {
        factorEquipo2 = registroFactores( "Ingrese el factor para el equipo 2: ",1);
    }

    // llama a metodo validaFactorApuestas para validar factores de apuestas
    private double registroFactores(String solicitud, int opcionValidaFactorApuestas){
        double tempFactorApuesta;
        boolean validacion;
        do {

            tempFactorApuesta = validaDouble(0.01,100,solicitud);
            validacion = validaFactorApuestas(tempFactorApuesta,opcionValidaFactorApuestas);
            if(validacion){
                System.out.println();
            }

        } while (validacion);
        System.out.println("El valor fue procesado correctamente.");
        System.out.println();
        return tempFactorApuesta;
    }




    private double getFactorEquipo2() {
        return factorEquipo2;
    }

    // setter and getter FactorEmpate
    private void setFactorEmpate() {
        factorEmpate = registroFactores( "Ingrese el factor para un empate: ",2);
    }

    private double getFactorEmpate() {
        return factorEmpate;
    }

    // valida que los factores no sean duplicados
    private boolean validaFactorApuestas(double apuesta, int opcion) {
        boolean invalido = false;
        switch (opcion) {
            case 1:
                if (getFactorEquipo1() == apuesta) {
                    invalido = true;
                    System.out.println("Error: el factor equipo 1 no puede ser igual al factor equipo 2");
                }
                break;
            case 2:
                if ((getFactorEquipo1() == apuesta) || (getFactorEquipo2() == apuesta)) {
                    invalido = true;
                    System.out.println("Error: el factor empate no puede ser igual a ningun factor equipo");
                }
                break;
            default:
                System.out.println("Valor Incorrecto");
                break;
        }

        return invalido;
    }





    // metodo para solicitar y validar integers dentro de un rango
    private  int validaInt(int min, int max, String message){
        int value = 0;
        Scanner input = new Scanner(System.in);
        boolean isInvalid = true;
        do{
            try {
                System.out.print(message);
                value = input.nextInt();
                if((value >= min) && (value <= max)){
                    isInvalid = false;
                } else {
                    input.nextLine();
                    System.out.println("Error: el valor debe de estar en un rango del " + min + " al " + max  + " . Intente de nuevo.");
                }

            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Error: solo puede ingresar números enteros.");
            }

        } while(isInvalid);
        return value;
    }


    // metodo para solicitar y validar doubles dentro de un rango
    private  double validaDouble(double min, double max, String message){
        double value = 0.00;
        Scanner input = new Scanner(System.in);
        boolean isInvalid = true;
        do{
            try {
                System.out.print(message);
                value = input.nextDouble();
                if((value >= min) && (value <= max)){
                    isInvalid = false;
                } else {
                    input.nextLine();
                    System.out.println("Error: el valor debe de estar en un rango del " + min + " al " + max  + " .Intente de nuevo.");
                }

            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("Error: solo puede ingresar números.");
                System.out.println();
            }

        } while(isInvalid);
        return value;
    }


    // Solicita los datos del usuario
    void requestValues(){
        System.out.println("******************* Ingrese los datos del partido  ************************");
        setNumeroPartido();
        setFechaHora();
        System.out.println();
        setNombreEquipo1();
        setCodigoEquipo1();
        System.out.println();
        setNombreEquipo2();
        setCodigoEquipo2();
        System.out.println();
        setFactorEquipo1();
        setFactorEquipo2();
        setFactorEmpate();
        System.out.println();
        System.out.println("********* Ingrese el resultado del encuentro: " + getNombreEquipo1() +" vs " + getNombreEquipo2() + " **********");
        System.out.println();
        setGolesEquipo1();
        setGolesEquipo2();
    }

    // metodo para encontrar determinar el resultado del juego
    int resultadoJuego(int equipo1, int equipo2) {

        int winValue;

        if (equipo1 > equipo2) { // gana el equipo 1
            winValue = 1;
        } else if (equipo2 > equipo1) { // gana el equipo 2
            winValue = 2;
        } else {
            winValue = 3; //empate
        }
        return winValue;

    }

    // determina el factor para el pago de apuestas de acuerdo al ganador
    double winFactor(int value) {
        System.out.println();
        System.out.println("---------------------------RESULTADO DEL PARTIDO ------------------------------------");
        double factorCalc = 0;
        switch (value){
            case 1:
                System.out.println( getNombreEquipo1() +  " fue el ganador del encuentro. " + " Se paga a un factor de " + getFactorEquipo1());
                factorCalc = getFactorEquipo1();
                break;
            case 2:
                System.out.println( getNombreEquipo2() + " fue el ganador del encuentro. " + " Se paga a un factor de " + getFactorEquipo2());
                factorCalc = getFactorEquipo2();
                break;
            case 3:
                System.out.println("El partido termino en empate. " + " Se paga a un factor de " + getFactorEmpate());
                factorCalc = getFactorEmpate();
                break;
            default:
                System.out.println("Valor Incorrecto");
                break;
        }
        System.out.println("-------------------------------------------------------------------------------------");
        return factorCalc;

    }

}

package com.company;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Apuestas {
    private String numeroCedula;
    private String nombre;
    private double apuestaEquipo1;
    private double apuestaEquipo2;
    private double apuestaEmpate;
    private ArrayList<String> listaNombres = new ArrayList<String>();
    private ArrayList<String> listaCedulas = new ArrayList<String>();
    private ArrayList<Double> listaApuestaEquipo1 = new ArrayList<Double>();
    private ArrayList<Double> listaApuestaEquipo2 = new ArrayList<Double>();
    private ArrayList<Double> listaApuestaEmpate = new ArrayList<Double>();
    private ArrayList<Double> listaGanancia = new ArrayList<Double>();


    //getter para listaGanancia
    private ArrayList<Double> getListaGanancia() {
        return listaGanancia;
    }

    //getter para listaNombres
    ArrayList<String> getListaNombres() {
        return listaNombres;
    }
    // getter para listaCedulas
    public ArrayList<String> getListaCedulas() {
        return listaCedulas;
    }

    // getter listaApuestasEquipo1
    private ArrayList<Double> getListaApuestaEquipo1() {
        return listaApuestaEquipo1;
    }

    // getter listaApuestasEquipo2
    private ArrayList<Double> getListaApuestaEquipo2() {
        return listaApuestaEquipo2;
    }

    // getter listaApuestaEmpate
    private ArrayList<Double> getListaApuestaEmpate() {
        return listaApuestaEmpate;
    }

    //setter and getter NumeroCedula //
    private void setNumeroCedula() {
        numeroCedula = validaCedula();
    }

    private String getNumeroCedula() {
        return numeroCedula;
    }

    //setter and getter Nombre //

    private void setNombre() {

        String primerNombre = validateNombre("primer nombre");
        String apellido = validateNombre("apellido");
        nombre = primerNombre + " " + apellido;
        System.out.println("Nombre procesado.");
        System.out.println();
    }

    // metodo para validar el formato del nombre
    private static String validateNombre(String evalValor) {
        Scanner input = new Scanner(System.in);
        String nombre = null;
        boolean aceptaNombre = true;
        do {
            System.out.print("Ingrese el " + evalValor + ": ");
            String tempName = input.nextLine();
            if (tempName.matches("[a-zA-Z]+")) {
                nombre = tempName;
                aceptaNombre = false;

            } else {
                System.out.println("Error: el " + evalValor + " es invalido");
                System.out.println();
            }
        } while (aceptaNombre);

        return nombre;
    }

    private String getNombre() {
        return nombre;
    }

    //setter and getter ApuestaEquipo1 //
    private void setApuestaEquipo1() {
        apuestaEquipo1 = validaMonto("Digite el monto de apuesta para el equipo 1: ");
    }

    private double getApuestaEquipo1() {
        return apuestaEquipo1;
    }


    //setter and getter ApuestaEquipo2 //
    private void setApuestaEquipo2() {
        apuestaEquipo2 = validaMonto("Digite el monto de apuesta para el equipo 2: ");
    }

    private double getApuestaEquipo2() {
        return apuestaEquipo2;
    }



    //setter and getter Empate //
    private void setApuestaEmpate() {
        apuestaEmpate = validaMonto("Digite el monto de apuesta en caso de empate: ");
    }

    private double getApuestaEmpate() {
        return apuestaEmpate;
    }



    private String validaCedula() {
        String format = "\\d+";
        String test = null;
        boolean continua = true;
        boolean testCount = false;
        while (continua) {
            System.out.println("Digite el número de cédula. Use el formato de 10 digitos. Ejemplo:0110710340 ");
            System.out.print("Cédula: ");
            Scanner input = new Scanner(System.in);
            test = input.nextLine();
            if (test.length() == 10) {
                testCount = true;
            }

            if ((test.matches(format)) && testCount) {
                System.out.println("Número de cédula procesado.");
                continua = false;
            } else {
                //input.nextLine();
                System.out.println("*******Error: formato de cédula incorrecto. Volver a intentar.******");
            }
        }
        return test;
    }
    /*
    public double calculoApuesta(double valorFactor, double monto) {

        double total = valorFactor * monto;
        return total;
    }
    */

    // metodo para validar numero de cedula de nacional


    // valida el monto de la apuesta
    private double validaMonto(String message) {
        double tempMonto = 0;
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;
        boolean checkCed = true;
        while (checkCed) {

            try {
                while (continua) {
                    System.out.print(message);
                    tempMonto = scanner.nextDouble();
                    if ((tempMonto < 0) || (tempMonto > 10000)) {
                        System.out.println("Error: monto de la apuesta incorrecto. La apuesta máxima es de 10000");
                        scanner.nextLine();
                    } else {
                        continua = false;
                        System.out.println("Monto de apuesta procesado.");
                    }
                }
                checkCed = false;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Valor Incorrecto. Solo se permiten con decimales.");
            }

        }
        return tempMonto;

    }


    // Solicita la informacion de las apuestas
    void solicitaApuestas() {

        boolean continuar = true;
        int counter = 0;
        System.out.println("****************** INGRESO DE APUESTAS ************************");
        System.out.println("Ingrese los datos que se solicitan a continuacion.");
        while (continuar) {
            System.out.println("----------------------------------------------------------");
            System.out.println("|            Apuesta # " + (counter+1) +                 "|");
            System.out.println("----------------------------------------------------------");
            setNombre();
            listaNombres.add(getNombre());
            System.out.println();
            setNumeroCedula();
            listaCedulas.add(getNumeroCedula());
            System.out.println();
            setApuestaEquipo1();
            listaApuestaEquipo1.add(getApuestaEquipo1());
            System.out.println();
            setApuestaEquipo2();
            listaApuestaEquipo2.add(getApuestaEquipo2());
            System.out.println();
            setApuestaEmpate();
            listaApuestaEmpate.add(getApuestaEmpate());

            System.out.println();
            System.out.println(" -----------------------------------------------------------");
            System.out.println("| Si desea agregar otra apuesta digite cualquier tecla.     |");
            System.out.println("| Si no desea agregar otra apuesta digite 'No' .                              |");
            System.out.println(" -----------------------------------------------------------");
            System.out.println();
            System.out.print("Desea agregar otra apuesta Si/No? : ");
            Scanner value = new Scanner(System.in);
            String valorUsuario = value.nextLine().toLowerCase();


            if (valorUsuario.equals("no")) {
                System.out.println("--------------- Fin de ingreso de apuestas --------------");
                System.out.println();
                continuar = false;
            }
            counter++;
        }
    }


    // Calcula las ganacias de los jugadores
    void calculoGanancias(double factorGanador, int winner) {
        double ganancia;

        switch (winner) {
            case 1:
                for (int i = 0; i < listaNombres.size(); i++) {
                    ganancia = getListaApuestaEquipo1().get(i) * factorGanador;
                    listaGanancia.add(ganancia);
                }
                break;


            case 2:
                for (int i = 0; i < listaNombres.size(); i++) {
                    ganancia = getListaApuestaEquipo2().get(i) * factorGanador;
                    listaGanancia.add(ganancia);
                }
                break;

            case 3:
                for (int i = 0; i < listaNombres.size(); i++) {
                    ganancia = getListaApuestaEmpate().get(i) * factorGanador;
                    listaGanancia.add(ganancia);
                }
                break;

            default:
                System.out.println("Valor Incorreto");

        }
    }



    // Imprime los resultados de las apuestas por jugador
    void imprimeResultados(){
        double totalPagado;
        for(int i=0; i<listaNombres.size(); i++){
            System.out.println();
            System.out.println("****************RESULTADO DE LAS APUESTAS POR JUGADOR # "+ (i+1) + "****************");
            System.out.println("Nombre: " + listaNombres.get(i) );
            System.out.println("Cédula: " + listaCedulas.get(i));
            System.out.println("Apuesta al Equipo 1: " + listaApuestaEquipo1.get(i) );
            System.out.println("Apuesta al Equipo 2: " + listaApuestaEquipo2.get(i) );
            System.out.println("Apuesta al Empate: " + listaApuestaEmpate.get(i));
            totalPagado = listaApuestaEquipo1.get(i) + listaApuestaEquipo2.get(i) + listaApuestaEmpate.get(i);
            System.out.println("Total Pagado: " + totalPagado);
            System.out.println("Ganancia del Jugador: " + listaGanancia.get(i));
            System.out.println("**************************FIN DE APUESTA # " + (i+1) + " ****************************");
            System.out.println();
        }
        System.out.println("***********************FIN RESULTADOS DE APUESTAS POR JUGADOR************************");
    }


    // Imprime el resultado final de las apuestas
    void imprimeTotalApuestas(){
        double totalApostadoEquipo1 = 0;
        double totalApostadoEquipo2 = 0;
        double totalApostadoEmpate = 0;
        double totalGanancias;
        double totalPagado = 0;
        for (int i =0; i < listaNombres.size(); i++){
            totalApostadoEquipo1 += getListaApuestaEquipo1().get(i);
            totalApostadoEquipo2 += getListaApuestaEquipo2().get(i);
            totalApostadoEmpate += getListaApuestaEmpate().get(i);
            totalPagado += getListaGanancia().get(i);
        }
        totalGanancias = ((totalApostadoEquipo1+totalApostadoEquipo2+totalApostadoEmpate) - totalPagado);
        System.out.println();
        System.out.println("************************* TOTAL DE APUESTAS JUEGO # 1 ********************************");
        System.out.println("Total Apostado al Equipo 1: " + totalApostadoEquipo1);
        System.out.println("Total Apostado al Equipo 2: " + totalApostadoEquipo2);
        System.out.println("Total Apostado al Empate  : " + totalApostadoEmpate);
        System.out.println("total Apostado: "+ (totalApostadoEquipo1+totalApostadoEquipo2+totalApostadoEmpate));
        System.out.println("Total Pagado: " + totalPagado);
        if(totalGanancias >=0){
            System.out.println("Total Ganancias: " + totalGanancias);
        } else {
            System.out.println("Total Perdidas: " + totalGanancias);
        }
        System.out.println("**************************************************************************************");
        System.out.println("******************************** Fin del Sistema *************************************");
    }


}

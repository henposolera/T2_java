package com.company;

public class Main {

    public static void main(String[] args) {


        DatosPartido partido1 = new DatosPartido();
        Apuestas juego1 = new Apuestas();
        ejecutaPrograma(juego1,partido1);
    }


    private static void  ejecutaPrograma(Apuestas objApuestas, DatosPartido objDatosPartido){
        objApuestas.solicitaApuestas();
        objDatosPartido.requestValues();
        int winner =objDatosPartido.resultadoJuego(objDatosPartido.getGolesEquipo1(),objDatosPartido.getGolesEquipo2());
        double winFactor = objDatosPartido.winFactor(winner);
        objApuestas.calculoGanancias(winFactor,winner);
        objApuestas.imprimeResultados();
        objApuestas.imprimeTotalApuestas();
    }
}

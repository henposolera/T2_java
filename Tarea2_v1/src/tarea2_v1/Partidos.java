/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2_v1;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author bacti
 */
public class Partidos {

    private int numeroPartido;
    private int codigoEquipo1;
    private int codigoEquipo2;
    private int golesEquipo1;
    private int golesEquipo2;
    private String nombreEquipo1;
    private String nombreEquipo2;
    private String fechaHora;
    private double factorEquipo1;
    private double factorEquipo2;
    private double factorEmpate;

    private ArrayList<Integer> listaNumeroPartido = new ArrayList<Integer>();
    private ArrayList<Integer> listaCodigoEquipo1 = new ArrayList<Integer>();
    private ArrayList<Integer> listaCodigoEquipo2 = new ArrayList<Integer>();
    private ArrayList<Integer> listaGolesEquipo1 = new ArrayList<Integer>();
    private ArrayList<Integer> listaGolesEquipo2 = new ArrayList<Integer>();
    private ArrayList<Double> listaFactorEquipo1 = new ArrayList<Double>();
    private ArrayList<Double> listaFactorEquipo2 = new ArrayList<Double>();
    private ArrayList<Double> listaFactorEmpate = new ArrayList<Double>();
    private ArrayList<String> listaNombreEquipo1 = new ArrayList<String>();
    private ArrayList<String> listaNombreEquipo2 = new ArrayList<String>();
    private ArrayList<String> listaFechaHora = new ArrayList<String>();

    public void setNumeroPartido(ArrayList<Integer> counter) {
        numeroPartido = counter.size();
    }

    private void setCodigoEquipo1(JTextField textCodEquipo1) {
        String temp = textCodEquipo1.getText();
        codigoEquipo1 = Integer.parseInt(temp);
    }

    private void setCodigoEquipo2(JTextField textCodEquipo2) {
        String temp = textCodEquipo2.getText();
        codigoEquipo2 = Integer.parseInt(temp);
    }

    public void setGolesEquipo1(JTextField textGolesEquipo1) {
        String temp = textGolesEquipo1.getText();
        golesEquipo1 = Integer.parseInt(temp);
    }

    public void setGolesEquipo2(JTextField textGolesEquipo2) {
        String temp = textGolesEquipo2.getText();
        golesEquipo2 = Integer.parseInt(temp);
    }

    public void setNombreEquipo1(JTextField TextNombreEquipo1) {
        nombreEquipo1 = TextNombreEquipo1.getText();
    }

    public void setNombreEquipo2(JTextField TextNombreEquipo2) {
        nombreEquipo2 = TextNombreEquipo2.getText();
    }

    public void setFechaHora(JTextField TextFechaHora) {
        fechaHora = TextFechaHora.getText();
    }

    public void setFactorEquipo1(JTextField TextFactorEquipo1) {
        String temp = TextFactorEquipo1.getText();
        factorEquipo1 = Double.parseDouble(temp);
    }

    public void setFactorEquipo2(JTextField TextFactorEquipo2) {
        String temp = TextFactorEquipo2.getText();
        factorEquipo2 = Double.parseDouble(temp);
    }

    public void setFactorEmpate(JTextField TextFactorEmpate) {
        String temp = TextFactorEmpate.getText();
        factorEmpate = Double.parseDouble(temp);
    }

    public int getNumeroPartido() {
        return numeroPartido;
    }

    public int getCodigoEquipo1() {
        return codigoEquipo1;
    }

    public int getCodigoEquipo2() {
        return codigoEquipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public String getNombreEquipo1() {
        return nombreEquipo1;
    }

    public String getNombreEquipo2() {
        return nombreEquipo2;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public double getFactorEquipo1() {
        return factorEquipo1;
    }

    public double getFactorEquipo2() {
        return factorEquipo2;
    }

    public double getFactorEmpate() {
        return factorEmpate;
    }

    void solicitaPartidos(JTextField fechaHora, JTextField nombreEquipo1, JTextField codigoEquipo1, JTextField nombreEquipo2, JTextField codigoEquipo2, JTextField factorEquipo1, JTextField factorEquipo2, JTextField factorEmpate,
            JTextField golesEquipo1, JTextField golesEquipo2) {

        if (fechaHora.getText().equals("")
                || nombreEquipo1.getText().equals("")
                || codigoEquipo1.getText().equals("")
                || nombreEquipo2.getText().equals("")
                || codigoEquipo2.getText().equals("")
                || factorEquipo1.getText().equals("")
                || factorEquipo2.getText().equals("")
                || factorEmpate.getText().equals("")
                || golesEquipo1.getText().equals("")
                || golesEquipo2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe de completar todos los campos antes de guardar");
        } else {
            int choice = JOptionPane.showOptionDialog(null, "Desea agregar  partido?", "continuar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (choice == JOptionPane.YES_OPTION) {

                setNumeroPartido(listaNumeroPartido);
                listaNumeroPartido.add(getNumeroPartido() + 1);
                setFechaHora(fechaHora);
                listaFechaHora.add(getFechaHora());
                setNombreEquipo1(nombreEquipo1);
                listaNombreEquipo1.add(getNombreEquipo1());
                setCodigoEquipo1(codigoEquipo1);
                listaCodigoEquipo1.add(getCodigoEquipo1());
                setNombreEquipo2(nombreEquipo2);
                listaNombreEquipo2.add(getNombreEquipo2());
                setCodigoEquipo2(codigoEquipo2);
                listaCodigoEquipo2.add(getCodigoEquipo2());

                setFactorEquipo1(factorEquipo1);
                listaFactorEquipo1.add(getFactorEquipo1());
                setFactorEquipo2(factorEquipo2);
                listaFactorEquipo2.add(getFactorEquipo2());
                setFactorEmpate(factorEmpate);
                listaFactorEmpate.add(getFactorEmpate());

                setGolesEquipo1(golesEquipo1);
                listaGolesEquipo1.add(getGolesEquipo1());
                setGolesEquipo2(golesEquipo2);
                listaGolesEquipo2.add(getGolesEquipo2());

                JOptionPane.showMessageDialog(null, "Partido Procesado");
                clearJtextPartidos(fechaHora, nombreEquipo1, codigoEquipo1, nombreEquipo2, codigoEquipo2, factorEquipo1, factorEquipo2, factorEmpate, golesEquipo1, golesEquipo2);
            }

        }

    }

    public void clearJtextPartidos(JTextField fechaHora, JTextField nombreEquipo1, JTextField codigoEquipo1, JTextField nombreEquipo2, JTextField codigoEquipo2, JTextField factorEquipo1, JTextField factorEquipo2, JTextField factorEmpate,
            JTextField golesEquipo1, JTextField golesEquipo2) {
        codigoEquipo1.setText("");
        codigoEquipo2.setText("");
        fechaHora.setText("");
        nombreEquipo1.setText("");
        nombreEquipo2.setText("");
        golesEquipo1.setText("");
        golesEquipo2.setText("");
        factorEquipo1.setText("");
        factorEquipo2.setText("");
        factorEmpate.setText("");

    }

    double winFactor(int value) {
        double factorCalc = 0;
        switch (value) {
            case 1:
                factorCalc = getFactorEquipo1();
                break;
            case 2:
                factorCalc = getFactorEquipo2();
                break;
            case 3:
                factorCalc = getFactorEmpate();
                break;
            default:
                System.out.println("Valor Incorrecto");
                break;
        }
        return factorCalc;

    }

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

    void imprimeResultados() {
        for (int i = 0; i < listaFechaHora.size(); i++) {
            System.out.println();
            System.out.println("****************LISTA DE PARTIDOS PARTIDO # " + listaNumeroPartido.get(i) + "****************");
            System.out.println("Fecha: " + listaFechaHora.get(i));
            System.out.println("Nombre Equipo 1: " + listaNombreEquipo1.get(i));
            System.out.println("Codigo Equipo 1: " + listaCodigoEquipo1.get(i));
            System.out.println("Nombre Equipo 2: " + listaNombreEquipo2.get(i));
            System.out.println("Codigo Equipo 2: " + listaCodigoEquipo2.get(i));

            System.out.println("Factor Equipo 1: " + listaFactorEquipo1.get(i));
            System.out.println("Factor Equipo 2: " + listaFactorEquipo2.get(i));
            System.out.println("Factor Empate: " + listaFactorEmpate.get(i));

            System.out.println("Goles Equipo 1: " + listaGolesEquipo1.get(i));
            System.out.println("Goles Equipo 2: " + listaGolesEquipo2.get(i));
            System.out.println("**************************FIN DE Partido # " + listaNumeroPartido.get(i) + " ****************************");
            System.out.println();
        }
    }
}

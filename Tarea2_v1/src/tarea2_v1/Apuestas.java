/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea2_v1;

/**
 *
 * @author bacti
 */
import javax.swing.*;
import java.util.ArrayList;

public class Apuestas {

    private String numeroCedula;
    private String nombre;
    private double apuestaEquipo1;
    private double apuestaEquipo2;
    private double apuestaEmpate;
    private int counter;
    private ArrayList<Integer> listaCounter = new ArrayList<Integer>();
    private ArrayList<String> listaNombres = new ArrayList<String>();
    private ArrayList<String> listaCedulas = new ArrayList<String>();
    private ArrayList<Double> listaApuestaEquipo1 = new ArrayList<Double>();
    private ArrayList<Double> listaApuestaEquipo2 = new ArrayList<Double>();
    private ArrayList<Double> listaApuestaEmpate = new ArrayList<Double>();
    private ArrayList<Double> listaGanancia = new ArrayList<Double>();

    public void setCounter(int counter) {
        this.counter = counter + 1;
    }

    public int getCounter() {
        return counter;
    }

    private void setNombre(JTextField textNombre) {
        nombre = textNombre.getText();
    }

    public String getNombre() {
        return nombre;
    }

    private void setNumeroCedula(JTextField textCedula) {
        numeroCedula = textCedula.getText();
    }

    public String getNumeroCedula() {
        return numeroCedula;
    }

    private void setApuestaEquipo1(JTextField apuesta1) {
        String temp = apuesta1.getText();
        apuestaEquipo1 = Double.parseDouble(temp);
    }

    public double getApuestaEquipo1() {
        return apuestaEquipo1;
    }

    private void setApuestaEquipo2(JTextField apuesta2) {
        String temp = apuesta2.getText();
        apuestaEquipo2 = Double.parseDouble(temp);
    }

    private void setApuestaEmpate(JTextField empate) {
        String temp = empate.getText();
        apuestaEmpate = Double.parseDouble(temp);
    }

    public double getApuestaEquipo2() {
        return apuestaEquipo2;
    }

    public double getApuestaEmpate() {
        return apuestaEmpate;
    }

    public ArrayList<Integer> getListaCounter() {
        return listaCounter;
    }

    public ArrayList<String> getListaNombres() {
        return listaNombres;
    }

    public ArrayList<String> getListaCedulas() {
        return listaCedulas;
    }

    public ArrayList<Double> getListaApuestaEquipo1() {
        return listaApuestaEquipo1;
    }

    public ArrayList<Double> getListaApuestaEquipo2() {
        return listaApuestaEquipo2;
    }

    public ArrayList<Double> getListaApuestaEmpate() {
        return listaApuestaEmpate;
    }

    public ArrayList<Double> getListaGanancia() {
        return listaGanancia;
    }

    public void clearJtext(JTextField nombre, JTextField cedula, JTextField apuesta1, JTextField apuesta2, JTextField empate) {
        nombre.setText("");
        cedula.setText("");
        apuesta1.setText("");
        apuesta2.setText("");
        empate.setText("");
    }

    void solicitaApuestas(JTextField nombre, JTextField cedula, JTextField apuesta1, JTextField apuesta2, JTextField empate) {

        if (nombre.getText().equals("") || cedula.getText().equals("") || apuesta1.getText().equals("") || apuesta2.getText().equals("")
                || empate.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe de completar todos los campos antes de guardar");
        } else {

            int choice = JOptionPane.showOptionDialog(null, "Desea agregar  apuesta?", "continuar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

            if (choice == JOptionPane.YES_OPTION) {

                setNombre(nombre);
                listaNombres.add(getNombre());
                setNumeroCedula(cedula);
                listaCedulas.add(getNumeroCedula());
                setApuestaEquipo1(apuesta1);
                listaApuestaEquipo1.add(getApuestaEquipo1());
                setApuestaEquipo2(apuesta2);
                listaApuestaEquipo2.add(getApuestaEquipo2());
                setApuestaEmpate(empate);
                listaApuestaEmpate.add(getApuestaEmpate());
                JOptionPane.showMessageDialog(null, "Apuesta procesada");
                clearJtext(nombre, cedula, apuesta1, apuesta2, empate);

            }
        }

    }

    public void imprimeResultados() {
        double totalPagado;
        for (int i = 0; i < listaNombres.size(); i++) {
            System.out.println();
            System.out.println("****************RESULTADO DE LAS APUESTAS POR JUGADOR # " + (i + 1) + "****************");
            System.out.println("Nombre: " + listaNombres.get(i));
            System.out.println("Cédula: " + listaCedulas.get(i));
            System.out.println("Apuesta al Equipo 1: " + listaApuestaEquipo1.get(i));
            System.out.println("Apuesta al Equipo 2: " + listaApuestaEquipo2.get(i));
            System.out.println("Apuesta al Empate: " + listaApuestaEmpate.get(i));
            totalPagado = listaApuestaEquipo1.get(i) + listaApuestaEquipo2.get(i) + listaApuestaEmpate.get(i);
            System.out.println("Total Pagado: " + totalPagado);
            System.out.println("**************************FIN DE APUESTA # " + (i + 1) + " ****************************");
            System.out.println();
        }
        System.out.println("***********************FIN RESULTADOS DE APUESTAS POR JUGADOR************************");
    }

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

}

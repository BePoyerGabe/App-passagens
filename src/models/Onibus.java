/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author berna
 */
public class Onibus {
    
    private int id;
    private Assento lugares[] = new Assento[20];
    private String companhia, motorista;
    private Viagem viagem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Assento[] getLugares() {
        return lugares;
    }
    
    //      ADICIONA NO VETOR DE ASSENTOS UM ASSENTO NA POSIÇÃO DE SEU NÚMERO, EX: Assento 5 na posição 5;

    public void setLugares(int lugar) {
        Assento a = new Assento();
        a.setNumero(lugar);
        this.lugares[lugar] = a;
        /*System.out.println(lugar);
        if (lugar <= 20) {
            Assento a = new Assento();
            a.setNumero(lugar);
            this.lugares[lugar].setNumero(a.getNumero());
        }*/
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }

    public Viagem getViagem() {
        return viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }
    
    
    
    
    
}
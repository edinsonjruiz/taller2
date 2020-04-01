package com.login.registrocoches;



import org.parceler.Parcel;

@Parcel(Parcel.Serialization.BEAN)
public class Datos {
    private String placa;
    private String marca ;
    private String modelo;
    private String radio1;


public Datos(){

}


    public Datos(String placa, String marca, String modelo, String radio1) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.radio1 = radio1;


    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() { return modelo; }

    public void setModelo(String modelo) {this.modelo = modelo; }

    public String getRadio1() { return radio1; }

    public void setRadio1(String radio1) { this.radio1 = radio1; }



    @Override
    public String toString() {
        return "Datos{" +
                "placa='" + placa + '\'' +
                ",marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}

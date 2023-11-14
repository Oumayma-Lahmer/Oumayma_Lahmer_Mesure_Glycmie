package com.example.oumayma_lahmer_mesure_glycmie.controller;
import com.example.oumayma_lahmer_mesure_glycmie.model.Patient;
public class Controller {
    //instance de la class Patient
    private static Patient patient;
    //constructeur
    public Controller(){ super();}
    public void createPatient (int age, boolean isFasting, float vm){
        patient = new Patient(age,isFasting,vm);
    }
    // cntroller > view (update)
    public String getResult(){
        return patient.getResult(); // Model > controller (update)
    }
}

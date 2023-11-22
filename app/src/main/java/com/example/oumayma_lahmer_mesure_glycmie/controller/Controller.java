package com.example.oumayma_lahmer_mesure_glycmie.controller;
import com.example.oumayma_lahmer_mesure_glycmie.model.Patient;
public final class Controller {
    //instance de la class Patient
    private static Patient patient;
    private static Controller instance = null;
    //constructeur par defaut
    private Controller(){ super();}

    //sangleton
    public final static Controller getInstance(){
        if(Controller.instance == null){
            return instance = new Controller();
        }
        return Controller.instance;
    }
    // la methode createPatient initialise le modéle par les propriétés d'un patient donné par l'utilisateur
    public void createPatient (int age, boolean isFasting, float vm){
        patient = new Patient(age,isFasting,vm);
    }
    // cntroller > view (update)
    public String getResult(){
        return patient.getResult(); // Model > controller (update)
    }
}

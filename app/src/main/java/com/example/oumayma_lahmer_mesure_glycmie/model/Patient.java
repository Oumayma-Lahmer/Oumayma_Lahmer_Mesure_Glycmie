package com.example.oumayma_lahmer_mesure_glycmie.model;

public class Patient {int age ;
    boolean isFasting;
    float valeurMesuree;
    String result;
    // constructeur
    //controller -> model (notify)


    public Patient(int age, boolean isFasting, float valeurMesuree) {
        this.age = age;
        this.isFasting = isFasting;
        this.valeurMesuree = valeurMesuree;
        calculer();
    }
    // getters

    public int getAge() {
        return age;
    }

    public boolean isFasting() {
        return isFasting;
    }

    public float getValeurMesuree() {
        return valeurMesuree;
    }

    private void calculer(){
        if(isFasting){
            if(age>=13) {
                if (valeurMesuree < 5) result="Niveau de glycèmie est bas";
                else if (valeurMesuree >= 5 && valeurMesuree <= 7.2)
                    result="Niveau de glycèmie est normale";
                else if (valeurMesuree > 7.2) result= "Niveau de glycèmie est elevée";
            } else if (age >=6 && age <= 12) {
                if(valeurMesuree< 5) result="Niveau de glycèmie est bas";
                else if (valeurMesuree>=5 && valeurMesuree<=10) result="Niveau de glycèmie est normale";
                else if(valeurMesuree >10) result="Niveau de glycèmie est elevée";
            } else if (age <6 ) {
                if(valeurMesuree< 5.5) result="Niveau de glycèmie est bas";
                else if (valeurMesuree>=5.5 && valeurMesuree<=10) result="Niveau de glycèmie est normale";
                else if(valeurMesuree >10) result="Niveau de glycèmie est elevée";
            }
        }
        else // he is not Fasting
        {
            if(valeurMesuree >10.5) result="Niveau de glycèmie est elevée";
            else result="Niveau de glycèmie est normale";
        }
    }
    //model > controller (update)
    public String getResult() {
        return result;
    }
}



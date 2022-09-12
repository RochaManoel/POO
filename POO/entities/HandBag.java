package entities;


public class HandBag {
    private double value = 0.00;
    private String validity = "";


    //Construtor
    public HandBag(){
        
    }
    
    public HandBag(double value, String validity){
        this.value = value;
        this.validity = validity;
    }

    /*--------------- Getters ---------------*/
    public double getValue(){
        return this.value;
    }

    public String getValidity(){
        return this.validity;
    }

    /*--------------- Getters ---------------*/

    public void setValue(double value){
        this.value = value;
    }

    public void setValidity(String validity){
        this.validity = validity;
    }

}

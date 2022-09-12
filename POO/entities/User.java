package entities;

import java.util.ArrayList;

public class User {
    private String name;
    private String email;
    private int cargo;
    private String password;
    private ArrayList<Project> projects = new ArrayList<>();
    private ArrayList<Activities> activities = new ArrayList<>();
    private ArrayList<HandBag> handbags = new ArrayList<>();


    /*--------------- Construtores ---------------*/
    public User (String name, String email, Integer cargo, String password){
        this.name = name;
        this.email = email;
        this.cargo = cargo;
        this.password = password;
    }

    public User(){
    }

    /*----------------- Getters -----------------*/
    public String getName(){
        return name;
    }
    
    public String getEmail(){
        return email;
    }

    public String getPassword(){
        return password;
    }

    public int getCargo(){
        return cargo;
    }

    public ArrayList<Project> getProjects(){
        return this.projects;
    }

    public ArrayList<Activities> getActivities(){
        return this.activities;
    }

    public ArrayList<HandBag> getHandBags(){
        return this.handbags;
    }

    /*----------------- Setters -----------------*/
    public void setName(String name){
        this.name = name;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setProjects(ArrayList<Project> projects){
        this.projects = projects;
    }

    public void setActivities(ArrayList<Activities> activities){
        this.activities = activities;
    }

    public void setHandBags(ArrayList<HandBag> handbags){
        this.handbags = handbags;
    }

    /*--------------- [1] - Perfil ---------------*/
    public void userShow(ArrayList<Project> projectList){
        System.out.println("\nInformações do Perfil:");
        System.out.println("Nome : " + this.name);
        System.out.println("Email : " + this.email);
        if(this.cargo == 1){System.out.println("Cargo: Aluno de Graduação");}
        else if(this.cargo == 2){System.out.println("Cargo: Aluno de Mestrado");}
        else if(this.cargo == 3){System.out.println("Cargo: Aluno de Doutorado");}
        else if(this.cargo == 4){System.out.println("Cargo: Professor");}
        else if(this.cargo == 5){System.out.println("Cargo: Pesquisador");}
        else if(this.cargo == 6){System.out.println("Cargo: Profissional - Desenvolvedor");}
        else if(this.cargo == 7){System.out.println("Cargo: Profissional - Testador");}
        else if(this.cargo == 8){System.out.println("Cargo: Profissional - Analista");}
        else if(this.cargo == 9){System.out.println("Cargo: Técnico");}
        System.out.println("Projetos:");
        for(Project pjct:projectList){
            if(pjct.getProjects(this.name)){
                System.out.println("    - "+pjct.getID());
            }
        }
        System.out.println("Atividades:");
        for(Project pjct:projectList){
            if(pjct.getProjects(this.name)){
                for(Activities act:pjct.getArrayListActivies()){
                    if(act.getActivities(this.name)){
                        System.out.println("    - [Atividades de Projeto] "+act.getIdActivity());
                    }
                }
            }
            else{
                for(Activities act:pjct.getArrayListActivies()){
                    if(act.getActivities(this.name)){
                        System.out.println("     - [Atividade de Intercâmbio] "+act.getIdActivity());
                    }
                }
            }
        }
        System.out.println("");
    }

    /*-------------- [2] - Projetos --------------*/
    public void projects(ArrayList<Project> projectList){
        System.out.println("\nProjetos:");
        for(Project pjct:projectList){
            if(pjct.getProjects(this.name)){
                System.out.println("    - "+pjct.getID());
            }
        }
        System.out.println("");
    }

    /*------------- [3] - Atividades -------------*/
    public void activities(ArrayList<Project> projectList){
        System.out.println("\nAtividades:");
        for(Project pjct:projectList){
            if(pjct.getProjects(this.name)){
                for(Activities act:pjct.getArrayListActivies()){
                    if(act.getActivities(this.name)){
                        System.out.println("    - [Atividades de Projeto] "+act.getIdActivity());
                    }
                }
            }
            else{
                for(Activities act:pjct.getArrayListActivies()){
                    if(act.getActivities(this.name)){
                        System.out.println("     - [Atividade de Intercâmbio] "+act.getIdActivity());
                    }
                }
            }
        }
        System.out.println("");
    }

    /*------------- [4] - ConfigureHandBag -------------*/
    public void addHB(Double value, String validity){
        HandBag hb = new HandBag(value, validity);
        this.handbags.add(hb);
    }

    public void timer(){
        if(this.getHandBags().isEmpty()){
            System.out.println("\nEsse usuario não possui bolsa existente.");
        }
        else{
            Double value = this.getHandBags().get(0).getValue();
            String validity = this.getHandBags().get(0).getValidity().substring(0, 4);
            System.out.println("\nO usuario "+this.name+" vai receber:\nValor: "+value+"\nData: "+validity);
        }
    }

}

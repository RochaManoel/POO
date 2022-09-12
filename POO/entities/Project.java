package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Project {
    private String id;
    private String description;
    private String dateHourStart;
    private String dateHourEnd;
    private User coordinator;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Activities> activities = new ArrayList<>();
    private String status;

    //Construtor
    public Project(){
    }

    public Project(User userOnline, ArrayList<User> userList){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o id do Projeto:");
        String id = input.nextLine();
        this.id = id;
        System.out.println("Digite a descrição do Projeto:");
        String description = input.nextLine();
        this.description = description;
        System.out.println("Digite o periodo inicial do Projeto: ex(DD/MM/AAAA HH(0 a 24))");
        String dateStart = input.nextLine();
        this.dateHourStart = dateStart;
        System.out.println("Digite o periodo final do Projeto: ex(DD/MM/AAAA HH(0 a 24))");
        String dateEnd = input.nextLine();
        this.dateHourEnd = dateEnd;
        this.coordinator = userOnline;
        System.out.println("O Coordenador é: "+this.coordinator.getName());
        this.setUsers(userList);
        this.setAct(userList);
        this.status = "Em processo de criação";
        System.out.println("Projeto criado com sucesso.");
    }

    //Other Functions
    public void setUsers(ArrayList<User> userList){
        Scanner input = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("\nDigite a Opção escolhida:\n[0] - Encerrar Lista\n[1] - Adicionar usuário");
            int option = input.nextInt();
            switch(option){
                case 0:
                    control = false;
                    break;
                case 1:
                    System.out.println("Digite o nome do usuario a adicionar:");
                    input.nextLine();
                    String name = input.nextLine();
                    User person = new User();
                    Boolean c = false;
                    for(User user:userList){
                        if(user.getName().equals(name)){
                            person = user;
                            c = true;
                            break;
                        }
                    }
                    if(c){
                        System.out.println("Digite o Valor da Bolsa");
                        double value = input.nextDouble();
                        System.out.println("Digite o Periodo de vigencia da bolsa: ex(DD/MM/AAAA HH (0 a 23))");
                        input.nextLine();
                        String validity = input.nextLine();
                        person.addHB(value, validity);
                        this.users.add(person);
                        System.out.println("\nUsuario adicionado com sucesso.\n");
                    }
                    else{
                        System.out.println("Usuario não encontrado.");
                    }
                    break;
                default:
                    System.out.println("Comando Invalido.");
                    break;
            }
        }
    }

    public void setAct(ArrayList<User> userList){
        Scanner input = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("Digite a Opção escolhida:\n[0] - Encerrar Lista\n[1] - Adicionar Atividade");
            int option = input.nextInt();
            switch(option){
                case 0:
                    control = false;
                    break;
                case 1:
                    Activities act = new Activities(userList);
                    this.activities.add(act);
                    break;
                default:
                    System.out.println("Comando Invalido.");
                    break;
            }
        }
    }

    public void queryPjct(){
        System.out.println("O projeto escolhido possui as seguintes informações");
        System.out.println("Id: "+this.getID());
        System.out.println("Descrição: "+this.getDescription());
        System.out.println("Inicio: "+this.getDateHourStart());
        System.out.println("Fim: "+this.getDateHourEnd());
        System.out.println("Coordenador: " +this.getCoordinator().getName());
        System.out.println("Lista de Integrantes:");
        int count = 1;
        for(User user:this.users){
            System.out.println("     Integrante "+count+": " + user.getName());
            count++;
        }
        int contador = 1;
        System.out.println("Lista de Atividades:");
        for(Activities act:this.activities){
            System.out.println("     Atividade "+contador+": "+ act.getIdActivity());
        }
        System.out.println("Status: " + this.status+"\n");
    }

    /*--------------- Getters ---------------*/
    public String getID(){
        return this.id;
    }

    public String getDescription(){
        return this.description;
    }

    public String getDateHourStart(){
        return this.dateHourStart;
    }

    public String getDateHourEnd(){
        return this.dateHourEnd;
    }

    public User getCoordinator(){
        return this.coordinator;
    }

    public ArrayList<User> getArrayListUsers(){
        return this.users;
    }

    public ArrayList<Activities> getArrayListActivies(){
        return this.activities;
    }

    public String getStatus(){
        return this.status;
    }
    /*--------------- Setters ---------------*/
    public void setID(String id){
        this.id = id;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setDateHourStart(String dateHourStart){
        this.dateHourStart = dateHourStart;
    }

    public void setDateHourEnd(String dateHourEnd){
        this.dateHourEnd = dateHourEnd;
    }

    public void setCoordinator(User coordinator){
        this.coordinator = coordinator;
    }

    public void setArrayListUsers(ArrayList<User> users){
        this.users = users;
    }

    public void setArrayListActivies(ArrayList<Activities> activities){
        this.activities = activities;
    }

    public void addActivities(Activities act){
        this.activities.add(act);
    }

    /*---------- Editar Projeto ----------*/
    public void editProject(ArrayList<User> userList){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite para a informação que deseja editar:\n[1] - Editar descrição\n[2] - Editar periodo inicial\n[3] - Editar periodo final\n[4] - Editar (Adicionar) usuario presentes\n[5] - Editar (Adicionar) tarefa a usuario presente");
        int option = input.nextInt();
        switch(option){
            case 1:
                System.out.println("Digite a nova descrição:");
                input.nextLine();
                String description = input.nextLine();
                this.setDescription(description);
                break;
            case 2:
                System.out.println("Digite o novo periodo Inicial: ex(DD/MM/AAAA HH (0 a 23))");
                input.nextLine();
                String dateHourStart = input.nextLine();
                this.setDateHourStart(dateHourStart);
                break;
            case 3:
                System.out.println("Digite o novo periodo Final: ex(DD/MM/AAAA HH (0 a 23))");
                input.nextLine();
                String dateHourEnd = input.nextLine();
                this.setDateHourEnd(dateHourEnd);
                break;
            case 4:
                this.setUsers(userList);
                break;
            case 5:
                this.setAct(userList);
                break;          
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }

    /*---------- Remover Usuario ----------*/
    public void removeUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do usuario");
        String name = input.nextLine();
        boolean control = false;
        for(User user : this.users){
            if(user.getName().equals(name)){
                user.setHandBags(new ArrayList<>());
                this.users.remove(user);
                control = true;
                System.out.println("Usuario removido do projeto");
                break;
            }
        }
        if(!control){
            System.out.println("Usuario não encontrado.");
        }
    }

    /*---------- Remover Atividade ----------*/
    public void removeACT(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome da atividade");
        String act = input.nextLine();
        boolean control = false;
        for(Activities ACT : this.activities){
            if(ACT.getIdActivity().equals(act)){
                this.activities.remove(ACT);
                control = true;
                System.out.println("Atividade removida do projeto");
                break;
            }
        }
        if(!control){
            System.out.println("Atividade não encontrada.");
        }
    }

    /*---------- Consultar Atividade ----------*/
    public void queryact(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome da atividade buscada:");
        String idact = input.nextLine();
        Activities act = new Activities();
        boolean control = false;
        for(Activities activities : this.activities){
            if(activities.getIdActivity().equals(idact)){
                control = true;
                act = activities;
                break;
            }
        }
        if(control){
            System.out.println("Atividade encontrada. Digite a opção escolhida:\n[0] - Retornar\n[1] - Mais informações");
            int option = input.nextInt();
            if(option == 1){
                act.infActivies();
            }
        }
        else{
            System.out.println("Atividade não encontrada.");
        }
    }

    /*---------- Alterar Status ----------*/
    public void status(){
        Scanner input = new Scanner(System.in);
        System.out.println("Atual status: "+ this.status);
        if(this.status == "Em processo de criação"){
            System.out.println("Alterar para Iniciado?\nDigite [1] - Sim\nDigite [2] - Não");
            int option = input.nextInt();
            if(option==1){
                this.status = "Iniciado";
                System.out.println("Alteração concluida com sucesso.");
            }
            else if(option == 2){
                System.out.println("Ok, coordenador.");
            }
            else{
                System.out.println("Comando Invalido.");
            }
        }
        else if(this.status == "Iniciado"){
            System.out.println("Alterar para Em andamento?\nDigite [1] - Sim\nDigite [2] - Não");
            int option = input.nextInt();
            if(option==1){
                this.status = "Em andamento";
                System.out.println("Alteração concluida com sucesso.");
            }
            else if(option == 2){
                System.out.println("Ok, coordenador.");
            }
            else{
                System.out.println("Comando Invalido.");
            }
        }
        else if(this.status == "Em andamento" && this.activities.size()>0){
            System.out.println("Alterar para Concluído?\nDigite [1] - Sim\nDigite [2] - Não");
            int option = input.nextInt();
            if(option==1){
                this.status = "Concluído";
                System.out.println("Alteração concluida com sucesso.");
            }
            else if(option == 2){
                System.out.println("Ok, coordenador.");
            }
            else{
                System.out.println("Comando Invalido.");
            }
        }
        else if(this.status == "Em andamento" && this.activities.size() < 1){
            System.out.println("Requisitos não cumpridos, atividades vazias");
        }
    }

    /*---------- Configure Projects ----------*/
    public void addUserProject(User person){
        this.users.add(person);
    }

    public boolean getProjects(String name){
        boolean control = false;
        for(User user:this.users){
            if(user.getName().equals(name)){
                control = true;
            }
        }

        return control;
    }



}

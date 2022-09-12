package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Activities {
    private String idActivity;
    private String descriptionActivity;
    private String dateHourStart;
    private String dateHourEnd;
    private User responsible;
    private ArrayList<User> users = new ArrayList<>();
    private ArrayList<Job> jobs = new ArrayList<>();
    
    //Construtor
    public Activities(){

    }

    public Activities(ArrayList<User> userList){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o id da atividade:");
        String idActivity = input.nextLine();
        this.idActivity = idActivity;
        System.out.println("Digite a descrição da atividade:");
        String description = input.nextLine();
        this.descriptionActivity = description;
        System.out.println("Digite o periodo inicial da atividade: ex(DD/MM/AAAA HH(0 a 24))");
        String dateStart = input.nextLine();
        this.dateHourStart = dateStart;
        System.out.println("Digite o periodo final da atividade: ex(DD/MM/AAAA HH(0 a 24))");
        String dateEnd = input.nextLine();
        this.dateHourEnd = dateEnd;
        System.out.println("Digite o administrador da atividade:");
        String name = input.nextLine();
        User person = new User();
        int control = 0;
        for(User user:userList){
            if(user.getName().equals(name)){
                person = user;
                control = 1;
                break;
            }
        }
        switch(control){
            case 0:
                System.out.println("Usuario não encontrado.");
                break;
            case 1:
                this.responsible = person;
                System.out.println("Adicionado com sucesso.");
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
        setGroup(userList);
        System.out.println("Atividade adicionada com sucesso.");
    }

    //Other Functions
    private void setGroup(ArrayList<User> userList){
        Scanner input = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("Digite a Opção escolhida:\n[0] - Encerrar Lista\n[1] - Adicionar usuário");
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
                        this.users.add(person);
                        ArrayList<String> jo = new ArrayList<>();
                        Boolean t = true;
                        while(t){
                            System.out.println("Digite a opção escolhida:\n[0] - Encerrar Lista de tarefas\n[1] - Adicionar tarefa");
                            int aux = input.nextInt();
                            if(aux == 0){
                                t = false;
                            }
                            else if(aux ==1){
                                System.out.println("Digite a tarefa:");
                                input.nextLine();
                                String tarefa = input.nextLine();
                                jo.add(tarefa);
                            }
                            else{
                                System.out.println("Comando Invalido.");
                            }
                        }
                        Job j = new Job(person, jo);
                        this.jobs.add(j);
                        System.out.println("Usuario adicionado com sucesso.");
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

    public void infActivies(){
        System.out.println("A atividade escolhida possui as seguintes informações");
        System.out.println("Id: "+this.getIdActivity());
        System.out.println("Descrição: "+this.getDescriptionAcitivity());
        System.out.println("Inicio: "+this.getDateHourStart());
        System.out.println("Fim: "+this.getDateHourEnd());
        System.out.println("Responsável: " +this.getResponsible().getName());
        int count = 1;
        for(User user:this.users){
            System.out.println("     Integrante "+count+": " + user.getName());
            for(Job j:this.jobs){
                if(j.getUser() == user){
                    int contador = 0;
                    for(String t:j.getJobs()){
                        System.out.println("          Tarefa "+contador+" - " + t);
                        contador++;
                    }
                    break;
                }
            }
            count++;
        }
    }

    /*---------- Getters ----------*/
    public String getIdActivity(){
        return this.idActivity;
    }

    public String getDescriptionAcitivity(){
        return this.descriptionActivity;
    }

    public String getDateHourStart(){
        return this.dateHourStart;
    }

    public String getDateHourEnd(){
        return this.dateHourEnd;
    }

    public User getResponsible(){
        return this.responsible;
    }

    public ArrayList<User> getUsers(){
        return this.users;
    }

    public ArrayList<Job> getJobs(){
        return this.jobs;
    }

    /*---------- Setters ----------*/
    public void setIdActivity(String idActivity){
        this.idActivity = idActivity;
    }

    public void setDescriptionActivity(String descriptionActivity){
        this.descriptionActivity = descriptionActivity;
    }

    public void setDateHourStart(String dateHourStart){
        this.dateHourStart = dateHourStart;
    }

    public void setDateHourEnd(String dateHourEnd){
        this.dateHourEnd = dateHourEnd;
    }

    public void setResponsible(User responsible){
        this.responsible = responsible;
    }

    public void setUsers(ArrayList<User> users){
        this.users = users;
    }

    public void setJobs(ArrayList<Job> jobs){
        this.jobs = jobs;
    }

    /*---------- Remove ----------*/

    public void removeINF(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite para a informação que deseja remover:\n[1] - Remover usuario\n[2] - Remover tarefa");
        int option = input.nextInt();
        switch(option){
            case 1:
                System.out.println("Digite o nome do usuario:");
                input.nextLine();
                String name = input.nextLine();
                boolean control = false;
                User person = new User();
                for(User user: this.users){
                    if(user.getName().equals(name)){
                        person = user;
                        control = true;
                        break;
                    }
                }
                if(control){
                    this.users.remove(person);
                    System.out.println("Usuario removido com sucesso.");
                }
                else{
                    System.out.println("Usuario não encontrado.");
                }
                break;
            case 2:
                System.out.println("Digite o nome do usuario:");
                input.nextLine();
                String n = input.nextLine();
                boolean c = false;
                User p = new User();
                for(User user: this.users){
                    if(user.getName().equals(n)){
                        p = user;
                        c = true;
                        break;
                    }
                }
                if(c){
                    System.out.println("Digite a tarefa a ser removida:");
                    String task = input.nextLine();
                    for(Job j:this.jobs){
                        if(j.getUser() == p){
                            for(String str: j.getJobs()){
                                if(str == task){
                                    j.getJobs().remove(str);
                                    System.out.println("Tarefa removida com sucesso");
                                }
                            }
                        }
                    }
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

    /*---------- Edit ----------*/
    public void editINF(ArrayList<User> userList){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite para a informação que deseja editar:\n[1] - Editar descrição\n[2] - Editar periodo inicial\n[3] - Editar periodo final\n[4] - Editar (Adicionar) usuario presentes\n[5] - Editar tarefa a usuario presente");
        int option = input.nextInt();
        switch(option){
            case 1:
                System.out.println("Digite a nova descrição:");
                input.nextLine();
                String description = input.nextLine();
                this.setDescriptionActivity(description);
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
                    this.users.add(person);
                    ArrayList<String> jo = new ArrayList<>();
                    Boolean t = true;
                    while(t){
                        System.out.println("Digite a opção escolhida:\n[0] - Encerrar Lista de tarefas\n[1] - Adicionar tarefa");
                        int aux = input.nextInt();
                        if(aux == 0){
                            t = false;
                        }
                        else if(aux ==1){
                            System.out.println("Digite a tarefa:");
                            input.nextLine();
                            String tarefa = input.nextLine();
                            jo.add(tarefa);
                        }
                        else{
                            System.out.println("Comando Invalido.");
                        }
                    }
                    Job j = new Job(person, jo);
                    this.jobs.add(j);
                    System.out.println("Usuario adicionado com sucesso.");
                }
                else{
                    System.out.println("Usuario não encontrado.");
                }
                break;
            case 5:
                System.out.println("Digite o nome do usuario:");
                input.nextLine();
                String n = input.nextLine();
                boolean cc = false;
                User p = new User();
                for(User user: this.users){
                    if(user.getName().equals(n)){
                        p = user;
                        cc = true;
                        break;
                    }
                }
                if(cc){
                    Job WORK = new Job();
                    ArrayList<String> work = new ArrayList<>();
                    for(Job jobs:this.jobs){
                        if(jobs.getUser() == p){
                            WORK = jobs;
                            work = jobs.getJobs();
                            this.jobs.remove(jobs);
                        }
                    }
                    Boolean tt = true;
                    while(tt){
                        System.out.println("Digite a opção escolhida:\n[0] - Encerrar Lista de tarefas\n[1] - Adicionar tarefa");
                        int a = input.nextInt();
                        if(a == 0){
                            tt = false;
                        }
                        else if(a ==1){
                            System.out.println("Digite a tarefa:");
                            input.nextLine();
                            String tarefa = input.nextLine();
                            work.add(tarefa);
                        }
                        else{
                            System.out.println("Comando Invalido.");
                        }
                    }
                    WORK.setJobs(work);
                    this.jobs.add(WORK);
                    System.out.println("Tarefas editadas com sucesso.");
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

    /*---------- SetAct ----------*/
    public void addUserAct(User person){
        this.users.add(person);
    }

    /*---------- GetAct ----------*/
    public boolean getActivities(String name){
        boolean control = false;
        for(User user:this.users){
            if(user.getName().equals(name)){
                control = true;
            }
        }

        return control;
    }


}

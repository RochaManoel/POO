package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class Login {
    public ArrayList<User> userList = new ArrayList<User>();
    public ArrayList<Project> projectList = new ArrayList<Project>();
    public ArrayList<Activities> activitiesList = new ArrayList<Activities>();
    public User userOnline = new User();
    public User userEvalueate = new User();
    public User userAdd = new User();

    public Login(){
        this.runLogin();
    }
    // --- Template ONE
    private void runLogin(){
        Scanner input = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("\nDigite a Opção escolhida:\n[0] - Fechar o Programa\n[1] - Criar Usuário\n[2] - Iniciar Login\n[3] - Recuperar Senha");
            int option = input.nextInt();
            switch(option){
                case 0:
                    control = false;
                    break;
                case 1:
                    create();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    recoverPassword();
                    break;
                default:
                    System.out.print("Comando Invalido.");
                    break;
            }
        }
    }

    // --- --- Template TWO
    private void create(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nDigite o nome de cadastro do Novo usuário:");
        String name = sc.nextLine();
        System.out.println("Digite o email de cadastro do Novo usuário:");
        String email = sc.nextLine();
        System.out.println("Digite o cargo de cadastro do Novo usuário:");
        System.out.println("[1] - Aluno de Graduação");
        System.out.println("[2] - Aluno de Mestrado");
        System.out.println("[3] - Aluno de Doutorado");
        System.out.println("[4] - Professor");
        System.out.println("[5] - Pesquisador");
        System.out.println("[6] - Profissional - Desenvolvedor");
        System.out.println("[7] - Profissional - Testador");
        System.out.println("[8] - Profissional - Analista");
        System.out.println("[9] - Técnico");
        int cargo = sc.nextInt();
        System.out.println("Digite a senha de cadastro do Novo usuário:");
        sc.nextLine();
        String password = sc.nextLine();
        User newUser = new User(name,email,cargo,password);
        userList.add(newUser);
        System.out.println("Usuario "+newUser.getName()+" adicionado com Sucesso.");
    }

    private void loginUser(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o email para login:");
        String email = input.nextLine();
        System.out.println("Digite a senha para login:");
        String password = input.nextLine();
        int control = 0;
        for(User user : userList){
            if(userList.isEmpty()){
                control = 1;
            }
            else{
                if(user.getEmail().equals(email) && user.getPassword().equals(password)){
                    userOnline = user;
                    control = 2;
                    break;
                }
            }
        }
        switch(control){
            case 0:
                System.out.println("Usuario invalido.");
                break;
            case 1:
                System.out.println("Usuarios não cadastrados.");
                break;
            case 2:
                if(userOnline.getCargo() == 4 || userOnline.getCargo() == 5){
                    menuADM();
                }
                else{
                    menuGeneral();
                }
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }

    private void recoverPassword(){
        Scanner input = new Scanner(System.in);
        System.out.println("\nDigite o email para recuperação da senha:");
        String email = input.nextLine();
        User userFound = new User();
        int control = 0;
        for(User user : userList){
            if(userList.isEmpty()){
                control = 1;
            }
            else{
                if(user.getEmail().equals(email)){
                    userFound = user;
                    control = 2;
                    break;
                }
            }
        }
        switch(control){
            case 0:
                System.out.println("Usuario invalido.");
                break;
            case 1:
                System.out.println("Usuarios não cadastrados.");
                break;
            case 2:
                System.out.println("Digite a nova senha:");
                String password = input.nextLine();
                userFound.setPassword(password);
                System.out.println("Senha alterada com sucesso.");
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }

    }

    // --- --- --- Template TREE
    private void menuGeneral(){
        Scanner input = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("Digite a Opção escolhida:\n[0] - Encerrar seção\n[1] - Perfil\n[2] - Projetos\n[3] - Atividades\n[4] - Área de Relatórios");
            int option = input.nextInt();
            switch(option){
                case 0:
                    control = false;
                    break;
                case 1:
                    profile();  
                    break;
                case 2:
                    userProjects();  
                    break;
                case 3:
                    userActivities();   
                    break;
                case 4:
                    userReports();      
                    break;
                default:
                    System.out.println("Comando Invalido.");
                    break;
            }
        }
    }

    private void menuADM(){
        Scanner input = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("Digite a Opção escolhida:\n[0] - Encerrar seção\n[1] - Perfil\n[2] - Projetos\n[3] - Atividades\n[4] - Área de Relatórios\n[5] - Área de Usuarios\n[6] - Área de Projetos\n[7] - Área de Atividades");
            int option = input.nextInt();
            switch(option){
                case 0:
                    control = false;
                    break;
                case 1:
                    profile();   
                    break;
                case 2:
                    userProjects();    
                    break;
                case 3:
                    userActivities();    
                    break;
                case 4:
                    userReports();      
                    break;
                case 5:
                    admUsers();      
                    break;
                case 6:
                    admProjects();     
                    break;
                case 7:
                    admActivities();
                    break;
                default:
                    System.out.println("Comando Invalido.");
                    break;
            }
        }
    }

    // --- --- --- --- Funções dos Menus e suas Áreas
    /*
        [1] - Perfil
            => Mostrar informações;
            => Editar informações pessoais;
        [2] - Projetos
            => Mostrar Projeto que o usuario participa;
        [3] - Atividades 
            => Mostrar Atividades que o usuario participa;
                    - Atividades do seu Projeto;
                    - Atividades de intercambio;
        [4] - Área de Relatórios
            => Relatório Geral de Projetos;
            => Relatório Geral de Atividades;
            => Relatório de Projeto;
        [5] - Área de Usuário
            => Consultar Determinado Usuário;
            => Gerenciamento das bolsas;
        [6] - Área de Projetos
            => Criar Projetos (Todas as informações básicas);
            => Remover informações do Projeto (Todas as informações básicas das básicas);
            => Editar informações do Projeto (Todas as informações básicas das básicas);
            => Alterar Status do Projeto pelo usuario coordenador;
            => Consultar Determinado Projeto;
        [7] - Área de Atividades
            => Criar Atividades (Todas as informações básicas);
            => Remover informações da Atividade (Todas as informações básicas das básicas);
            => Editar informações da Atividade (Todas as informações básicas das básicas);
            => Consultar Determinada Atividade;
    */

    /* _______________ Perfil _______________ */
    private void profile(){
        Scanner input = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("Digite a Opção escolhida:\n[0] - Retornar ao Menu Principal\n[1] - Visualizar informações Pessoais\n[2] - Editar informações Pessoais");
            int option = input.nextInt();
            switch(option){
                case 0:
                    control = false;
                    break;
                case 1:
                    userOnline.userShow(projectList);
                    break;
                case 2:
                    userEdit();
                    break;
                default:
                    System.out.println("Comando Invalido.");
                    break;
            }
        }
    }

    public void userEdit(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a Opção escolhida:\n[1] - Editar Email\n[2] - Editar Senha");
        int option = input.nextInt();
        switch(option){
            case 1:
                System.out.println("Digite o novo email:");
                input.nextLine();
                String email = input.nextLine();
                userOnline.setEmail(email);
                System.out.println("Email alterado com sucesso.");
                break;
            case 2:
                System.out.println("Digite a nova senha:");
                input.nextLine();
                String password = input.nextLine();
                userOnline.setPassword(password);
                System.out.println("Senha alterada com sucesso.");
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }

    /* ______________ Projetos ______________ */
    private void userProjects(){
        userOnline.projects(projectList);
    }

    /* _____________ Atividades _____________ */
    private void userActivities(){
        userOnline.activities(projectList);
    }

    /* _________ Área de Relatórios _________ */
    private void userReports(){
        Scanner input = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("Digite a Opção escolhida:\n[0] - Retornar ao Menu Principal\n[1] - Relatório de Projetos\n[2] - Relatório de Atividades\n[3] - Relatório de Projetos");
            int option = input.nextInt();
            switch(option){
                case 0:
                    control = false;
                    break;
                case 1:
                    System.out.println("\nRelatório de Projetos");
                    System.out.println("Quantidade de Projetos na Unidade Acadêmica: "+projectList.size());
                    int cont1 = 0;int cont2 = 0; int cont3 = 0; int cont4 = 0;
                    for(Project pjct:projectList){
                        if(pjct.getStatus() == "Em processo de criação"){
                            cont1++;
                        }
                        else if(pjct.getStatus() == "Iniciado"){
                            cont2++;
                        }
                        else if(pjct.getStatus() == "Em andamento"){
                            cont3++;
                        }
                        else if(pjct.getStatus() == "Concluído"){
                            cont4++;
                        }
                    }
                    System.out.println("     Em processo de criação: "+cont1+"\n     Iniciado: "+cont2+"\n     Em andamento: "+cont3+"\n     Concluído: "+cont4+"\n");
                    break;
                case 2:
                    System.out.println("\nRelatório de Atividades");
                    int contador = 0;
                    for(Project pjct:projectList){
                        contador += pjct.getArrayListActivies().size();
                    }
                    System.out.println("Quantidade de Atividades na Unidade Acadêmica: "+contador+"\n");
                    break;
                case 3:
                    System.out.println("Informe o Projeto procurado:");
                    input.nextLine();
                    String idProject = input.nextLine();
                    int c = 0;
                    Project PROJECT = new Project();
                    for(Project project : projectList){
                        if(projectList.isEmpty()){
                            c = 1;
                        }
                        if(project.getID().equals(idProject)){
                            PROJECT = project;
                            c = 2;
                        }
                    }
                    if(c == 0){
                        System.out.println("Projeto não encontrado.");
                    }
                    else if(c==1){
                        System.out.println("Não existe projetos cadastrados.");
                    }
                    else if(c==2){
                        PROJECT.queryPjct();
                    }
                    break;
                default:
                    System.out.println("Comando Invalido.");
                    break;
            }
        }
    }

    /* __________ Área de Usuário __________ */
    private void admUsers(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do usuario:");
        String name = input.nextLine();
        User person = new User();
        boolean c = false;
        for(User user:userList){
            if(user.getName().equals(name)){
                person = user;
                c = true;
                break;
            }
        }
        if(c){
            boolean control = true;
            while(control){
                System.out.println("Digite a Opção escolhida:\n[0] - Retornar ao Menu Principal\n[1] - Consulta por Usuários\n[2] - Gerenciamento da Bolsa");
                int option = input.nextInt();
                switch(option){
                    case 0:
                        control = false;
                        break;
                    case 1:
                        person.userShow(projectList);
                        break;
                    case 2:
                        person.timer();
                        break;
                    default:
                        System.out.println("Comando Invalido.");
                        break;
                }
            }
        }
        else{
            System.out.println("Usuario não encontrado.");
        }
    }
  
    /* __________ Área de Projetos __________ */
    private void admProjects(){
        Scanner input = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("Digite a Opção escolhida:\n[0] - Retornar ao Menu Principal\n[1] - Criar Projeto\n[2] - Remover Informações de Projeto\n[3] - Editar Informações de Projeto\n[4] - Alterar Status de Projeto\n[5] - Consulta de Projetos");
            int option = input.nextInt();
            switch(option){
                case 0:
                    control = false;
                    break;
                case 1:
                    Project project = new Project(userOnline,userList);     
                    projectList.add(project);
                    break;
                case 2:
                    removeProject();    
                    break;
                case 3:
                    editProject();   
                    break;
                case 4:
                    editStatus();    
                    break;
                case 5:
                    queryProjects();    
                    break;
                default:
                    System.out.println("Comando Invalido.");
                    break;
            }
        }
    }

    private void removeProject(){
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a Opção escolhida:\n[1] - Remover usuario do projeto\n[2] - Remover atividade do projeto");
        int option = input.nextInt();
        switch(option){
            case 1:
                System.out.println("Informe o Projeto para remover:");
                input.nextLine();
                String idProject = input.nextLine();
                int control = 0;
                Project PROJECT = new Project();
                for(Project project : projectList){
                    if(projectList.isEmpty()){
                        control = 1;
                    }
                    if(project.getID().equals(idProject)){
                        PROJECT = project;
                        control = 2;
                    
                    }
                }
                if(control == 0){
                    System.out.println("Dados Invalidos");
                }
                else if(control == 1){
                    System.out.println("Não existe Projetos criados");
                }
                else if(control ==2){
                    if(userOnline == PROJECT.getCoordinator()){
                        PROJECT.removeUser();
                    }
                    else{
                        System.out.println("Você não é Coordenador deste Projeto, ou seja, não pode criar atividades desse projeto.");
                    }
                }
                else{
                    System.out.println("Comando Invalido.");
                }
                break;
            case 2:
                System.out.println("Informe o Projeto para remover:");
                input.nextLine();
                String id = input.nextLine();
                int c = 0;
                Project PJCT = new Project();
                for(Project project : projectList){
                    if(projectList.isEmpty()){
                        c = 1;
                    }
                    if(project.getID().equals(id)){
                        PJCT = project;
                        c = 2;
                    
                    }
                }
                if(c==0){
                    System.out.println("Dados Invalidos");
                }
                else if(c==1){
                    System.out.println("Não existe Projetos criados");
                }
                else if(c==2){
                    if(userOnline == PJCT.getCoordinator()){
                        PJCT.removeACT();
                    }
                    else{
                        System.out.println("Você não é Coordenador deste Projeto, ou seja, não pode criar atividades desse projeto.");
                    }
                }
                else{
                    System.out.println("Comando Invalido.");
                }
                break;
            default:
                System.out.println("Comando Invalido");
                break;
        }
    }
  
    private void editProject(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o Projeto para adicionar informações:");
        String idProject = input.nextLine();
        int control = 0;
        Project PROJECT = new Project();
        for(Project project : projectList){
            if(projectList.isEmpty()){
                control = 1;
            }
            if(project.getID().equals(idProject)){
                PROJECT = project;
                control = 2;

            }
        }
        switch(control){
            case 0:
                System.out.println("Dados Invalidos");
                break;
            case 1:
                System.out.println("Não existe Projetos criados");
                break;
            case 2:
                if(userOnline == PROJECT.getCoordinator()){
                    PROJECT.editProject(userList);
                }
                else{
                    System.out.println("Você não é Coordenador deste Projeto, ou seja, não pode criar atividades desse projeto.");
                }
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }

    private void editStatus(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o Projeto para adicionar:");
        String idProject = input.nextLine();
        int control = 0;
        Project PROJECT = new Project();
        for(Project project : projectList){
            if(projectList.isEmpty()){
                control = 1;
            }
            if(project.getID().equals(idProject)){
                PROJECT = project;
                control = 2;

            }
        }
        switch(control){
            case 0:
                System.out.println("Dados Invalidos");
                break;
            case 1:
                System.out.println("Não existe Projetos criados");
                break;
            case 2:
                if(userOnline == PROJECT.getCoordinator()){
                    PROJECT.status();
                    System.out.println("Status do Projeto alterado com sucesso.");
                }
                else{
                    System.out.println("Você não é Coordenador deste Projeto, ou seja, não pode criar atividades desse projeto.");
                }
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }

    private void queryProjects(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o Projeto procurado:");
        String idProject = input.nextLine();
        int control = 0;
        Project PROJECT = new Project();
        for(Project project : projectList){
            if(projectList.isEmpty()){
                control = 1;
            }
            if(project.getID().equals(idProject)){
                PROJECT = project;
                control = 2;

            }
        }
        switch(control){
            case 0:
                System.out.println("Dados Invalidos");
                break;
            case 1:
                System.out.println("Não existe Projetos criados");
                break;
            case 2:
                if(userOnline == PROJECT.getCoordinator()){
                    PROJECT.queryPjct();
                }
                else{
                    System.out.println("Você não é Coordenador deste Projeto, ou seja, não pode criar atividades desse projeto.");
                }
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }

    /* _________ Área de Atividades _________ */
    private void admActivities(){
        Scanner input = new Scanner(System.in);
        boolean control = true;
        while(control){
            System.out.println("Digite a Opção escolhida:\n[0] - Retornar ao Menu Principal\n[1] - Criar Atividade\n[2] - Remover Informações de Atividades\n[3] - Editar Informações de Atividades\n[4] - Consulta por Atividades");
            int option = input.nextInt();
            switch(option){
                case 0:
                    control = false;
                    break;
                case 1:
                    createActivity();      
                    break;
                case 2:
                    removeActivity();      
                    break;
                case 3:
                    editActivity();
                    break;
                case 4:
                    queryActivity();
                    break;
                default:
                    System.out.println("Comando Invalido.");
                    break;
            }
        }
    }

    private void createActivity(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o Projeto para adicionar:");
        String idProject = input.nextLine();
        int control = 0;
        Project PROJECT = new Project();
        for(Project project : projectList){
            if(projectList.isEmpty()){
                control = 1;
            }
            if(project.getID().equals(idProject)){
                PROJECT = project;
                control = 2;

            }
        }
        switch(control){
            case 0:
                System.out.println("Dados Invalidos");
                break;
            case 1:
                System.out.println("Não existe Projetos criados");
                break;
            case 2:
                if(userOnline == PROJECT.getCoordinator()){
                    Activities act = new Activities(userList);
                    PROJECT.addActivities(act);
                }
                else{
                    System.out.println("Você não é Coordenador deste Projeto, ou seja, não pode criar atividades desse projeto");
                }
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }

    private void removeActivity(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o Projeto para adicionar:");
        String idProject = input.nextLine();
        int control = 0;
        Project PROJECT = new Project();
        for(Project project : projectList){
            if(projectList.isEmpty()){
                control = 1;
            }
            if(project.getID().equals(idProject)){
                PROJECT = project;
                control = 2;

            }
        }
        switch(control){
            case 0:
                System.out.println("Dados Invalidos");
                break;
            case 1:
                System.out.println("Não existe Projetos criados");
                break;
            case 2:
                System.out.println("Digite o nome da atividade a se modificar:");
                String idAct = input.nextLine();
                Activities act = new Activities();
                boolean c = false;
                for(Activities activities : PROJECT.getArrayListActivies()){
                    if(activities.getIdActivity().equals(idAct)){
                        act = activities;
                        c = true;
                        break;
                    }
                }
                if(c){
                    if(userOnline == PROJECT.getCoordinator()){
                        act.removeINF();
                    }
                    else{
                        System.out.println("Você não é coordenador do Projeto");
                    }
                }
                else{
                    System.out.println("Atividade não encontrada.");
                }
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }

    private void editActivity(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o Projeto para adicionar:");
        String idProject = input.nextLine();
        int control = 0;
        Project PROJECT = new Project();
        for(Project project : projectList){
            if(projectList.isEmpty()){
                control = 1;
            }
            if(project.getID().equals(idProject)){
                PROJECT = project;
                control = 2;

            }
        }
        switch(control){
            case 0:
                System.out.println("Dados Invalidos");
                break;
            case 1:
                System.out.println("Não existe Projetos criados");
                break;
            case 2:
                System.out.println("Digite o nome da atividade a se editar:");
                String idAct = input.nextLine();
                Activities act = new Activities();
                boolean c = false;
                for(Activities activities : PROJECT.getArrayListActivies()){
                    if(activities.getIdActivity().equals(idAct)){
                        act = activities;
                        c = true;
                        break;
                    }
                }
                if(c){
                    if(userOnline == PROJECT.getCoordinator()){
                        act.editINF(userList);
                    }
                    else{
                        System.out.println("Você não é coordenador do Projeto");
                    }
                }
                else{
                    System.out.println("Atividade não encontrada.");
                }
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }

    private void queryActivity(){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o Projeto para adicionar:");
        String idProject = input.nextLine();
        int control = 0;
        Project PROJECT = new Project();
        for(Project project : projectList){
            if(projectList.isEmpty()){
                control = 1;
            }
            if(project.getID().equals(idProject)){
                PROJECT = project;
                control = 2;

            }
        }
        switch(control){
            case 0:
                System.out.println("Dados Invalidos");
                break;
            case 1:
                System.out.println("Não existe Projetos criados");
                break;
            case 2:
                if(userOnline == PROJECT.getCoordinator()){
                    PROJECT.queryact();
                }
                else{
                    System.out.println("Você não é Coordenador deste Projeto, ou seja, não pode criar atividades desse projeto");
                }
                break;
            default:
                System.out.println("Comando Invalido.");
                break;
        }
    }

}

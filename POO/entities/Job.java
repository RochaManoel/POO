package entities;

import java.util.ArrayList;

public class Job {
    private User user = new User();
    private ArrayList<String> jobs = new ArrayList<>();

    //Construtor
    public Job(User user, ArrayList<String> jobs){
        this.user = user;
        this.jobs = jobs;
    }

    public Job(){
    }


    /*---------- Getters ----------*/
    public User getUser(){
        return this.user;
    };

    public ArrayList<String> getJobs(){
        return this.jobs;
    }

    /*---------- Setters ----------*/
    public void setUser(User user){
        this.user = user;
    }

    public void setJobs(ArrayList<String> jobs){
        this.jobs = jobs;
    }

}

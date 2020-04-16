package com.hy.crmsystem.entity.systemManager;

import java.util.ArrayList;

public class FourObject {


    private ArrayList<String> money;
    private ArrayList<String> users;
    private ArrayList<String> contracts;
    private ArrayList<String> bussiness;
    private ArrayList<String> customers;

    public ArrayList<String> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<String> customers) {
        this.customers = customers;
    }

    public ArrayList<String> getMoney() {
        return money;
    }

    public void setMoney(ArrayList<String> money) {
        this.money = money;
    }

    public ArrayList<String> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<String> users) {
        this.users = users;
    }

    public ArrayList<String> getContracts() {
        return contracts;
    }

    public void setContracts(ArrayList<String> contracts) {
        this.contracts = contracts;
    }

    public ArrayList<String> getBussiness() {
        return bussiness;
    }

    public void setBussiness(ArrayList<String> bussiness) {
        this.bussiness = bussiness;
    }
}

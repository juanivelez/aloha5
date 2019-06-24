package com.salesforce.solution.actions;

public class UnknownCommandAction implements Action {

    public void execute(String[] params) {
        System.out.println("Unrecognize command");
    }

}
package com.salesforce.solution.actions;

public class PwdAction implements Action{

    public void execute(String[] params) {
      System.out.println(System.getProperty("user.dir"));
    }

}
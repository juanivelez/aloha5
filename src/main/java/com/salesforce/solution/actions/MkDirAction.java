package com.salesforce.solution.actions;

import java.io.File;

public class MkDirAction implements Action {

    public void execute(String[] params) {
        try {
            File directory = new File(params[1]);
            if (!directory.exists()){
                directory.mkdir();
            }else {
                System.out.println("Directory already exists");
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Wrong parameters");
        }
    }
}
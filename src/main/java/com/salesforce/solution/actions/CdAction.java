package com.salesforce.solution.actions;

import java.io.File;

public class CdAction implements Action {

    private static String PARENT_SYMBOL = "..";

    public void execute(String[] params) {
        try {
            String directory;
            if (PARENT_SYMBOL.equals(params[1])) {
                File file = new File(System.getProperty("user.dir"));
                directory = file.getParentFile().getName();
            }else{
                directory = params[1];
            }
            System.setProperty("user.dir", directory);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Wrong parameters");
        }
    }
}
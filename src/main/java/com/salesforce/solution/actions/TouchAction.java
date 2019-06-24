package com.salesforce.solution.actions;

import java.io.File;
import java.io.IOException;

public class TouchAction implements Action{

    public void execute(String[] params) {
        try{
            File file = new File(params[1]);
            file.createNewFile();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Wrong parameters");
        } catch (IOException e) {
            System.out.println("Creation ERROR");
        }
    }
}
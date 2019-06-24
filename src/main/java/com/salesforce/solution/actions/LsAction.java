package com.salesforce.solution.actions;

import java.io.File;

public class LsAction implements Action {

  private Boolean isRecursive = false;
  private static String RECURSIVE_SIMBOL = "-r";

  public void execute(String[] params){
    File file = new File(System.getProperty("user.dir"));
    if(params.length > 1 && RECURSIVE_SIMBOL.equals(params[params.length-1]))
      isRecursive = true;
    search(file);
  }

  private void search(File f){
    for (File file : f.listFiles()) {
      if (file.isDirectory()) {
        System.out.println(file.getName());
        if(isRecursive)
          search(file);
      }
      if (file.isFile()) {
        System.out.println(file.getName());
      }
    }
  }

}
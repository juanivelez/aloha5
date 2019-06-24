package com.salesforce.solution;

import com.salesforce.solution.actions.*;

import java.util.HashMap;

public class Solution{

    private static Solution instance;

    private HashMap<String, Action> commands;
    private Boolean isOver;

    public Solution(){
      isOver = false;
      commands = new HashMap<String, Action>();
      commands.put("quit", new QuitAction());
      commands.put("pwd", new PwdAction());
      commands.put("ls", new LsAction());
      commands.put("mkdir", new MkDirAction());
      commands.put("cd", new CdAction());
      commands.put("touch", new TouchAction());
    }

    public static Solution getInstance(){
        if (instance == null)
            instance = new Solution();
        return instance;
    }

    public Action getAction(String command){
        Action action = commands.get(command);
        return (action == null)? new UnknownCommandAction(): action ;
    }

    public Boolean isOver(){
      return isOver;
    }

    public void setOver(Boolean value){
      isOver = value;
    }

}
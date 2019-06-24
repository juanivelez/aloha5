package com.salesforce.solution.actions;

import com.salesforce.solution.Solution;

public class QuitAction implements Action{

    public void execute(String[] params) {
        Solution solution = Solution.getInstance();
        solution.setOver(true);
    }
}
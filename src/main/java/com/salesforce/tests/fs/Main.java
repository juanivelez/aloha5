package com.salesforce.tests.fs;

import com.salesforce.solution.actions.Action;
import com.salesforce.solution.Solution;

import java.util.Scanner;

/**
 * The entry point for the Test program
 */
public class Main {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner sc = new Scanner(System.in);
        Solution solution = Solution.getInstance();
        while (!solution.isOver()){
            String command = sc.nextLine();
            String[] params = command.split(" ");
            Action action = solution.getAction(params[0]);
            action.execute(params);
        }
    }

}

package com.salesforce.tests.fs;

import com.salesforce.solution.Solution;
import com.salesforce.solution.actions.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

/**
 * Place holder for your unit tests
 */
public class YourUnitTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    
    @Test
    public void getActions(){
        Solution solution = new Solution();
        // getActions with commands
        assert solution.getAction("cd") instanceof CdAction;
        assert solution.getAction("ls") instanceof LsAction;
        assert solution.getAction("mkdir") instanceof MkDirAction;
        assert solution.getAction("pwd") instanceof PwdAction;
        assert solution.getAction("quit") instanceof QuitAction;
        assert solution.getAction("touch") instanceof TouchAction;
        assert solution.getAction("abc") instanceof UnknownCommandAction;
    }

    @Test
    public void touchActionWithWrongParameters(){
        // Touch Action
        TouchAction touchAction = new TouchAction();
        String[] params = "touch".split(" ");
        touchAction.execute(params);
        assertEquals("Wrong parameters\n", outContent.toString());
    }

    @Test
    public void mkDirActionWithoutParameters(){
        // MkDir Action
        MkDirAction mkDirAction = new MkDirAction();
        String[] params = "mkdir".split(" ");
        mkDirAction.execute(params);
        assertEquals("Wrong parameters\n", outContent.toString());
    }

    @Test
    public void CdActionWithoutParameters(){
        // Cd Action
        CdAction cdAction = new CdAction();
        String[] params = "mkdir".split(" ");
        cdAction.execute(params);
        assertEquals("Wrong parameters\n", outContent.toString());
    }

    @Test
    public void createAnExistDirectory(){
        MkDirAction mkDirAction = new MkDirAction();
        String[] params = "mkdir directory".split(" ");
        mkDirAction.execute(params);
        outContent.reset();

        mkDirAction.execute(params);
        assertEquals("Directory already exists\n", outContent.toString());
    }

}

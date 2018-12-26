/**
 * Main Application
 */
package com.ciaoshen.gradle_demo.todo;

import com.ciaoshen.gradle_demo.todo.utils.CommandLineInput;
import com.ciaoshen.gradle_demo.todo.utils.CommandLineInputHandler;

public class ToDoApp {

    public static final char DEFAULT_INPUT = '\u0000';
    public static void main(String[] args) {
        CommandLineInputHandler commandLineInputHandler = new CommandLineInputHandler();
        char command = DEFAULT_INPUT; 

        while (CommandLineInput.EXIT.getShortCmd() != command) {
            commandLineInputHandler.printOptions();
            String input = commandLineInputHandler.readInput();
            char[] inputChars = (input.length() == 1)? input.toCharArray() : new char[]{ DEFAULT_INPUT };
            command = inputChars[0];
            // translate 1 character options to full command line
            CommandLineInput commandLineInput = CommandLineInput.getCommandLineInputForInput(command);
            commandLineInputHandler.processInput(commandLineInput);
        }
    }

}
/**
 * Main Application
 */
package com.ciaoshen.gradle_demo.another_todo;

import org.apache.commons.lang3.CharUtils;
import com.ciaoshen.gradle_demo.another_todo.utils.CommandLineInput;
import com.ciaoshen.gradle_demo.another_todo.utils.CommandLineInputHandler;

public class ToDoApp {

    public static final char DEFAULT_INPUT = '\u0000';
    public static void main(String[] args) {
        CommandLineInputHandler commandLineInputHandler = new CommandLineInputHandler();
        char command = DEFAULT_INPUT; 

        while (CommandLineInput.EXIT.getShortCmd() != command) {
            commandLineInputHandler.printOptions();
            String input = commandLineInputHandler.readInput();

            /** old version: cut the 1st character myself */
            // char[] inputChars = (input.length() == 1)? input.toCharArray() : new char[]{ DEFAULT_INPUT };
            // command = inputChars[0];

            /** new version: use org.apache.commons.lang3.CharUtils library to cut the 1st character */
            command = CharUtils.toChar(input, DEFAULT_INPUT);

            // translate 1 character options to full command line
            CommandLineInput commandLineInput = CommandLineInput.getCommandLineInputForInput(command);
            commandLineInputHandler.processInput(commandLineInput);
        }
    }

}
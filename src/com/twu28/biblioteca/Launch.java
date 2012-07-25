package com.twu28.biblioteca;

import java.io.Console;

/**
 * Created with IntelliJ IDEA.
 * User: prashu
 * Date: 22/7/12
 * Time: 6:14 PM
 * To change this template use File | Settings | File Templates.
 */
// TODO - remove template comments
// TODO - write test for Launch
public class Launch {
    // TODO - reformat code based no Java conventions
    // TODO - why static methods ?
    private static void findInputAction(int Number){
        switch (Number){
            case 1 :    ApplicationUI.displayBooks();
                        break;
            case 2 :    ApplicationUI.reserveBook();
                        break;
            case 3 :    ApplicationUI.getLibraryNumber();
                        break;
            case 4 :    System.exit(0);
            default:    System.out.println("Please Select a Valid Option");
        }
    }

    public  static void main(String [] args)
    {
        // TODO - static forces you to follow a pattern like Initialize. Should avoid this pattern.
        // TODO - static forces global state which is EVIL.
        ApplicationUI.Initialize();
        System.out.println("Welcome to Bibiloteca");
        while (true){
            System.out.println("1- View All Books\n2- Reserve a Book\n3- Check Library Number\n4- Exit\nEnter your choice -");
            String Input = ApplicationUI.readInput();
            findInputAction(Integer.parseInt(Input));

        }
    }
}

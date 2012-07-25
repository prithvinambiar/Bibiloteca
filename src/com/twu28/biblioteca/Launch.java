package com.twu28.biblioteca;

// TODO - remove template comments
// TODO - write test for Launch
public class Launch {
    // TODO - reformat code based no Java conventions
    // TODO - why static methods ?
    private Application application;

    private boolean findInputAction(int Number) {
        switch (Number) {
            case 1:
                application.displayBooks();
                return true;
            case 2:
                application.reserveBook();
                return true;
            case 3:
                application.getLibraryNumber();
                return true;
            case 4:
                return false;
            default:
                System.out.println("Please Select a Valid Option");
                return true;
        }
    }

    private void initialize() {
        boolean controlWhileLoop = true;

        application = new Application();
        System.out.println("Welcome to Bibiloteca");
        while (controlWhileLoop) {
            System.out.println("1- View All Books\n2- Reserve a Book\n3- Check Library Number\n4- Exit\nEnter your choice -");
            String Input = application.readInput();
            controlWhileLoop = findInputAction(Integer.parseInt(Input));

        }
    }

    public static void main(String[] args) {
        // TODO - static forces you to follow a pattern like initialize. Should avoid this pattern.
        // TODO - static forces global state which is EVIL.

        new Launch().initialize();
    }
}

package com.twu28.biblioteca;

public class Launch {

    private Application application;

    private boolean findInputAction(int number) {
        switch (number) {
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
            String input = application.readInput();
            controlWhileLoop = findInputAction(Integer.parseInt(input));

        }
    }

    public static void main(String[] args) {
        new Launch().initialize();
    }
}

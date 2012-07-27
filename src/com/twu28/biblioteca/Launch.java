package com.twu28.biblioteca;

public class Launch {

    private Application application;

    public Launch(Application application) {
        this.application = application;
    }

    public boolean findInputAction(int number) {
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
                application.getMovieList();
                return true;
            case 5:
                application.login();
                return true;
            case 6:
                return false;
            default:
                System.out.println("Please Select a Valid Option");
                return true;
        }
    }

    private void interactWithUser() {
        boolean controlWhileLoop = true;

        System.out.println("Welcome to Biblioteca");
        do {
            System.out.print("1- View All Books\n2- Reserve a Book\n3- Check Library Number\n4- View Movie List\n5- Login\n6- Exit\nEnter your choice - ");
            String input = application.readInput();
            try {
                controlWhileLoop = findInputAction(Integer.parseInt(input));
            } catch (Exception e) {
                System.out.println("Please Enter The Number Between 1-4");
            }
        } while (controlWhileLoop);
    }

    public static void main(String[] args) {
        Launch launch = new Launch(new Application());
        launch.interactWithUser();
    }
}

import java.util.Scanner;
/// Project by Daniel Patachov:

public class RealEstate {
    private final String[] CITY_NAMES = {"Miami", "New York", "Los Angeles", "Boston", "Orlando", "Denver", "Philadelphia", "Cleveland", "Atlanta", "Chicago"};
    private final String[] STREET_NAMES = {"Moshe Dayan", "Sheinkin", "Rotshild", " Peres", "Rabin", "haavoda", "Salvador Loria", "Rozalin", "Kisinger", "Golda Meir"};
    private final String[] STATES_NAMES = {"East", "West", "North", "South"};

    private User[] users;
    private Property[] properties;
    private City[] cities;

    public RealEstate() {
        this.users = new User[0];
        this.properties = new Property[0];
        this.cities = new City[10];


    }

    public void MainMenu() {
        int choice;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("welcome to the main menu");
            System.out.println("1- Create User");
            System.out.println("2-Login User");
            System.out.println("3- End Program");

            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    createUser();

                }
                case 2 -> {
                    userMenu(login());


                }
                case 3 -> {
                    System.out.println("Ending program");


                }
                default -> System.out.println("wrong choice");
            }

        }
        while (choice != 3);


    }

    //Exponential complexity

    void createUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a user name");
        String userName = scanner.nextLine();
        while (!isAvailble(userName)) {
            System.out.println("user name taken: try again");
            userName = scanner.nextLine();

        }
        if (isAvailble(userName))
            System.out.println("Enter a password");
        String password = scanner.nextLine();
        while (!isCorrectPassword(password)) {
            System.out.println("weak password: try again");
            password = scanner.nextLine();
        }
        System.out.println("Enter a phone number");
        String phoneNumber = scanner.nextLine();
        while (!correctNumber(phoneNumber)) {
            System.out.println(" wrong phone number: try again");
            phoneNumber = scanner.nextLine();
        }
        System.out.println("Are you real estate broker or normal user\n 1.yes \n 2.no");
        boolean broker = false;
        int answer = scanner.nextInt();
        if (answer == 1) {
            broker = true;
        }
        User newUser = new User(userName, password, phoneNumber, broker);
        User[] temp = new User[this.users.length + 1];
        for (int i = 0; i < this.users.length; i++) {
            temp[i] = this.users[i];
        }
        temp[temp.length - 1] = newUser;
        this.users = temp;
        if (answer == 2) {

        }

    }
    ///linear complexity

    public User login() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a user Name");
        String userName = scanner.nextLine();
        System.out.println("Enter a password");
        String password = scanner.nextLine();
        for (int i = 0; i < users.length; i++) {
            if (this.users[i].getUserName().equals(userName) && this.users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        System.out.println("User not found");
        return null;


    }

    public void userMenu(User user) {
        if (user == null) {
            MainMenu();
        }
        int choice;
        Scanner scanner = new Scanner(System.in);


        do {
            System.out.println("Welcome to new main menu");
            System.out.println("1- Publish a new property");
            System.out.println("2- Delete publish of a property");
            System.out.println("3- Represent all the properties in the system");
            System.out.println("4- Represent all the properties of the user");
            System.out.println("5- Find a property on parameters");
            System.out.println("6- Log out back to Main Menu");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    boolean postedProperty = postNewProperty(user);
                    if (postedProperty) {
                        System.out.println("posted success");
                    } else System.out.println("posted fail");


                }
                case 2 -> {
                    removeProperty(user);


                }
                case 3 -> {
                    printAllProperties();
                }


                case 4 -> {
                    printProperties(user);
                }
                case 5 -> {
                    search();
                }
                case 6 -> {
                    MainMenu();

                }


                default -> System.out.println("wrong choice");
            }


        } while (choice != 6);


    }
    //exponential complexity


    public boolean postNewProperty(User user) {
        int count = 0;
        boolean postNewProperty = false;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].getPublisher() == (user)) {
                count++;
            }

        }
        if (user.isBroker()) {
            if (count >= 5) {
                System.out.println("you reached to post limit");
                return postNewProperty;

            }

        } else if (count >= 2) {
            System.out.println("you reached to post limit");
            return postNewProperty;
        }
        for (int i = 0; i < this.cities.length; i++) {
            System.out.println(i + 1 + "." + cities[i]);
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter City name");
        String cityName = scanner.nextLine();
        if (cityExist(cityName)) {
            boolean streetExist = false;
            String streetName = " ";
            for (int i = 0; i < this.cities.length; i++) {
                if (this.cities[i].getCityName().equals(cityName)) {
                    this.cities[i].printStreets();
                    System.out.println("Enter street name");
                    streetName = scanner.nextLine();
                    streetExist = this.cities[i].streetExist(streetName);
                }
            }
            if (streetExist) {

                System.out.println("Enter a type of property");
                String type = scanner.nextLine();
                switch (type) {
                    case "1" -> type = "regular apartment";
                    case "2" -> type = "penthouse apartment";
                    case "3" -> type = "private apartment";


                    default -> System.out.println("doesn't exist");

                }
                int floor = 0;

                if (type.equals("regular apartment")) {
                    System.out.println("what floor is the property in the apartment");
                    floor = scanner.nextInt();
                }
                //}
                System.out.println("how many rooms");
                int rooms = scanner.nextInt();
                System.out.println("Enter property number");
                int property = scanner.nextInt();
                System.out.println("Is the property for renting or for selling");
                String ifRenting = scanner.nextLine();
                System.out.println("what is the price property");
                int price = scanner.nextInt();
                Property property1 = new Property(cityName, streetName, rooms, price, type, ifRenting, property, floor, user);
                Property[] temp = new Property[this.properties.length + 1];
                for (int i = 0; i < properties.length; i++) {
                    temp[i] = properties[i];

                }

                temp[properties.length] = property1;
                this.properties = temp;
                postNewProperty = true;


            } else System.out.println("Street doesn't exist");
        } else System.out.println("City doesn't exist");

        return postNewProperty;
    }
    ///Linear Complexity

    public void removeProperty(User user) {
        int index = 0;
        Property[] properties1 = new Property[this.properties.length];
        for (int i = 0; i < this.properties.length; i++) {
            if (properties[i].getPublisher() == user) {
                properties1[index] = properties[i];
                index++;
            }

        }
        int userProperties = propertyOfUser(user);
        if (userProperties == 0) {
            System.out.println("User not have properties");
        } else {
            propertyOfUser(user);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a number of property to remove");
            int number = scanner.nextInt();
            Property[] properties2 = new Property[properties.length - 1];
            index = 0;
            for (int i = 0; i < properties.length; i++) {
                if (properties[i] != properties1[number]) {
                    properties2[index] = properties[i];
                    index++;

                }

            }
            this.properties = properties2;
            System.out.println("remove was done successfully");
        }
    }

    ///Exponential Complexity

    public Property[] search() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is the property for renting or for selling");
        String ifRenting = scanner.nextLine();
        System.out.println("Enter the type of the property");
        String type = scanner.nextLine();
        switch (type) {
            case "1" -> type = "regular apartment";
            case "2" -> type = "penthouse apartment";
            case "3" -> type = "private apartment";


            default -> type = "-999";

        }
        System.out.println("how many rooms");
        int rooms = scanner.nextInt();
        System.out.println("what is the limit of the properties of the biggest max");
        int limitMax = scanner.nextInt();
        System.out.println("what is the limit of the properties of the smallest min");
        int limitMin = scanner.nextInt();

        Property[] temp = new Property[this.properties.length];
        int count = 0;
        for (int i = 0; i < properties.length; i++) {
            temp[i] = properties[i];

        }
        for (int i = 0; i < temp.length; i++) {
            if (!temp[i].isIfRenting().equals(ifRenting)) {
                if (!temp[i].isIfRenting().equals("-999")) {
                    temp[i] = null;
                    count++;

                }

            }
            if (temp[i].getRoomsNumbers() != rooms) {
                if ((temp[i].getRoomsNumbers() != (-999))) {
                    temp[i] = null;
                    count++;


                }
            }
            if (!temp[i].getType().equals(type)) {
                if (!temp[i].getType().equals("-999")) {
                    temp[i] = null;
                    count++;
                }
            }
            if (temp[i].getPrice() < limitMax) {
                if (temp[i].getPrice() != (-999)) {
                    temp[i] = null;
                    count++;
                }
            }
            if (temp[i].getPrice() > limitMin) {
                if (temp[i].getPrice() != (-999)) {


                    temp[i] = null;
                    count++;
                }
            }

        }
        Property[] temp2 = new Property[count];
        return temp;
    }

    public void logOut() {

        MainMenu();
    }

///Linear Complexity


    public int propertyOfUser(User user) {
        int count = 0;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].getPublisher() == (user)) {
                count++;


            }


        }
        return count;


    }

    ///Linear Complexity
    public void printProperties(User user) {
        int index = 0;
        for (int i = 0; i < properties.length; i++) {
            if (properties[i].getPublisher() == user) {
                System.out.println(index + "." + properties[i]);
                index++;
            }
        }


    }
    ///Linear Complexity

    public void printAllProperties() {
        for (int i = 0; i < properties.length; i++) {
            System.out.println(properties[i]);


        }
    }

    ///Linear Complexity
    public boolean cityExist(String cityName) {
        boolean exist = false;
        for (int i = 0; i < this.cities.length; i++) {
            if (cityName.equals(cities[i].getCityName())) {
                exist = true;
            }
        }
        return exist;
    }

    ///Linear Complexity

    public boolean isAvailble(String userName) {
        boolean available = true;
        for (int i = 0; i < this.users.length; i++) {
            if (this.users[i].getUserName().equals(userName)) {
                available = false;
                break;
            }

        }


        return available;
    }

/// linear complexity

    public boolean isCorrectPassword(String password) {
        boolean isPassword = false;
        if (haveDigit(password)) {
            for (int i = 0; i < password.length(); i++) {
                if (password.length() >= 5) {
                    if (password.charAt(i) == '$' || password.charAt(i) == '%' || password.charAt(i) == '_') {
                        isPassword = true;
                    }
                }
            }

        }
        return isPassword;


    }

    public boolean haveDigit(String password) {
        boolean haveDigit = false;
        final String Digits = "0123456789";
        for (int i = 0; i < password.length(); i++) {
            if (Digits.contains(String.valueOf(password.charAt(i)))) {

                haveDigit = true;
                break;

            }

        }
        return haveDigit;
    }

    /// Linear Complexity
    public boolean correctNumber(String phoneNumber) {
        boolean number = false;
        for (int i = 0; i < phoneNumber.length(); i++) {
            if (phoneNumber.length() == 10) {
                if (phoneNumber.startsWith("05")) {
                    number = true;


                }

            }

        }
        return number;
    }
}








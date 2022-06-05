import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Driver class.
 * @author Emre Yilmaz - 1901042606
 * @version 1.0
 * @since 2022 March
 */
public class Driver
{
    /**
     * Main function
     * @param args -
     */
    public static void main(String[] args)
    {
        Street street = new Street(100); // Creating street object 100m length
        
        // Calculating Run-time
        /*long start = System.currentTimeMillis(); // Start the clock to measure run-time

        for(int i=0;i<30000;i=i+3)
        {
            street.add(1,new House(i,3,10,3,"red","Emre"));
        }

        for(int i=3;i<30000;i=i+3)
        {
            street.add(2,new House(i,3,15,3,"red","Emre"));
        }*/

        System.out.printf("Street object has been created.\n");
        System.out.printf("Length of the street is set as %d m.\n",street.getLength());

        System.out.printf("\n\n***************************************** Creating and trying to add the building objects to street *****************************************\n\n");

        // Creating a house object and set its parameters. Then, try to add the object to street

        House house0 = new House(-3,10,10,3,"Red","Emre");
        System.out.printf("\nhouse0 object is created. Trying to add the object to left side of the street\n");
        if(!street.add(1, house0))
            System.out.printf("There is no land for your adding process! Try another building.\n");
        else
            System.out.printf("Adding process is done successfuly!\n");

        House house1 = new House(0,10,10,3,"Red","Emre");
        System.out.printf("\nhouse1 object is created. Trying to add the object to left side of the street\n");
        if(!street.add(1, house1))
            System.out.printf("There is no land for your adding process! Try another building.\n");
        else
            System.out.printf("Adding process is done successfuly!\n");

        // Creating an office object and set its parameters. Then, try to add the object to street
        Office office1 = new Office(5,10,12,"Engineering", "Cem");
        System.out.printf("\noffice1 object is created. Trying to add the object to left side of the street\n");
        if(!street.add(1, office1))
            System.out.printf("There is no land for your adding process! Try another building.\n");
        else
            System.out.printf("Adding process is done successfuly!\n");

        // Creating an office object and set its parameters. Then, try to add the object to street
        Office office2 = new Office(35,10,15,"Engineering", "Ali");
        System.out.printf("\noffice2 object is created. Trying to add the object to left side of the street\n");
        if(!street.add(1, office2))
            System.out.printf("There is no land for your adding process! Try another building.\n");
        else
            System.out.printf("Adding process is done successfuly!\n");

        // Creating a market object and set its parameters. Then, try to add the object to street
        Market market1 = new Market(5,15,20,"21.00","07.00","Emre");
        System.out.printf("\nmarket1 object is created. Trying to add the object to left side of the street\n");
        if(!street.add(2, market1))
            System.out.printf("There is no land for your adding process! Try another building.\n");
        else
            System.out.printf("Adding process is done successfuly!\n");

        // Creating a market object and set its parameters. Then, try to add the object to street
        Market market2 = new Market(20,10,30,"21.00","08.00","Emre");
        System.out.printf("\nmarket2 object is created. Trying to add the object to left side of the street\n");
        if(!street.add(2, market2))
            System.out.printf("There is no land for your adding process! Try another building.\n");
        else
            System.out.printf("Adding process is done successfuly!\n");

        // Creating a playground object and set its parameters. Then, try to add the object to street
        Playground playground1 = new Playground(41,10);
        System.out.printf("\nplayground1 object is created. Trying to add the object to left side of the street\n");
        if(!street.add(2, playground1))
            System.out.printf("There is no land for your adding process! Try another building.\n");
        else
            System.out.printf("Adding process is done successfuly!\n");


        // streeting viewing functions
        System.out.printf("\n\n***************************************** streeting viewing functions *****************************************\n\n");
        street.remainLength();
        street.printBuildingList(3);
        street.occupiedHouse();
        street.occupiedMarket();
        street.occupiedOffice();
        street.occupiedPlayground();
        street.getLeftSide().get(1).focusing();
        street.getRightSide().get(0).focusing();
        street.silhouette();

        System.out.printf("\n\n***************************************** Removing an object from the street *****************************************\n\n");
        if(!street.remove(1, 0))
            System.out.printf("\nThe building is cannot found! Try again\n");
        else
            System.out.printf("\nRemoving process is done successfuly!\n");

        street.silhouette(); // Print the street's silhouette, again


        //Calculating run-time
       /*for(int i=0;i<30000;i=i+3)
        {
            street.remove(1,i);
        }

        for(int i=3;i<30000;i=i+3)
        {
            street.remove(2,i);
        }

        long end = System.currentTimeMillis();
        System.out.println("\n\nThe run-time is: "+(end-start));*/


        /* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
        int choice = -1; // User's menu choice
        Scanner input = new Scanner(System.in);

        while(true)
        {
            boolean bool = false;
            while(bool==false)
            {
                try{
                    System.out.printf("\n\n\nWelcome to GTU Street. Please select the mode:\n1. Viewing Mode\n2. Editing Mode\n\nYour selection: ");
                    choice = input.nextInt();
                    input.nextLine();
                    bool = true;
                }catch(InputMismatchException e){input.nextLine();System.out.println(e);}
            }

            if(choice==1) // Viewing Mode selection
            {
                int editSelect = -1;

                bool = false;
                while(bool==false)
                {
                    try{
                        System.out.printf("\n1. Display the total remaining length of lands on the street\n2. Display the list of buildings on the street");
                        System.out.printf("\n3. Display the number and ratio of lenth of playgrounds in the street.");
                        System.out.printf("\n4. Calculate the total length of street occupied by the markets, houses or offices\n5. display the skyline silhouette of the street\n6. EXIT \n\nYour selection: ");
                        editSelect = input.nextInt();
                        input.nextLine();
                        bool = true;
                    }catch(InputMismatchException e){input.nextLine();System.out.println(e);}
                }


                switch(editSelect)
                {
                    case 1:
                    {
                        street.remainLength();
                        break;
                    }

                    case 2:
                    {
                        street.printBuildingList(3);
                        break;
                    }

                    case 3:
                    {
                        street.occupiedPlayground();
                        break;
                    }

                    case 4:
                    {
                        street.occupiedHouse();
                        street.occupiedMarket();
                        street.occupiedOffice();
                        break;
                    }

                    case 5:
                    {
                        street.silhouette();
                        break;
                    }

                    case 6:
                        return;

                    default:
                    {
                        System.out.printf("Your input was not valid. Try again!");
                        break;
                    }
                }
            }


            if(choice==2) // Editing Mode Selection
            {
                int editSelect = -1; // Add/Remove selections of user
                int sideSelect = -1; // Side selection of user


                bool = false;
                while(bool==false)
                {
                    try{
                        System.out.printf("\n1. Add a building\n2. Remove a building\n\nYour selection: ");
                        editSelect = input.nextInt();
                        input.nextLine();
                        bool = true;
                    }catch(InputMismatchException e){input.nextLine();System.out.println(e);}


                }

                switch(editSelect)
                {
                    case 1:
                    {
                        int buildingType = -1;

                        bool = false;
                        while(bool==false)
                        {
                            try{
                                System.out.printf("\nWhich side do you want to add a building?\n1. Left\n2. Right");
                                sideSelect = input.nextInt();
                                input.nextLine();
                                bool = true;
                            }catch(InputMismatchException e){input.nextLine();System.out.println(e);}
                        }

                        if(sideSelect!=1 && sideSelect!=2)
                        {
                            System.out.printf("\nYour input is not valid! Try again.\n");
                            continue;
                        }

                        bool = false;
                        while(bool==false)
                        {
                            try{
                                System.out.printf("\nWhat building type do you want to add ?\n1. House\n2. Office\n3. Market\n4. Playground\n\nYour selection: ");
                                buildingType = input.nextInt();
                                input.nextLine();
                                bool = true;
                            }catch(InputMismatchException e){input.nextLine();System.out.println(e);}
                        }

                        if(buildingType==1)
                        {
                            House newHouse = new House();

                            bool = false;
                            while(bool==false)
                            {
                                try{
                                    System.out.printf("\nEnter the position: ");
                                    newHouse.setPosition(input.nextInt());
                                    System.out.printf("Enter the length: ");
                                    newHouse.setLength(input.nextInt());
                                    System.out.printf("Enter the height: ");
                                    newHouse.setHeight(input.nextInt());
                                    System.out.printf("Enter the room number: ");
                                    newHouse.setRoomNumber(input.nextInt());
                                    System.out.printf("Enter the owner: ");
                                    newHouse.setOwner(input.next());
                                    System.out.printf("Enter the color: ");
                                    newHouse.setColor(input.next());
                                    input.nextLine();
                                    bool = true;
                                }catch(InputMismatchException e){input.nextLine();System.out.println(e);}
                            }

                            if(!street.add(sideSelect, newHouse))
                                System.out.printf("\nThere is no land for your adding process! Try another building\n");
                            else
                                System.out.printf("\nAdding process is done successfuly!\n");
                        }

                        if(buildingType==2)
                        {
                            Office newOffice = new Office();

                            bool = false;
                            while(bool==false)
                            {
                                try{
                                    System.out.printf("\nEnter the position: ");
                                    newOffice.setPosition(input.nextInt());
                                    System.out.printf("Enter the length: ");
                                    newOffice.setLength(input.nextInt());
                                    System.out.printf("Enter the height: ");
                                    newOffice.setHeight(input.nextInt());
                                    System.out.printf("Enter the job type: ");
                                    newOffice.setJobType(input.next());
                                    System.out.printf("Enter the owner: ");
                                    newOffice.setOwner(input.next());
                                    input.nextLine();
                                    bool = true;
                                }catch(InputMismatchException e){input.nextLine();System.out.println(e);}
                            }

                            if(!street.add(sideSelect, newOffice))
                                System.out.printf("\nThere is no land for your adding process! Try another building\n");
                            else
                                System.out.printf("\nAdding process is done successfuly!\n");
                        }

                        if(buildingType==3)
                        {
                            Market newMarket = new Market();

                            bool = false;
                            while(bool==false)
                            {
                                try{
                                    System.out.printf("\nEnter the position: ");
                                    newMarket.setPosition(input.nextInt());
                                    System.out.printf("Enter the length: ");
                                    newMarket.setLength(input.nextInt());
                                    System.out.printf("Enter the height: ");
                                    newMarket.setHeight(input.nextInt());
                                    System.out.printf("Enter the opening time: ");
                                    newMarket.setOpeningTime(input.next());
                                    System.out.printf("Enter the closing time: ");
                                    newMarket.setClosingTime(input.next());
                                    System.out.printf("Enter the owner: ");
                                    newMarket.setOwner(input.next());
                                    input.nextLine();
                                    bool = true;
                                }catch(InputMismatchException e){input.nextLine();System.out.println(e);}
                            }

                            if(!street.add(sideSelect, newMarket))
                                System.out.printf("\nThere is no land for your adding process! Try another building\n");
                            else
                                System.out.printf("\nAdding process is done successfuly!\n");
                        }

                        if(buildingType==4)
                        {
                            Playground newPlayground = new Playground();

                            bool = false;
                            while(bool==false)
                            {
                                try{
                                    System.out.printf("\nEnter the position: ");
                                    newPlayground.setPosition(input.nextInt());
                                    System.out.printf("Enter the length: ");
                                    newPlayground.setLength(input.nextInt());
                                    System.out.printf("Enter the height: ");
                                    newPlayground.setHeight(input.nextInt());
                                    input.nextLine();
                                    bool = true;
                                }catch(InputMismatchException e){input.nextLine();System.out.println(e);}
                            }

                            if(!street.add(sideSelect, newPlayground))
                                System.out.printf("\nThere is no land for your adding process! Try another building\n");
                            else
                                System.out.printf("\nAdding process is done successfuly!\n");
                        }
                        break;

                    }

                    case 2:
                    {
                        bool = false;
                        while(bool==false)
                        {
                            try{
                                System.out.printf("\nWhich side do you want to add a building?\n1. Left\n2. Right");
                                sideSelect = input.nextInt();
                                input.nextLine();
                                bool = true;
                            }catch(InputMismatchException e){input.nextLine();System.out.println(e);}
                        }

                        if(sideSelect==1)
                        {
                            int targetPos = -1;
                            street.printBuildingList(1);

                            bool = false;
                            while(bool==false)
                            {
                                try{
                                    System.out.printf("Enter the position of a building that you want to remove: ");
                                    targetPos = input.nextInt();
                                    input.nextLine();
                                    bool = true;
                                }catch(InputMismatchException e){input.nextLine();System.out.println(e);}
                            }

                            if(!street.remove(1, targetPos))
                                System.out.printf("\nThe building is cannot found! Try again\n");
                            else
                                System.out.printf("\nRemoving process is done successfuly!\n");
                        }

                        else if(sideSelect==2)
                        {
                            int targetPos = -1;
                            street.printBuildingList(2);

                            bool = false;
                            while(bool==false)
                            {
                                try{
                                    System.out.printf("Enter the position of a building that you want to remove: ");
                                    targetPos = input.nextInt();
                                    input.nextLine();
                                    bool = true;
                                }catch(InputMismatchException e){input.nextLine();System.out.println(e);}
                            }

                            if(!street.remove(2, targetPos))
                                System.out.printf("\nThe building is cannot found! Try again\n");
                            else
                                System.out.printf("\nRemoving process is done successfuly!\n");
                        }

                        else
                        {
                            System.out.printf("Your side entry is not valid! Try again\n");
                            continue;
                        }

                        break;
                    }
                }
            }
        }
    }
}

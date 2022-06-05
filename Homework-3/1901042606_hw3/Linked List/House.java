/**
 * House class.
 * @author Emre Yilmaz - 1901042606
 * @version 1.0
 * @since 2022 March
 */
public class House extends Building
{
    private int roomNumber;
    private String color;
    private String owner;

    /**
     * No parameter constructor that initiliaze room number, color and owner
     */
    public House()
    {
        roomNumber = -1;
        color = new String("none");
        owner = new String("none");
    }

    /**
     * Constructor
     * @param roomNumber Indicates room number of the house
     * @param color Indicates color of the house
     * @param owner Indicates owner of the hose
     */
    public House(int roomNumber, String color, String owner)
    {
        this.roomNumber = roomNumber;
        this.color = color;
        this.owner = owner;
    }

    /**
     * Constructor initilize all data of house
     * @param position Indicates initial position of house
     * @param length Indicates length of the house
     * @param height Indicates height of the house
     * @param roomNumber Indicates room number of the hoouse
     * @param color Indicates color of the house
     * @param owner Indicates owner of the house
     */
    public House(int position, int length, int height, int roomNumber, String color, String owner)
    {
        super(position, length, height);
        this.roomNumber = roomNumber;
        this.color = color;
        this.owner = owner;
    }

    /**
     * Getter function for "roomNumber" variable
     * @return Returns room number variable
     */
    public int getRoomNumber()
    {return roomNumber;}

    /**
     * Setter function for "roomNumber" variable
     * @param roomNumber Indicates room number of the house
     */
    public void setRoomNumber(int roomNumber)
    {
        this.roomNumber = roomNumber;
    }


    /**
     * Getter function for "color" variable
     * @return Returns the color variable of the house
     */
    public String getColor()
    {return color;}

    /**
     * Setter function for "color" variable
     * @param color Indicates color of the house
     */
    public void setColor(String color)
    {
        this.color = color;
    }

    /**
     * Getter function for "owner" variable
     * @return Returns the owner variable
     */
    public String getOwner()
    {return owner;}

    /**
     * Setter function for "owner" variable
     * @param owner Indicates owner variable
     */
    public void setOwner(String owner)
    {this.owner = owner;}

    /**
     * Abstract focusing method. Presents different types of information to the user on focusing on a building
     */
    public void focusing()
    {
        System.out.printf("\nThe owner of this house is %s\n",this.owner);
    }

    /**
     * Abstract method. Returns the building type (house-market-office-playground) as String
     * @return Returns the type of the object
     */
    public String type()
    {return "House";}

    public boolean equals(House obj)
    {
        if(obj.color==this.color && obj.owner==this.owner && obj.roomNumber==this.roomNumber && obj.getPosition() ==
        this.getPosition() && obj.getLength()==this.getLength() && obj.getHeight()==this.getHeight())
            return true;
        else
            return false;
    }

}

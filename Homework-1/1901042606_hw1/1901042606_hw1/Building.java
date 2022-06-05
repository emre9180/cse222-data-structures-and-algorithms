
/**
 * Building abstract class. Represents generic buildings. Includes functions and data related to building types.
 * @author Emre Yilmaz - 1901042606
 * @version 1.0
 * @since 2022 March
 */
public abstract class Building
{
    private int position;
    private int length;
    private int height;

    /**
     * No parameter constructor, initiliazes position and length
     */
    public Building()
    {
        position = 1;
        length = 1;
        height = 1;
    }

    /**
     * Constructor that has 2 parameters for position and length of the building
     * @param position Indicates initial position of the building
     * @param length Indicates length of the building
     */
    public Building(int position, int length, int height)
    {
        this.position = position;
        this.length = length;
        this.height = height;
    }

    /**
     * Getter function for "position" variable of building
     * @return Returns the position of the building
     */
    public int getPosition(){ return position; }

    /**
     * Setter function for "position" variable of building
     * @param position Indicates position of the building
     */
    public void setPosition(int position)
    {
        this.position = position;
    }


    /**
     * Getter function for "length" variable of building
     * @return Returns length of the building
     */
    public int getLength(){ return length; }

    /**
     * Setter function for "length" variable of building
     * @param length Indicates length of the building
     */
    public void setLength(int length)
    {
        this.length = length;
    }


    /**
     * Getter function for "height" variable of building
     * @return Returns the height of the building
     */
    public int getHeight(){ return height; }

    /**
     * Setter function for "height" variable of building
     * @param height Indicates height of the building
     */
    public void setHeight(int height)
    {
        this.height = height;
    }

    /**
     * Abstract focusing method. Presents different types of information to the user on focusing on a building
     */
    abstract void focusing();

    /**
     * Abstract method. Returns the building type (house-market-office-playground) as String
     * @return Returns the type of the building
     */
    abstract String type();






}




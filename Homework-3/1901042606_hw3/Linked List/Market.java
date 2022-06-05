
/**
 * Market class.
 * @author Emre Yilmaz - 1901042606
 * @version 1.0
 * @since 2022 March
 */
public class Market extends Building
{
    private String closingTime; // Closing time
    private String openingTime; // Opening time
    private String owner;

    /**
     * No parameter constructor. Initiliaze the "open-closing time" and "owner" variables
     */
    public Market()
    {
        closingTime = new String("none");
        openingTime = new String("none");
        owner = new String("none");
    }

    /**
     * Constructor
     * @param closingTime Indicates closing time of the market
     * @param openingTime Indicates opening time of the market
     * @param owner Indicates owner of the market
     */
    public Market(String closingTime, String openingTime, String owner)
    {
        this.closingTime = closingTime;
        this.openingTime = openingTime;
        this.owner = owner;
    }

    /**
     * Constructor that has all the data of Market
     * @param position Indicates initial position of the market
     * @param length Indicates length of the market
     * @param height Indicates height of the market
     * @param closingTime Indicates closing time of the market
     * @param openingTime Indicates opening time of the market
     * @param owner Indicates owner of the market
     */
    public Market(int position, int length, int height, String closingTime, String openingTime, String owner)
    {
        super(position, length, height);
        this.closingTime = closingTime;
        this.openingTime = openingTime;
        this.owner = owner;
    }

    /**
     * Getter function for "closing time" variable
     * @return Returns the closing time of the market
     */
    public String getClosingTime()
    {return closingTime;}

    /**
     * Setter function for "closing time" variable
     * @param closingTime Indicates closing the of the market
     */
    public void setClosingTime(String closingTime)
    {
        this.closingTime = closingTime;
    }


    /**
     * Getter function for "opening time" variable
     * @return Returns the opening time of the market
     */
    public String getOpeningTime()
    {return openingTime;}

    /**
     * Setter function for "opening time" variable
     * @param openingTime Indicates opening time of the market
     */
    public void setOpeningTime(String openingTime)
    {
        this.openingTime = openingTime;
    }


    /**
     * Getter function for "owner" variable
     * @return Returns owner of the market
     */
    public String getOwner()
    {return owner;}

    /**
     * Setter function for "owner" variable
     * @param owner Indicates owner of the market
     */
    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    /**
     * Abstract focusing method. Presents different types of information to the user on focusing on a building
     */
    public void focusing()
    {
        System.out.printf("\nThe closing time of this market is %s\n",this.closingTime);
    }

    /**
     * Abstract method. Returns the building type (house-market-office-playground) as String
     * @return Returns the type of the object
     */
    public String type()
    {return "Market";}

    public boolean equals(Market obj)
    {
        if(this.closingTime==obj.closingTime && this.openingTime==obj.openingTime && this.owner==obj.owner &&
        this.getPosition()==obj.getPosition() && this.getLength()== obj.getLength() && this.getHeight()==obj.getHeight())
            return true;
        else
            return false;
    }


}


/**
 * Playground classs
 * @author Emre Yilmaz - 1901042606
 * @version 1.0
 * @since 2022 March
 */
public class Playground extends Building
{
    /**
     * Constructor
     */
    public Playground()
    {
        super(1, 1, 2);
    }

    /**
     * Constructor.
     * @param position Indicates initial position of the playground
     * @param length Indicates length of the playground
     */
    public Playground(int position, int length)
    {
        super(position, length, 5);
    }


    /**
     * Abstract focusing method. Presents different types of information to the user on focusing on a building
     */
    public void focusing()
    {
        System.out.printf("\nThe length of this playground is %lf\n",getLength());
    }


    /**
     * Abstract method. Returns the building type (house-market-office-playground) as String
     * @return Returns te type of the object
     */
    public String type()
    {return "Playground";}

    public boolean equals(Playground obj)
    {
        if(obj.getPosition()==this.getPosition() && obj.getLength()==this.getLength() && obj.getHeight()==this.getHeight()
        )
            return true;
        else
            return false;
    }
}


/**
 * Office class.
 * @author Emre Yilmaz - 1901042606
 * @version 1.0
 * @since 2022 March
 */
public class Office extends Building
{
    private String jobType;
    private String owner;

    /**
     * No parameter constructor. Intiliaze jobType and owner as none
     */
    public Office()
    {
        jobType = new String("none");
        owner = new String("none");
    }

    /**
     * Constructor
     * @param jobType Indicates job type of the Office
     * @param owner Indicates owner of the Office
     */
    public Office(String jobType, String owner)
    {
        this.jobType = jobType;
        this.owner = owner;
    }

    /**
     * Constructor that has all the data of office
     * @param position Indicates initial position of the office
     * @param length Indicates length of the office
     * @param height Indicates height of the office
     * @param jobType Indicates job type of the office
     * @param owner Indicates owner of the office
     */
    public Office(int position, int length, int height, String jobType, String owner)
    {
        super(position, length, height);
        this.jobType = jobType;
        this.owner = owner;
    }

    /**
     * Getter function for "jobType" variable
     * @return Returns the job type of the Office
     */
    public String getJobType()
    {return jobType;}

    /**
     * Setter function for "jobType" variable
     * @param jobType Indicates job type of the Office
     */
    public void setJobType(String jobType)
    {
        this.jobType = jobType;
    }


    /**
     * Getter function for "owner" variable
     * @return Returns the owner of the Office
     */
    public String getOwnerType()
    {return owner;}

    /**
     * Setter function for "owner" variable
     * @param owner Indicates owner of the Office
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
        System.out.printf("\nThe job-type of this office is %s\n",this.jobType);
    }

    /**
     * Abstract method. Returns the building type (house-market-office-playground) as String
     * @return Returns the type of the object
     */
    public String type()
    {return "Office";}



}

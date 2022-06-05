/**
 * This class is used in the Breadth First Search algorithm. In the implementation of the BFS in the textbook, the Identified array is integer.
 * However, in this homework, it will be Identified array. So, we will be able to store the information of the all visitings (weight, level, identified info)
 */
public class Identified
{
    /**
     * Identified property of a visiting. If true, the vertex is visited before
     */
    boolean identified;

    /**
     * The level of the visiting.
     */
    int level;

    /**
     * The weight of the visiting(edge)
     */
    double weight;

    /**
     * Constructor with all data
     * @param identified boolean identified information
     * @param level level information
     * @param weight weight information
     */
    public Identified(boolean identified, int level, double weight)
    {
        this.identified = identified;
        this.level = level;
        this.weight = weight;
    }

    /**
     * Constructor without weight. It sets the weight 0
     * @param identified
     * @param level
     */
    public Identified(boolean identified, int level)
    {
        this.identified = identified;
        this.level = level;
        this.weight = 0;
    }

    /**
     * Getter for identified variable
     * @return Return identified variable
     */
    public boolean getIdentified() { return identified; }

    /**
     * Getter for level variable
     * @return Return level variable
     */
    public int getLevel()
    {
        return level;
    }

    /**
     * Getter for weight variable
     * @return Return weight variable
     */
    public double getWeight(){ return weight; }

    /**
     * Setter method for weight
     * @param weight New weight
     */
    public void setWeight(double weight){this.weight = weight;}


}
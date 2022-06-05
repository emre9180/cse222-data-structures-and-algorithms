/**
 * Representing vertices in the graph
 */
public class Vertex{
    /**
     * Index
     */
    private int ID;

    /**
     * Label
     */
    private String label;

    /**
     * Weight
     */
    private double weight;

    /**
     * Key value pairs
     */
    private HashtableOpen<String,String> pairs;

    /**
     * No-param constructor
     */
    Vertex(){}

    /**
     * Constructor with a vertex object
     * @param obj Vertex object
     */
    Vertex(Vertex obj)
    {
        this.ID = obj.ID;
        this.label = obj.label;
        this.weight = obj.weight;
        this.pairs = new HashtableOpen<>();
    }

    /**
     * Constructor
     * @param ID ID input
     * @param label Label input
     * @param weight Weight input
     */
    Vertex(int ID, String label, double weight)
    {
        this.ID = ID;
        this.label = label;
        this.weight = weight;
        this.pairs = new HashtableOpen<>();
    }

    /**
     * Adds a property to Vertex object
     * @param key Key variable
     * @param value Value variable
     */
    public void addProperty(String key, String value)
    {
        pairs.put(key,value);
    }
	
    /**
     * Search for the property with given key
     * @param key Key variable
     * @return Return the value
     */
    public String getProperty(String key)
    {
        return pairs.get(key);
    }

    /**
     * Getter function for ID
     * @return ID
     */
    public int getID()
    {return ID;}

    /**
     * Getter function for Label
     * @return Label
     */
    public String getLabel()
    {return label;}

    /**
     * Getter function for weight
     * @return weight
     */
    public double getWeight()
    {return weight;}


    /**
     * Setter function for ID
     * @param ID Setting value
     */
    public void setID(int ID)
    {this.ID = ID;}

    /**
     * Setter function for Label
     * @param label Setting value
     */
    public void setLabel(String label)
    {this.label = label;}

    /**
     * Setter function for weight
     * @param weight Setting value
     */
    public void setWeight(double weight)
    {this.weight = weight;}
	
    public String toString()
    {
        StringBuffer sb = new StringBuffer();
        sb.append(ID);
        return sb.toString();
    }


}

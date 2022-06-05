

import javax.lang.model.util.ElementScanner6;
import java.util.ArrayList;
/**
 * Street class. Includes all the implementations related to buildings in the street and properties of the street
 * @author Emre Yilmaz - 1901042606
 * @version 1.0
 * @since 2022 March
 */
public class Street
{
    private int length; // Length of the street
    private ArrayList<Building> leftSide = new ArrayList<Building>(); // Keeps left side buildings
    private ArrayList<Building> rightSide = new ArrayList<Building>(); // Keeps right side buildings

    /**
     * No parameter constructor. Intiliaze the length as 100m.
     */
    public Street()
    {
        length = 100;
    }

    /**
     * Constructor. Sets the length
     * @param length Indicates length of the stret
     */
    public Street(int length)
    {
        this.length = length;
    }

    /**
     * Returns the length of the street
     */
    public int getLength()
    {
        return length;
    }

    /**
     * Sets the length of the street
     * @param length Indicates length of the street
     */
    public void setLength(int length)
    {
        this.length = length;
    }

    /**
     * Getter function for building number of left side of the street
     * @return Returns the building number of the left side of the street
     */
    public int getleftNum()
    {return leftSide.size();}

    /**
     * Getter function for building number of right side of the street
     * @return Returns the building number of right side of the street
     */
    public int getrightNum()
    {return rightSide.size();}

    /**
     * Getter function for left side building array
     * @return Returns the array that keeps the building on the left side of the street
     */
    public ArrayList<Building> getLeftSide()
    {return leftSide;}

    /**
     * Getter function for right side building array
     * @return Returns the array that keeps the building on the right side of the street
     */
    public ArrayList<Building> getRightSide()
    {return rightSide;}

    /**
     * It checks whether the building that will be added coincides with any existing building on the street
     * @param side Indicates side of the street (right-left)
     * @param position Indicates initial pozition of the street
     * @param length Indicates length of the street
     * @return Returns boolean value. If there is coincidence, returns false
     */
    public boolean check(int side, int position, int length)
    {
        switch(side)
        {
            // left side
            case 1:
            {   if(leftSide.size()==0) return true;

                for(int i=0;i<leftSide.size();++i)
                {
                    for(int j=position;j<=length+position;++j)
                    {
                        if((leftSide.get(i).getPosition()<=j) && (j<=leftSide.get(i).getPosition()+leftSide.get(i).getLength()))
                            return false;
                    }
                }
                break;
            }

            // right side
            case 2:
            {   if(rightSide.size()==0) return true;

                for(int i=0;i<rightSide.size();++i)
                {
                    for(int j=position;j<=length+position;++j)
                    {
                        if((rightSide.get(i).getPosition()<=j) && (j<=rightSide.get(i).getPosition()+rightSide.get(i).getLength()))
                            return false;
                    }
                }
                break;
            }
        }

        return true;
    }

    /**
     * Removes a building that is second the parameter
     * @param side Indicates side of the street (left-right)
     * @param target Indicates target building to remove
     * @return If the removing process done successfuly, returns true
     */
    public boolean remove(int side, Building target)
    {
        int ct = 0;
        boolean findFlag = false;

        if(side==1)
        {
            if(leftSide.size()==0) return false;

            for(int i=0;i<leftSide.size();++i)
            {
                if(leftSide.get(i)==target)
                {
                    findFlag = true;
                    leftSide.remove(i);
                    break;
                }
            }
        }

        if(side==2)
        {
            if(rightSide.size()==0) return false;

            for(int i=0;i<rightSide.size();++i)
            {
                if(rightSide.get(i)==target)
                {
                    findFlag = true;
                    rightSide.remove(i);
                    break;
                }

            }
        }
        return findFlag;
    }

    /**
     * Removes a building according the position
     * @param side Indicates side of the street (left-right)
     * @param targetPos Target position to remove a building
     * @return If there is a building in the target position, returns true
     */
    public boolean remove(int side, int targetPos)
    {
        int ct = 0;
        boolean findFlag = false;
        if(targetPos>length || targetPos<0) return false;

        if(side==1)
        {
            if(leftSide.size()==0) return false;

            for(int i=0;i<leftSide.size();++i)
            {
                if(leftSide.get(i).getPosition()==targetPos)
                {
                    findFlag = true;
                    leftSide.remove(i);
                    break;
                }
            }
        }

        if(side==2)
        {
            if(rightSide.size()==0) return false;

            for(int i=0;i<rightSide.size();++i)
            {
                if(rightSide.get(i).getPosition()==targetPos)
                {
                    findFlag = true;
                    rightSide.remove(i);
                    break;
                }
            }
        }

        return findFlag;
    }

    /**
     * Adds a building to the street.
     * @param side Indicates side of the street (left-right)
     * @param newElement New element that will be added
     * @return If the adding process is done successfuly, returns true
     */
    public boolean add(int side, Building newElement)
    {
        if(newElement.getPosition()<0 || newElement.getPosition()>length) return false; // If the initial position of building is not valid, return false
        else if(newElement.getPosition() + newElement.getLength() > length) return false; // If the length of building exceeds the length of the street, return false


        if(!check(side, newElement.getPosition(), newElement.getLength())) return false;

        if(side==1)
        {
            leftSide.add(newElement);
            return true;
        }

        else
        {
            rightSide.add(newElement);
            return true;
        }
    }

    /**
     * Calculates and prints the remaning length of lands in the street
     */
    public void remainLength()
    {
        int leftLength = 0;
        int rightLength = 0;

        for(int i=0;i<leftSide.size();++i)
            leftLength += leftSide.get(i).getLength();

        for(int i=0;i<rightSide.size();++i)
            rightLength +=rightSide.get(i).getLength();

        System.out.printf("\nRemaning length on the left side of the street: %d m\n",this.length-leftLength);
        System.out.printf("Remaning length on the right side of the street: %d m\n",this.length-rightLength);
        System.out.printf("Remaning total length of the street: %d m\n\n",this.length-leftLength + this.length-rightLength);
    }


    /**
     * Prints the building type list and their positions on the street. Prints both side of street.
     * @param side 1 -> Print the left side, 2-> Print the right side, 3 -> Print both side
     */
    public void printBuildingList(int side)
    {
        if(side==1 || side==3)
        {
            System.out.printf("\nBuildings on the left side:\n");
            for(int i=0;i<leftSide.size();++i)
            {
                if(leftSide.get(i).type()=="House")
                    System.out.printf("House (beginning position: %d)\n",leftSide.get(i).getPosition());

                if(leftSide.get(i).type()=="Market")
                    System.out.printf("Market (beginning position: %d)\n",leftSide.get(i).getPosition());

                if(leftSide.get(i).type()=="Office")
                    System.out.printf("Office (beginning position: %d)\n",leftSide.get(i).getPosition());

                if(leftSide.get(i).type()=="Playground")
                    System.out.printf("Playground (beginning position: %d)\n",leftSide.get(i).getPosition());
            }
        }

        if(side==2 || side==3)
        {
            System.out.printf("\nBuildings on the right side:\n");
            for(int i=0;i<rightSide.size();++i)
            {
                if(rightSide.get(i).type()=="House")
                    System.out.printf("House (beginning position: %d)\n",rightSide.get(i).getPosition());

                if(rightSide.get(i).type()=="Market")
                    System.out.printf("Market (beginning position: %d)\n",rightSide.get(i).getPosition());

                if(rightSide.get(i).type()=="Office")
                    System.out.printf("Office (beginning position: %d)\n",rightSide.get(i).getPosition());

                if(rightSide.get(i).type()=="Playground")
                    System.out.printf("Playground (beginning position: %d)\n",rightSide.get(i).getPosition());
            }
        }
        System.out.printf("\n\n");
    }

    /**
     * Calculate the total length of street occupied by the markets
     */
    public void occupiedMarket()
    {
        int leftLength = 0; // Total length on the left side of the street occupied by markets
        int rightLength = 0; // Total length on the right side of the street occupied by markets

        // Calculate left side of the street
        for(int i=0;i<leftSide.size();++i)
        {
            if(leftSide.get(i).type()=="Market")
                leftLength += leftSide.get(i).getLength();
        }

        // Calculate right side of the street
        for(int i=0;i<rightSide.size();++i)
        {
            if(rightSide.get(i).type()=="Market")
                rightLength += rightSide.get(i).getLength();
        }

        System.out.printf("Total length on the left side of the street occupied by Markets is: %d",leftLength);
        System.out.printf("\nTotal length on the right side of the street occupied by Markets is: %d",rightLength);
        System.out.printf("\nTotal length on the street occupied by Markets is: %d\n\n",leftLength+rightLength);
    }

    /**
     * Calculate the total length of street occupied by the offices
     */
    public void occupiedOffice()
    {
        int leftLength = 0; // Total length on the left side of the street occupied by Offices
        int rightLength = 0; // Total length on the right side of the street occupied by Offices

        // Calculate left side of the street
        for(int i=0;i<leftSide.size();++i)
        {
            if(leftSide.get(i).type()=="Office")
                leftLength += leftSide.get(i).getLength();
        }

        // Calculate right side of the street
        for(int i=0;i<rightSide.size();++i)
        {
            if(rightSide.get(i).type()=="Office")
                rightLength += rightSide.get(i).getLength();
        }

        System.out.printf("Total length on the left side of the street occupied by Offices is: %d",leftLength);
        System.out.printf("\nTotal length on the right side of the street occupied by Offices is: %d",rightLength);
        System.out.printf("\nTotal length on the street occupied by Offices is: %d\n\n",leftLength+rightLength);
    }

    /**
     * Calculate the total length of street occupied by the houses
     */
    public void occupiedHouse()
    {
        int leftLength = 0; // Total length on the left side of the street occupied by Houses
        int rightLength = 0; // Total length on the right side of the street occupied by Houses

        // Calculate left side of the street
        for(int i=0;i<leftSide.size();++i)
        {
            if(leftSide.get(i).type()=="House")
                leftLength += leftSide.get(i).getLength();
        }

        // Calculate right side of the street
        for(int i=0;i<rightSide.size();++i)
        {
            if(rightSide.get(i).type()=="House")
                rightLength += rightSide.get(i).getLength();
        }

        System.out.printf("Total length on the left side of the street occupied by Houses is: %d",leftLength);
        System.out.printf("\nTotal length on the right side of the street occupied by Houses is: %d",rightLength);
        System.out.printf("\nTotal length on the street occupied by Houses is: %d\n\n",leftLength+rightLength);
    }

    /**
     * Display the number and ratio of lenth of playgrounds in the street.
     */
    public void occupiedPlayground()
    {
        float totalLength = 0; // Total length on the street occupied by Playgrounds
        int numOfPlyg = 0;

        // Calculate left side of the street
        for(int i=0;i<leftSide.size();++i)
        {
            if(leftSide.get(i).type()=="Playground")
            {
                totalLength += leftSide.get(i).getLength();
                ++numOfPlyg;
            }

        }

        // Calculate right side of the street
        for(int i=0;i<rightSide.size();++i)
        {
            if(rightSide.get(i).type()=="Playground")
            {
                totalLength += rightSide.get(i).getLength();
                ++numOfPlyg;
            }
        }

        float percantage = totalLength/this.length * 100;
        System.out.printf("\nNumber of total playgrounds is: %d",numOfPlyg);
        System.out.printf("\nRatio of the playgrounds to the Street is: %c%.2f\n",'%', percantage);
    }

    /**
     * Private helper function. Finds the maximum height of the all street
     * @return Returns the maximum height of the street
     */
    private int findMaxHeight()
    {
        int max = 0;

        for(int i=0;i<leftSide.size();++i)
        {
            if(leftSide.get(i).getHeight()>max)
                max = leftSide.get(i).getHeight();
        }

        for(int i=0;i<rightSide.size();++i)
        {
            if(rightSide.get(i).getHeight()>max)
                max = rightSide.get(i).getHeight();
        }

        return max;
    }

    /**
     * Private helper function. Finds the maximum height of a specific position in the street
     * @param pos Indicates the position that will be calculate its maximum height
     * @return Returns the maximum height of the 'pos'
     */
    private int findMaxHeightPos(int pos)
    {
        int max = 0;

        for(int i=0;i<leftSide.size();++i)
        {
            if(pos>=leftSide.get(i).getPosition() && pos<=leftSide.get(i).getPosition()+leftSide.get(i).getLength())
                if(leftSide.get(i).getHeight() > max)
                    max = leftSide.get(i).getHeight();
        }

        for(int i=0;i<rightSide.size();++i)
        {
            if(pos>=rightSide.get(i).getPosition() && pos<=rightSide.get(i).getPosition()+rightSide.get(i).getLength())
                if(rightSide.get(i).getHeight() > max)
                    max = rightSide.get(i).getHeight();
        }

        return max;

    }

    /**
     * Private helper function. Checks whether a position is a beginning or ending point of a building and the '|' character should print
     * @param pos Target position
     * @param step Target Height level
     * @return If the '|' character must print, return true
     */
    private boolean checkBeginEnd(int pos, int step)
    {
        for(int i=0;i<rightSide.size();++i)
        {
            if((pos==rightSide.get(i).getPosition() && step<=rightSide.get(i).getHeight()))
                if(rightSide.get(i).getHeight() == findMaxHeightPos(rightSide.get(i).getPosition()))
                    return true;

            if(((pos==(rightSide.get(i).getPosition()+rightSide.get(i).getLength())) && step<=rightSide.get(i).getHeight()))
                if(rightSide.get(i).getHeight() == findMaxHeightPos(rightSide.get(i).getPosition()+rightSide.get(i).getLength()))
                    return true;
        }

        for(int i=0;i<leftSide.size();++i)
        {
            if((pos==leftSide.get(i).getPosition() && step<=leftSide.get(i).getHeight()))
                if(leftSide.get(i).getHeight() == findMaxHeightPos(leftSide.get(i).getPosition()))
                    return true;

            if(((pos==(leftSide.get(i).getPosition()+leftSide.get(i).getLength())) && step<=leftSide.get(i).getHeight()))
                if(leftSide.get(i).getHeight() == findMaxHeightPos(leftSide.get(i).getPosition()+leftSide.get(i).getLength()))
                    return true;
        }

        return false;
    }

    /**
     * Prints the street's silhouette
     */
    public void silhouette()
    {
        boolean beginning = false;
        boolean end = false;
        int maxHeight = findMaxHeight();
        System.out.printf("\n\n");
        for(int i=(int)maxHeight;i>0;--i)
        {
            for(int k=0;k<length;++k)
            {
                if(i==findMaxHeightPos(k))
                    System.out.printf("-");

                else if(checkBeginEnd(k,i))
                    System.out.printf("|");

                else
                    System.out.printf(" ");



            }
            System.out.printf("\n");
        }
    }


}
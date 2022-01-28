import java.util.Scanner;

public class App {


    /**
     * Creating the class 'point' in which will be stored the corrdinates of the 
     * point objects
     */
    public static class Point
    {
        //Creating the double values of the coordinates
        private double x;
        private double y;

        //Method setting the X coordinate of the point
        public void setX(double X)
        {
            this.x = X;
        }

        //Method setting the Y coordinate of the point
        public void setY(double Y)
        {
            this.y = Y;
        }

        //Method allowing to return the value of x
        public double getX()
        {
            return x;
        }

        //Method allowing to return the value of y
        public double getY()
        {
            return y;
        }
    }

    //Creating an answer prompt variable
    static String ans1 = "";
    static String ans2 = "";

    //Method reseting answer
    public static void resetAnswers()
    {
        ans1 = "";
        ans2 = "";
    }

    /**
     * App which inputs the coordinates of every point created in order to calculate the area of
     * said shape
     * @param args
     */
    public static void main(String[] args) 
    {
        //Print welcome messages
        System.out.println("=======================================");
        System.out.println("Welcome to Geopal. by Nadeem I. Samaali");
        System.out.println("=======================================");
        System.out.println("");

        
        //Creating a scanner to input information
        try (Scanner input = new Scanner(System.in)) 
        {
            label :

            while (true)
            {
                //Inputing the amount of points to be created
                System.out.println(">>Insert the amount of points to be created : " + ans1);
                ans1 = input.nextLine();
                int numreturn = (int)(Double.parseDouble(ans1));

                System.out.println("");
                System.out.println(">>Insert the X and Y value of each coordinate");
                System.out.println("");

                //Create points 
                Point[] point = new Point[numreturn];
                for(int i = 0; i < numreturn; i++)
                    point[i] = new Point();

                //Saving each coordinate to a point
                for(int l = 0; l < numreturn; l++)
                {
                    resetAnswers();
                    System.out.println("Coordinate " + (l+1) + " ---");

                    //Recording the x value of the coordinate
                    System.out.print("x : " + ans1);
                    ans1 = input.nextLine();
                    point[l].setX(Double.parseDouble(ans1));

                    //Recording the y value of the coordinate
                    System.out.print("y : " + ans2);
                    ans2 = input.nextLine();
                    point[l].setY(Double.parseDouble(ans2));

                    //Print coordinate
                    System.out.println("(" + point[l].getX() + ", " + point[l].getY() +")");
                    System.out.println("");
                }
                
                //Check for duplicate coordinates
                for(int i = 0; i < numreturn; i++)
                    for(int j = i + 1; j < numreturn; j++)
                    {
                        if(point[i].getX() == point[j].getX() && point[i].getY() == point[j].getY())
                        {
                            System.out.println("Error : Duplicate coordinate(s)!");
                            break label;
                        }
                    }
                
                //Create storage units for coord. multiplication
                double calc1[] = new double[numreturn];
                double calc2[] = new double[numreturn];

                //Calculating the products of the first batch of multiplications
                for(int j = 0; j < (numreturn - 1); j++)
                    calc1[j] = (point[j].getX()) * (point[j + 1].getY());

                calc1[numreturn - 1] = (point[numreturn - 1].getX()) * (point[0].getY());

                //Calculating the products of the second batch of multiplications
                for(int k = 0; k < (numreturn - 1); k++)
                    calc2[k] = point[k].getY() * point[k + 1].getX();

                calc2[numreturn - 1] = (point[numreturn - 1].getY()) * (point[0].getX());

                //Calculating the sum of the products in the first batch of multiplications
                double sum1 = 0;
                for(int m = 0; m < numreturn; m++)
                    sum1 = calc1[m] + sum1;

                //Calculating the sum of the products in the second batch of multiplications
                double sum2 = 0;
                for(int n = 0; n < numreturn; n++)
                    sum2 = calc2[n] + sum2;

                //Create storage unit for the distance between points
                double distance[] = new double[numreturn];

                //Calculate the distance between each point and store it into a distance double
                for(int o = 0; o < (numreturn - 1); o++)
                {
                    distance[o] = (Math.sqrt(Math.pow(point[o + 1].getX() - point[o].getX(), 2) + Math.pow(point[o + 1].getY() - point[o].getY(), 2)));
                }

                //Calculate the distance between the first and last point
                distance[numreturn - 1] = Math.abs(Math.sqrt(Math.pow(point[0].getX() - point[numreturn-1].getX(), 2) + Math.pow(point[0].getY() - point[numreturn - 1].getY(), 2)));

                //Calculate the sum of the distances to get the perimiter
                double sum3 = 0;
                for(int p = 0; p < numreturn; p++)
                    sum3 = distance[p] + sum3;

                //Print the value of the area of the shape
                System.out.println("=======================================");
                System.out.println("The area of this shape is " + (Math.abs((sum1-sum2)/2) + " u²"));
                System.out.println("The perimiter of this shape is " + sum3 + " u");
                System.out.println("=======================================");
                System.out.println("");

                resetAnswers();
                numreturn= 0;

            }

            input.close();    
        }
    }
}

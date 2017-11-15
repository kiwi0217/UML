package judge;

import java.awt.Point;


public class triangleArea
{ 
    private static triangleArea uniqueInstance;
    private triangleArea(){}
    public static triangleArea getInstance()
    {
        if(uniqueInstance == null)
        {
            uniqueInstance = new triangleArea();
        }  
        return uniqueInstance;
    }
    public double getTA(Point point1, Point point2, Point point3)
    {
        int x1 = point1.x;
        int x2 = point2.x;
        int x3 = point3.x;
        int y1 = point1.y;
        int y2 = point2.y;
        int y3 = point3.y;
        double triArea = ((x3-x1)*(y2-y1) - (x2-x1)*(y3-y1))/2.0;//算面G
        return Math.abs(triArea);
    }
}

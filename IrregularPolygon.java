import java.awt.geom.*;
import java.util.ArrayList;
import gpdraw.*;

class MyDrawingTool extends DrawingTool
{
    public void drawLinem(double x, double y)
    {
        super.drawLine(x, y);
    }
}

public class IrregularPolygon{
    private ArrayList <Point2D.Double> myPolygon;

    // constructors
    public IrregularPolygon()
    {
        //Point2D.Double(double x, double y);
        myPolygon = new ArrayList<Point2D.Double>() ;

    }
    // public methods
    public void add(Point2D.Double aPoint)
    {
        myPolygon.add( aPoint) ;

    }

    public void draw()
    {

        MyDrawingTool pencil;
        pencil = new MyDrawingTool();
        pencil.setWidth(5);
        for(int i1 = 0 ; i1< myPolygon.size() ; i1++)
        {
            double x1, y1 ;
            Point2D.Double p1 = myPolygon.get( i1) ;
            //System.out.println( i1 ) ;
            if( i1 < myPolygon.size()-1)
            {
                Point2D.Double p2 = myPolygon.get( i1+1) ;
                if( i1 == 0 )
                    pencil.up();

                pencil.move( p1.getX(), p1.getY());
                if( i1== 0 ) 
                    pencil.down() ; 
                pencil.drawLinem( p2.getX() , p2.getY());

            }
            else
            {
                Point2D.Double p2 = myPolygon.get(0) ;
                pencil.move( p1.getX(), p1.getY());
                pencil.drawLinem( p2.getX() , p2.getY());

            }

        } //for

    }

    public double perimeter()
    {
        double sum = 0;
        for(int i1 = 0 ; i1< myPolygon.size() ; i1++)
        {
            double x1, y1 ;
            Point2D.Double p1 = myPolygon.get( i1) ;
            // System.out.println( i1 ) ;
            if( i1 < myPolygon.size()-1)
            {
                Point2D.Double p2 = myPolygon.get( i1+1) ;
                sum = sum + Math.sqrt( (p1.getX()-p2.getX()) * (p1.getX()-p2.getX()) + 
                    (p1.getY()-p2.getY()) * (p1.getY()-p2.getY())  );
                //System.out.println( "sum=" + sum ) ;

            }
            else
            {
                Point2D.Double p2 = myPolygon.get(0) ;
                sum = sum + Math.sqrt( (p1.getX()-p2.getX()) * (p1.getX()-p2.getX()) + 
                    (p1.getY()-p2.getY()) * (p1.getY()-p2.getY())  );
                // System.out.println( "sum=" + sum ) ;

            }
        } //for
        return sum ;
    }

    public double area()
    {
        double sum1 = 0 , sum2 = 0;
        for(int i1 = 0 ; i1< myPolygon.size() ; i1++)
        {
            double x1, y1 ;
            Point2D.Double p1 = myPolygon.get( i1) ;
            //System.out.println( i1 ) ;
            if( i1 < myPolygon.size()-1)
            {
                Point2D.Double p2 = myPolygon.get( i1+1) ;
                sum1 = sum1 + p1.getX() * p2.getY();
                sum2 = sum2 + p1.getY() * p2.getX();
                // System.out.println( "sum=" + sum1 ) ;

                // System.out.println( "sum=" + sum2 ) ;

            }
            else
            {
                Point2D.Double p2 = myPolygon.get(0) ; 
                sum1 = sum1 + p1.getX() * p2.getY();
                sum2 = sum2 + p1.getY() * p2.getX();
                //System.out.println( "sum=" + sum1 ) ;

                //System.out.println( "sum=" + sum2 ) ;

            }
        } //for

        return Math.abs(sum1-sum2) / 2.0 ;

    }
    public static void main(String args[])
    {
        IrregularPolygon obj1 = new IrregularPolygon();
        //obj1.add( new Point2D.Double(100,100) ) ;
        //obj1.add( new Point2D.Double(200,300) ) ;
        //obj1.add( new Point2D.Double(200,100) ) ;
        obj1.add(new Point2D.Double(20,10));
        obj1.add(new Point2D.Double(70,20));
        obj1.add(new Point2D.Double(50,50));
        obj1.add(new Point2D.Double(0,40));

        obj1.draw() ;
        obj1.area() ; 
        System.out.println("Perimeter of the polygon is :" + obj1.perimeter());
        System.out.println("Area of the polygon is :" + obj1.area());

    }
}

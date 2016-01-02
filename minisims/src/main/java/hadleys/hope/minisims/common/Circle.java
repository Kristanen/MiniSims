package hadleys.hope.minisims.common;

import org.apache.commons.math3.linear.RealMatrix;

/**
 * Can be used to present circle shape.
 * @author Krista Iltanen
 */
public class Circle {
    
    private RealMatrix center;
    private double ray;
    
    public Circle(final RealMatrix center, final double ray) {
        this.center = center;
        this.ray = ray;
    }
    
    public RealMatrix getCenter() {
        return this.center;
    }
    
    public void setCenter(RealMatrix center) {
        this.center = center;
    }
    
    public double getRay() {
        return this.ray;
    }
}
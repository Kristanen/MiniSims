package hadleys.hope.minisims.common;

import org.apache.commons.math3.linear.RealMatrix;

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
    
    public double getRay() {
        return this.ray;
    }
}
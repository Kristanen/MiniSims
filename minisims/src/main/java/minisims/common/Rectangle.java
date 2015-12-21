package minisims.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.Array2DRowRealMatrix;

public class Rectangle {
    
    private RealMatrix pointA;
    private RealMatrix pointB;
    private RealMatrix pointC;
    private RealMatrix pointD;
    
    public Rectangle(final RealMatrix pointA, final RealMatrix pointB, final RealMatrix pointC, final RealMatrix pointD) {
        this.pointA = pointA;
        this.pointB = pointB;
        this.pointC = pointC;
        this.pointD = pointD;
    }
    
    public List<RealMatrix> getPoints() {
        List<RealMatrix> points = new ArrayList<RealMatrix>();
        points.addAll(Arrays.asList(this.pointA, this.pointB, this.pointC, this.pointD));
        return points;
    }
    
    public void setLocation(RealMatrix leftCorner) {
        RealMatrix newPointB = leftCorner.add(this.pointB.subtract(this.pointA));
        RealMatrix newPointC = leftCorner.add(this.pointC.subtract(this.pointA));
        RealMatrix newPointD = leftCorner.add(this.pointD.subtract(this.pointA));
        
        this.pointA = leftCorner;
        this.pointB = newPointB;
        this.pointC = newPointC;
        this.pointD = newPointD;
    }
    
    public void globalRotate(final double angleRad) {
        this.pointA = this.globalRotate(angleRad, pointA);
        this.pointB = this.globalRotate(angleRad, pointB);
        this.pointC = this.globalRotate(angleRad, pointC);
        this.pointD = this.globalRotate(angleRad, pointD);
    }
    
    public String toString() {
        return "A: " + this.pointA + "\nB: " +  this.pointB + "\nC: " + this.pointC + "\nD: " + this.pointD;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.pointA);
        hash = 67 * hash + Objects.hashCode(this.pointB);
        hash = 67 * hash + Objects.hashCode(this.pointC);
        hash = 67 * hash + Objects.hashCode(this.pointD);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rectangle other = (Rectangle) obj;
        if (!Objects.equals(this.pointA, other.pointA)) {
            return false;
        }
        if (!Objects.equals(this.pointB, other.pointB)) {
            return false;
        }
        if (!Objects.equals(this.pointC, other.pointC)) {
            return false;
        }
        if (!Objects.equals(this.pointD, other.pointD)) {
            return false;
        }
        return true;
    }
    
    
    
    private RealMatrix globalRotate(final double angleRad, final RealMatrix columnVector) {
        final double[][] matrixData = { {Math.cos(angleRad), -1.0 * Math.sin(angleRad)}, {Math.sin(angleRad), Math.cos(angleRad)} };
        final RealMatrix rotationMatrix = new Array2DRowRealMatrix(matrixData);
        
        return columnVector.multiply(rotationMatrix);
    }
}

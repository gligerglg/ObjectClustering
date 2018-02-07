package gligerglg.plugins.objectclustering;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gayan Lakshitha on 2/6/2018.
 */

public class Centroid {
    private double x;
    private double y;
    private List<DataPoint> DataPoints = new ArrayList<DataPoint>();

    public Centroid() { }

    public Centroid(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void AddDataPoint(DataPoint data)
    {
        DataPoints.add(data);
    }

    public void SetMyLocation()
    {
        double new_x = 0, new_y = 0;
        for (int i = 0; i < DataPoints.size(); i++)
        {
            new_x += DataPoints.get(i).getX();
            new_y += DataPoints.get(i).getY();
        }

        try
        {
            new_x /= DataPoints.size();
            new_y /= DataPoints.size();

            this.x = new_x;
            this.y = new_y;
        }
        catch (Exception ex) { }
    }

    public void ReleasePoints()
    {
        DataPoints.clear();
    }
}

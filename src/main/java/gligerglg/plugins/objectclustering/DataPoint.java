package gligerglg.plugins.objectclustering;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gayan Lakshitha on 2/6/2018.
 */

public class DataPoint {
    private int x;
    private int y;
    private List<Centroid> CentroidList = new ArrayList<Centroid>();

    public DataPoint() { }

    public DataPoint(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addCentroid(Centroid centroid)
    {
        CentroidList.add(centroid);
    }

    public int GetAssignedCentroidIndex()
    {
        double min_distance = GetDistance(this, CentroidList.get(0));
        int index = 0;
        for (int i = 0; i < CentroidList.size(); i++)
        {
            if(min_distance>=GetDistance(this,CentroidList.get(i)))
            {
                min_distance = GetDistance(this,CentroidList.get(i));
                index = i;
            }
        }

        return index;
    }

    private double GetDistance(DataPoint data, Centroid centroid)
    {
        return (Math.sqrt(Math.pow((centroid.getX() - data.getX()), 2) + Math.pow((centroid.getY() - data.getY()), 2)));
    }

    public void ReleasePoints()
    {
        CentroidList.clear();
    }
}

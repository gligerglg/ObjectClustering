package gligerglg.plugins.objectclustering;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gayan Lakshitha on 2/6/2018.
 */

public class ClusterObject {
    List<DataPoint> PointList = new ArrayList<DataPoint>();
    List<Centroid> CentroidList = new ArrayList<Centroid>();
    int count = 0;

    public ClusterObject() {

    }

    public ClusterObject(List<DataPoint> pointList, List<Centroid> centroidList) {
        for(Centroid centroid : centroidList)
            CentroidList.add(new Centroid(centroid.getX(),centroid.getY()));
        for(DataPoint dataPoint : pointList)
            PointList.add(new DataPoint(dataPoint.getX(),dataPoint.getY()));
    }

    public void setDataList(List<DataPoint> pointList) {
        PointList = pointList;
    }

    public void setCentroidList(List<Centroid> centroidList) {
        CentroidList = centroidList;
    }

    public List<Centroid> getCentroidList() {
        return CentroidList;
    }

    private void ClusterAlgorithm()
    {
        //Assign Centroids to all points
        for (int i = 0; i < PointList.size(); i++)
        {
            for (int j = 0; j < CentroidList.size(); j++)
            {
                PointList.get(i).addCentroid(CentroidList.get(j));
            }
        }

        //Assign each points to Centroids
        for (int i = 0; i < PointList.size(); i++)
        {
            int centroidIndex = PointList.get(i).GetAssignedCentroidIndex();
            CentroidList.get(centroidIndex).AddDataPoint(PointList.get(i));
        }

        //Get mean of distance and set centroid's location
        for (int i = 0; i < CentroidList.size(); i++)
        {
            CentroidList.get(i).SetMyLocation();
        }

        //Release Centroids and Datapoints
        for (int i = 0; i < PointList.size(); i++)
            PointList.get(i).ReleasePoints();
        for (int i = 0; i < CentroidList.size(); i++)
            CentroidList.get(i).ReleasePoints();
    }

    public void Cluster()
    {
        Boolean clustered = false;
        List<Centroid> CentroidList_Prev = new ArrayList<Centroid>();
        for(Centroid centroid : CentroidList)
            CentroidList_Prev.add(new Centroid(centroid.getX(),centroid.getY()));

        while(!clustered)
        {
            ClusterAlgorithm();

            for (int i = 0; i < CentroidList.size(); i++)
            {
                if ((CentroidList_Prev.get(i).getX() == CentroidList.get(i).getX()) && (CentroidList_Prev.get(i).getY() == CentroidList.get(i).getY()))
                    clustered = true;
                else
                {
                    clustered = false;
                    break;
                }
            }

            for (int i = 0; i < CentroidList.size(); i++)
            {
                CentroidList_Prev.get(i).setX(CentroidList.get(i).getX());
                CentroidList_Prev.get(i).setY(CentroidList.get(i).getY());
            }

            count++;
        }

        CentroidList_Prev.clear();
    }

    public void Flush()
    {
        PointList.clear();
        CentroidList.clear();
        count = 0;
    }

    public int GetIterations()
    {
        return count;
    }
}

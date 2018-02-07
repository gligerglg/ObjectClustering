# ObjectClustering (gliger.glg)
ObjectClustering is an Object based Clustering Algorithm


<h3>What is ObjectClustering</h3>

Object based Clustering Algorithm can be used in any android project which is used to solve cluster based problems. Normally clustering algorithms are designed using arrays, but here java objects are used for the design of the algorithm. 

<h3>How Works?</h3>
<h4>Step : 1</h4>
Here we use 3 Java classes. Centroid, DataPoint & ClusterObject. You are able to define any number of data points & centroids using Java Lists.</br>

<pre><code>
        List &ltDataPoint&gt PointList = new ArrayList<>();
        List &ltCentroid&gt CentroidList = new ArrayList<>(); 
</code></pre>

<h4>Step : 2</h4>
Initialize data set and centroids. In this step you can import external data set or directly insert data to Lists created before.

<pre><code>
        PointList.add(new DataPoint(675,12));
        PointList.add(new DataPoint(123, 13));
        PointList.add(new DataPoint(428, 65));
        . . . . . 

        CentroidList.add(new Centroid(34,78));
        CentroidList.add(new Centroid(65, 189));
        . . . . . 
</code></pre> 
<h4>Step : 3</h4>
Create a ClusterObject instance and initialize it.
<pre><code>
        ClusterObject clusterObject = new ClusterObject(PointList,CentroidList);
</code></pre>
Invoke the method to perform clustering algorithm
<pre><code>
        clusterObject.Cluster();
</code></pre>
Now the clusterd centroids are ready to return. Using a List clustered centroid can be stored.
<pre><code>
        List<Centroid> newlist = clusterObject.getCentroidList();
</code></pre>
Finally invoke the method Flush() to release stored data in clusterObject.
<pre><code>
        clusterObject.Flush();
</code></pre>
That's all. 🍨 

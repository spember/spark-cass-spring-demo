# Spark + Cassandra + Spring Boot Demo

This extremely trivial app attempts to demonstrate the difficulty with of working with Spark + Cassandra + Spring, 
but with Spark in particular


#### Difficulty of Working With Spark

TODO, although it comes down to Classpath and where the code gets executed.


#### Structure
This is a multi-project build containing:

* spark-shared: a library containing all classes and spark execution code that should be distributed out to your cluster 
using context.addJar()
 * spark-spring-demo: the main driver application. It creates the JavaSparkConf, the JavaSparkContext, and then executes jobs
 in the library on the context.

#### Running the app

* download the project
* start up cassandra
* the easiest command is `gradle spark-shared:pTML spark-spring-demo:bootRun`. This will package the library and push it to your local Maven repository, then startup the main app
* navigate to `localhost:8080/api/stocks` to kick off the process
 
 
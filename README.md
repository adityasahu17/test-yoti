# test-yoti

I have implemented this webservice with the help of JAX-RS Jersey api .
# Run:
Its a maven project, import it on your workspace

  -$ mvn clean build
  
  -Deploy on server
  
  -Run the test cases
  
  -hit http://localhost:8088/test-yoti/hover from postman with payload

# Web.xml - I have used xml configuration for sevelet rather than Annotation because I believe it is always helpful to look for a configuration in XML then in java.

# HoverRestService.java - Rest Controller for Interaction with Request.

# HoverService.java - Service layer

# HoverServiceImpl.java - Service layer implementation

# HoverRestDAO.java - DAO layer for interaction with database, but right now I am not sure what level of database I have to design so, I have just created a dummy database.

# HoverRestServiceTest.java - Test class using JUnit and Jersey Test

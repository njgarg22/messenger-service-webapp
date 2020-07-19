# messenger-service-webapp

## Description

The aim of this project is to create a simple `RESTful` service using `Jersey`. It's a JavaEE web application that can be packaged as `WAR` and deployed on any servlet container of your choice (Though I've used `Apache Tomcat`).

## Object Model

In our object model, we will be interacting with `Messages` & `Profiles`. These will be our top-level resources. Following is a list of URIs that will be exposed in our system:

```
/messages
/messages/{id}
/profiles
/profiles/{id}
```

## Structure

1. As per standard `Maven` project structure, source code is present at `src/main/java`. 
1. All the web application files are present at `src/main/webapp` and the standard Java EE web application `web.xml` deployment descriptor can be found at `src/main/webapp/WEB-INF`.
1. http://localhost:8080/messenger-service-webapp/ served by `src/main/webapp/index.jsp`.

## Resources

1. Resource Endpoint accesible at http://localhost:8080/messenger-service-webapp/webapi/myresource

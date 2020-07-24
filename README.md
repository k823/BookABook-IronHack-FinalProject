![IronHack Logo](https://s3-eu-west-1.amazonaws.com/ih-materials/uploads/upload_d5c5793015fec3be28a63c4fa3dd4d55.png)

# IronHack Final Project - BOOKABOOK

<p align="center"><strong> Jorge Morales </strong></p>

* [Goal](#goal)

* [Tools](#tools)

* [How it works](#how-it-works)

* [Documentation](#documentation)

* [Test Coverage](#test-coverage)

* [**Deployment**](#deployment)

* [**Angular**](#angular)



## <a name="goal"></a>Goal
The Goal of this project is making a recap of all the contents seen throughout the course. To do so, we will have to implement Spring Microservices as the backend, allowing to use a distributed system architecture, which improves efficiency, scalability and computing power. And implementing Angular for the User Interface. The proposal for this application is a small software for buying books, although is a pretty standard proposal, the project has plenty of room for growing as needed. And the main focus is making a secure, robust and scalable application.

The application has been splitted into the following services: 

- [eureka-server
](#): This is the Eureka server which will be used to orchestrate all the running services, you can check that Eureka is running and the subsequent microservices connected to it in [http://localhost:8761/
](http://localhost:8761/).


- [edge-service
](#): This service is used as the entry point of the application. It is placed on the 8080 port and will handle all further requests attached to the rest of microservices, it is also responsible for controlling the security of the API to access the endpoints. 

- [book-service
](#): This service manages the Books entity and its persistance in a SQL database.

- [clients-service
](#): Clients are allowed to buy books and can check the balance of their accounts, also implemented with an SQL database to persist them.

- [accounts-service
](#): Accounts are associated to a client but in a independent service to explore different functionalities in a future version of the application, they are also stored in a SQL database.

- [sales-service
](#): This service keeps track of the sales made through the application, records are allocated in a MongoDB database to ease the access to it. 

#### Overall diagram

<a href="https://ibb.co/fQmBkQt"><img src="https://i.ibb.co/qxbXNx9/BOOKABOOK-Diagram.png" alt="BOOKABOOK-Diagram" border="0"></a>

## <a name="how-it-works"></a>How it works

First of all, in the current page, click the "Code" button and copy the route. 

<a href="https://imgbb.com/"><img src="https://i.ibb.co/SQDcTMR/Captura-de-pantalla-de-2020-07-24-02-32-44.png" alt="Captura-de-pantalla-de-2020-07-24-02-32-44" border="0"></a>

Then open your terminal and paste your clipboard or type: 

`$ git clone https://github.com/k823/BookABook-IronHack-FinalProject.git
`

In order to get the whole project up and running, you must first start the Eureka Server and then all of the services. You can do this either clicking "Run" on the Main Class of each project or typing "mvn spring-boot:run" in the terminal, once located in the project directory.

Then you can either check the Swagger Documentation below, which will provide you with all the routes and its functioning, or check the [edge-service
](#) where all the main routes are allocated in each controller.

If you are making the requests through Postman, you must set Authorization Type to "Basic Auth" and set "username" and "password" to "**admin**" or "**jorge**" as shown below to access as an **Administrator**, otherwise you can access with **Client** credentials where "username" and "password" is "**pepe**".

<a href="https://ibb.co/x58YR5s"><img src="https://i.ibb.co/ggFdBg7/Captura-de-pantalla-de-2020-07-09-20-02-26.png" alt="Captura-de-pantalla-de-2020-07-09-20-02-26" border="0"></a>

## <a name="documentation"></a>Documentation

1. When you enter [THIS LINK](http://localhost:8080/swagger-ui.html) you'll find the following configuration, where all models specifications are displayed and the routes of the requests with their own specifications as well.

<p align="center">
<img width="550" height="390" src="https://i.ibb.co/jzQQNYZ/Screenshot-from-2020-06-17-15-46-46.png">
</p>

2. You can see each Request's details, for example for creating a new SalesRep, we can just pass the values desired into their respective place and you can create a new SalesRep, as it can be seen bellow.

<p align="center">
<img width="550" height="390" src="https://i.ibb.co/8X0H4Gk/Screenshot-from-2020-06-17-15-47-25.png">
</p>

3. You can also check the details from all model created, as it can be seen bellow for example for the Account Entity.

<p align="center">
<img width="550" height="390" src="https://i.ibb.co/sPTBZCS/Screenshot-from-2020-06-17-15-47-41.png">
</p>

## <a name="test-coverage"></a>Test Coverage
* In the **Java Program** in IntelliJ our test coverage is displayed below by services: 

<a href="https://ibb.co/cT5CstN"><img src="https://i.ibb.co/XJB3Gpz/Desktop-1.png" alt="Desktop-1" border="0"></a>

You can check all the unit and integration tests in each project by clicking "Run all tests with Coverage" in the main folder once opened in IntelliJ. 

Please note that for route testing you will need to get the whole project running.

All routes have been tested and can be checked either with Postman or Swagger.

## <a name="deployment"></a><strong>Deployment</strong>

The whole application has been deployed in Heroku and is fully working. 

## <a name="angular"></a>Angular
# BookABook

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 10.0.1.

## Development server

Run `ng serve` for a dev server. Navigate to `http://localhost:4200/`. The app will automatically reload if you change any of the source files.

## Code scaffolding

Run `ng generate component component-name` to generate a new component. You can also use `ng generate directive|pipe|service|class|guard|interface|enum|module`.

## Build

Run `ng build` to build the project. The build artifacts will be stored in the `dist/` directory. Use the `--prod` flag for a production build.

## Running unit tests

Run `ng test` to execute the unit tests via [Karma](https://karma-runner.github.io).

## Running end-to-end tests

Run `ng e2e` to execute the end-to-end tests via [Protractor](http://www.protractortest.org/).

## Further help

To get more help on the Angular CLI use `ng help` or go check out the [Angular CLI README](https://github.com/angular/angular-cli/blob/master/README.md).

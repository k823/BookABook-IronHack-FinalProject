![IronHack Logo](https://s3-eu-west-1.amazonaws.com/ih-materials/uploads/upload_d5c5793015fec3be28a63c4fa3dd4d55.png) <img src="https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Fyt3.ggpht.com%2F-ucfOhKHcl_w%2FAAAAAAAAAAI%2FAAAAAAAAAAA%2FmzypJuHb_go%2Fs900-c-k-no%2Fphoto.jpg&f=1&nofb=1" alt="drawing" width="100"/>

# IronHack-Santander Final Project - BOOKABOOK

<p align="center"><strong> Jorge Morales </strong></p>

* [Goal](#goal)

* [Tools](#tools)

* [How it works](#how-it-works)

* [Documentation](#documentation)

* [Test Coverage](#test-coverage)

* [Deployment](#deployment)

* [Angular](#angular)

* [Snapshots](#snapshots)


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


## <a name="tools"></a>Tools
- IntelliJ (Compile and run Java Program, JDK 11)
- VSCode (Angular App)
- Spring Boot and Spring Cloud Netflix Dependencies
- MySQL
- MongoDB
- Postman
- Swagger (API Document with HTML)
- Drawio (Draw User Case Diagram and Class Diagram)

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

1. When you enter [THIS LINK](https://edge-bookabook.herokuapp.com/swagger-ui.html#/) you'll find the following configuration, where all models specifications are displayed and the routes of the requests with their own specifications as well.

<a href="https://ibb.co/HVVk0q8"><img src="https://i.ibb.co/BttSmBM/Captura-de-pantalla-de-2020-07-24-11-46-55.png" alt="Captura-de-pantalla-de-2020-07-24-11-46-55" border="0"></a>

2. You can see each Request's details, for example for creating a new Account, we can just pass the values desired into their respective place and you can create it, as it can be seen bellow.

<a href="https://ibb.co/ZTMmC8N"><img src="https://i.ibb.co/BsCNRZw/Captura-de-pantalla-de-2020-07-24-11-47-05.png" alt="Captura-de-pantalla-de-2020-07-24-11-47-05" border="0"></a>

3. You can also check the details from all model created, as it can be seen bellow for example for the Account Entity.

<a href="https://ibb.co/7XTzydV"><img src="https://i.ibb.co/80RB8L2/Captura-de-pantalla-de-2020-07-24-11-49-09.png" alt="Captura-de-pantalla-de-2020-07-24-11-49-09" border="0"></a>

## <a name="test-coverage"></a>Test Coverage
* In the **Java Program** in IntelliJ the test coverage is displayed below by services: 

<a href="https://ibb.co/7XLKxMG"><img src="https://i.ibb.co/9NSWmKq/Desktop-1.png" alt="Desktop-1" border="0"></a><br /><a target='_blank' href='https://imgbb.com/'></a><br />

You can check all the unit and integration tests in each project by clicking "Run all tests with Coverage" in the main folder once opened in IntelliJ. 

Please note that for route testing you will need to get the whole project running.

All routes have been tested and can be checked either with Postman or Swagger.

## <a name="deployment"></a><strong>Deployment</strong>

The whole application backend has been deployed in Heroku and is fully working. 

You can access all endpoints in: https://edge-bookabook.herokuapp.com/

<a href="https://ibb.co/kMxX90P"><img src="https://i.ibb.co/FnKz0Jd/Desktop-2.png" alt="Desktop-2" border="0"></a>

<a href="https://ibb.co/FDGzjrJ"><img src="https://i.ibb.co/6W6FfMb/Captura-de-pantalla-de-2020-07-24-11-35-08.png" alt="Captura-de-pantalla-de-2020-07-24-11-35-08" border="0"></a>

Also, the Angular frontend has been deployed in Google Firebase and is fully functional. 

You can access the app in the following route: 

https://bookabook-7ab98.web.app/login

<a href="https://ibb.co/Fz6VrPQ"><img src="https://i.ibb.co/tDBXGd0/Captura-de-pantalla-de-2020-07-24-12-33-05.png" alt="Captura-de-pantalla-de-2020-07-24-12-33-05" border="0"></a>


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

## <a name="snapshots"></a>Snapshots

### LOGIN 

<a href="https://ibb.co/3Nm82KJ"><img src="https://i.ibb.co/mq5Ykpx/Captura-de-pantalla-de-2020-07-24-18-54-09.png" alt="Captura-de-pantalla-de-2020-07-24-18-54-09" border="0"></a>

### ADMIN

<a href="https://ibb.co/CJknSsz"><img src="https://i.ibb.co/pWt3krx/Captura-de-pantalla-de-2020-07-24-18-12-55.png" alt="Captura-de-pantalla-de-2020-07-24-18-12-55" border="0"></a>

<a href="https://ibb.co/gWxgY12"><img src="https://i.ibb.co/5jPcZD0/Captura-de-pantalla-de-2020-07-24-18-35-40.png" alt="Captura-de-pantalla-de-2020-07-24-18-35-40" border="0"></a>

<a href="https://ibb.co/7NtBL6L"><img src="https://i.ibb.co/4gRC353/Captura-de-pantalla-de-2020-07-24-18-36-44.png" alt="Captura-de-pantalla-de-2020-07-24-18-36-44" border="0"></a>

### CLIENT

<a href="https://ibb.co/K9RFzxN"><img src="https://i.ibb.co/Vvr2pYH/Captura-de-pantalla-de-2020-07-24-18-37-46.png" alt="Captura-de-pantalla-de-2020-07-24-18-37-46" border="0"></a>

<a href="https://ibb.co/fHGShwQ"><img src="https://i.ibb.co/vkvB7nD/Captura-de-pantalla-de-2020-07-24-18-37-35.png" alt="Captura-de-pantalla-de-2020-07-24-18-37-35" border="0"></a><br /><a target='_blank' href='https://imgbb.com/'>editar img</a><br />

Thanks! :D

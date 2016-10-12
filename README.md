# Enderase Task Management API

## Introduction

Enderase would be a task management framework that would be used for listing tasks for that one would be interested to accomplish it and interested professionals would pick those tasks and **GET IT DONE**

As of this writing, the task manager is at its infant stage. A lot would be added as the project advances. 

It is open for public and anyone who is interested can pick the projet and proceed. I will comeup with featutres and use cases that needed to be done with priorities.

This is 100% API based implementation and the front end is another implementation that would consume the API

As of the now the technologies used are:

 * java - A main programming language the app is written
 * maven - dependency and deployment manager
 * jersey - RESTful framework
 * hibernate - ORM that is mapping the tables in mysql
 * mysql - the underlying database
 * git - Version Control System


## How to run the project locally

Go to a folder where you would be storing the endrase code base

grab the code base from git:
```shell
git clone https://github.com/gullele/enderase.git enderase
```

If you don't have maven already installed, install maven. You can get how to install maven [here](https://maven.apache.org/install.html)

Go to enderase folder and run
```
mvn install
```
It might take a bit, but wait for it and you will see maven pulling all the dependencies to you.

Then move to your editor, most probably eclipse and load the enderase project.

If you are working on eclipse, then issue 
```
mvn eclipse:eclipse
```

The above command would take care of the dependencies for maven

You would also need a mysql database running locally with enderase database. For what tables are going to be needed you can see from com.enderase.entities folder.

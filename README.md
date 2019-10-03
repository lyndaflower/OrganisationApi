# Organisation-News-Portal
<img src= "images/home.png">
<img src= "images/depart.png">
<img src= "images/user.png">
<img src= "images/new.png">

#Description

Organisation-news-portal is where user can make more details to  department by adding news related to department and also see how many employees are in department

#Author

author:lynda flower

# User story

* Users can click on navigation bar on create user (name,role,position and department number).
* Fill the form to create user or report his/her department and adding numbers of employees.
* Fill the form to add news.
* After filling form you check whether your answers becomes successfully.

# PRE-REQUISITES

A couple of things to get you started:

1.Ensure you have Java installed
A simple way to install Java is using sdkman.

Simply follow the instructions to have sdkman installed and install java:

    sdk install java
    
2 . Gradle
is used as the build tool and can be installed with sdkman:

                     sdk install gradle
  # SETUP/INSTALLATION
   **To create the necessary databases, launch postgres, then psql, and run the following commands:**
                       
                        CREATE DATABASE organisation;
                          \c organisation;
                         CREATE TABLE department (id serial PRIMARY KEY, name varchar, description varchar,number of employees varchar);
                         CREATE TABLE  news(id serial PRIMARY KEY, author varchar , news varchar);
                         CREATE TABLE user(is serial PRIMARY KEY, name varchar, role varchar, position varchar , number of department integer);
                         
                         
                         
# TECHNOLOGIES USED:

* Heroku

* Java - source language.

* Gradle for dependency management and running tasks.

* Bootstrap.

* Cascading Style Sheets.

* Spark

* PostgreSQL


# Support & Contact
  
*  Email Address: umurerwalynda@gmail.com.
  
* github-username: lyndaflower.


# License

The app is licensed by MIT. Copyright (c) 2019 Lynda Flower





Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.





# Insticator Questionnaire Demo

At Insticator, we provide an embed to the publisher website and the embed shows trivia, polling questions and other kinds of enaging content.

## Getting Started



### Prerequisites

What things you need to install the software and how to install them

```
Java version: 10

DB: MySQL

Framework: Spring MVC + jsp
```



## Running Application

Explain how to run the automated tests for this system

### Run

Run

```
$ mvn spring-boot:run
```
At root directory

### Open Browser

Navigate to

```
http://localhost:8080/index
```

to start your Questionnaire

Before start, click

```
admin
```

button to add four types of questions


## Authors

* **Tianyou Zhou** - *Initial work* - [tz895](https://github.com/tz895)


#Requirement

1. Please create the data structures to store these different kinds of questions that can be served to the widget.  
2. Assume each visitor has an UUID. To make them more engaging, we don't want to show the same question again after they answer it, please create an API for this web service call. Please elaborate how to make this request scalable when there are millions of questions and millision of visitors.

##Solutions
**1.To avoid duplicate questions**

Create four schemas to save the questions' id and users' answers.

**2.To make request scalable**

Since the business can be both read-heavy and write-heavy during particular time

For **read-heavy** property,  like millions visitor's requests.  What we need is just adding 
more machines with a load balancer in front of them to evenly distribute the requests(e.g. consistent hashing).

*Example*: cache problem

In this demo, to get a random question, I fetched all questions with same type and then randomly pick one
using a random index which is not feasible when questions are million level.

The better solution is get the max id of this table and randomly fetch one from database by random id.



For **write-heavy** which is uploading million level visitors' submit for questions(creating new questions is not read-heavy operation).
We can consider using Vertical scaling like saving this data into NO-SQL database.



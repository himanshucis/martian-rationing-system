# The Martian - Rationing System

You are part of the Ares III mission to Mars exploring “Acidalia Planitia” plain on Mars in the year 2035. Due to unfortunate circumstances involving a dust storm, you got stranded on Mars alone with no communication to your team or Earth’s command center.
Your surface habitat ("Hab") on Mars contains a limited inventory of food supplies. Each of these supplies is in the form of a packet containing either Food or Water. The food items have details of the content, expiry date and calories they provide. The water packet contains only the details of the quantity in liters and doesn’t expire

#### Basic feature of the application should include:

```bash
Add Ration : Record the details of the supply packet to a storage mechanism (DB, File.. etc)

View Inventory : Retrieve the details of all the supply packets in the inventory

Delete Ration : Ability to delete a supply packet from the inventory that has been consumed or needs update.

View Schedule : Retrieve the available inventory in the storage mechanism and generate the schedule.
```
## Installation

   i. Eclipse - IDE.

   ii. You just need to have Java 8 installed on your machine.

   iii. Use spring starter maven project for esealy import in (import existing maven project) in eclipse.
 
   iv. Also there some dependencies, Install all the dependencies of pom.xml. 
  
   v. For database java ORM tool hibernate create database and tables automatically.

   vi. Database all details put in application.property, Put detail's of application.property.



## Usage 
The martian - rationing system based on ration management system.
1. In this system Click Add-Food to add food with packet-Id,packet-Content,packet-Type,expiry-Date.
2. In this system Click Add-Water to add water with packet-Id,packet-Content and quantity in liter's.
3. Click inventory to show the ration in present in inventory, And also update and delete Food and Water detail's. 
4. Click Create-Schedule's to create dynamically Schedule's for Martian ration system inventory.
5. Click on View-Schedules to show inventory schedules list.
6. Click on Reset button to Reset inventory-schedules in Martian rationing system.
 
in schedules 2 ration add with both ration calories addition is equals to 2500 calories.
and water quantity in liter is 2.

#### Note :
At a time add all food and water details in inventory.then at last Click on Inventory, and Click on Create-Schedule's for Create inventory schedule's. 

#### For-Exa :

``` bash
Add Food as sample Input file
F1 Food - calories 1000
F2 Food - calories 1500
F3 Food - calories 2000
F4 Food - calories 500

Add Water as
W1 Water - quantity 2 liter
W2 water - quantity 1 liter
```
## To run the program

you just need to run program to import existing maven project from any IDE like eclipse, and run as a spring boot app. 

##### The program will execute on browser :

```bash
http://127.0.0.1:8080/controller/home
```

###### Avancerad_JAVA24_Erik_Hultqvist_Uppgift1
# Virtual Car Rental

---
## Table of Contents
1. <ins>[Description of Project](#1-description-of-project)<ins/>
2. <ins>[Running the Application](#2-running-the-application)<ins/>
3. <ins>[Architecture oversight](#3-architecture-oversight)<ins/>
---
### 1. Description of Project
This Project is a **Virtual Car Rental** application that you run in the console where you can rent 4 different vehicles,  
return them, get price information and checkout.

---
### 2. Running the Application
To run the application you can use an IDEA like; IntelliJ or VisualStudioCode and navigate through the Menu-System  
with a keyboard.

---
### 3. Architecture oversight
- The structure begins in the __*Main.java*__ file which mainly consists of **Loops**, but also setting upp the **Lists** of vehicles  
and the rented vehicle.

- Then there´s an abstract class named __*Vehicle.java*__ which contains of common attributes for the sub-vehicle classes.  
These attributes are; vehicleModel, regNumber and rentPricePerDay

- The classes that **Implements** the __*Vehicle.java*__ are; __*Car.java*__, __*SUV.java*__, __*Truck.java*__ and __*Convertible.java*__.  
These all have some specific attributes and methods.

- The **Interface** is named __*Rentable.java*__ and holds methods for renting vehicles(**rentVehicle**), calculate cost(**calculatedRent**),  
and returning vehicles(**returnVehicle**).

- The application uses a class named __*User.java*__ to keep track of the cost of what´s been rented.
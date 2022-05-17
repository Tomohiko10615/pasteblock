# Pasteblock - Backend

This project provided the backend for two differentes mobile apps.
The platform is intended to be used as an online marketplace where constructor professionals can offer their services to final clients.
Service providers can register, fill their profiles and get job opportunities, while normal users can browse profiles, contact and hire proffesionals.
It features a system where both sides can track their own historial activity inside the platform and rate themselves mutually for each concluded service.

## Schema

![Pasteblock Schema](https://github.com/Tomohiko10615/pasteblock/raw/main/schema.png)

## Stack

This project was done using Spring Framework (Spring Boot, Spring Data JPA, Spring Security, Thymeleaf)
The main Java app was hosted on Heroku, while the MySQL database was hosted in an Amazon RDS instance and photos were uploaded to Amazon S3.

![Spring](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![AWS](https://img.shields.io/badge/Amazon_AWS-232F3E?style=for-the-badge&logo=amazon-aws&logoColor=white)
![Heroku](https://img.shields.io/badge/Heroku-430098?style=for-the-badge&logo=heroku&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-00000F?style=for-the-badge&logo=mysql&logoColor=white)
![Git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)
![Eclipse](https://img.shields.io/badge/Eclipse-2C2255?style=for-the-badge&logo=eclipse&logoColor=white)

## Control Panel

It was done with Thymeleaf and bootstrap. Only users with an admin role have enough permissions.

![Control Panel](https://github.com/Tomohiko10615/pasteblock/raw/main/control-panel.png)

Admins are able to monitor the activy in the application an also have access to statistics.

![Logged-in](https://github.com/Tomohiko10615/pasteblock/raw/main/logged-in.png)

![Contracts](https://github.com/Tomohiko10615/pasteblock/raw/main/contract.png)

## API endpoints

### **Save new customer**

Type: **POST**
``` 
/login
```

**Request Body**

`Required: application/json`

##### Schema

Login details {
email*	string
password*	string
}

##### Example value

{
emsp"email: "jtejada@gmail.com",
emsp"password": "MyPassword01840"
}


**Responses**:
| Code | Description     |
| :-------- | :------- |
| `200` | `Returns application/json Login was successful` |
| `401` | `Returns application/json Login was unsuccessful` |

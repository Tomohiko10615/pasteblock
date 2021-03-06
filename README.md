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

This is not a comprehensive list. There are just some remarkable endpoints.

### **Login**

Type: **POST**
``` 
/api/login
```

**Request Body**

`Required: application/json`

##### Schema

{\
&nbsp;&nbsp;&nbsp;&nbsp;email *string\
&nbsp;&nbsp;&nbsp;&nbsp;password *string\
}

##### Example value

{\
&nbsp;&nbsp;&nbsp;&nbsp;"email: "jtejada@gmail.com",\
&nbsp;&nbsp;&nbsp;&nbsp;"password": "MyPassword01840"\
}

**Responses**:
| Code | Description     |
| :-------- | :------- |
| `200` | `Returns application/json` |
| `401` | `Returns application/json` |

If login was successful returns success = true along user data (if role is client also returns client only data):

##### Schema

{  
&nbsp;&nbsp;&nbsp;&nbsp;successful\* *boolean*    
&nbsp;&nbsp;&nbsp;&nbsp;email *string*  
&nbsp;&nbsp;&nbsp;&nbsp;nombre *string*  
&nbsp;&nbsp;&nbsp;&nbsp;clienteId *int*  
&nbsp;&nbsp;&nbsp;&nbsp;distrito *string*  
&nbsp;&nbsp;&nbsp;&nbsp;distritoId *int*  
&nbsp;&nbsp;&nbsp;&nbsp;token *string*  
&nbsp;&nbsp;&nbsp;&nbsp;JWTtoken *string*  
}

##### Example value

{\
    &nbsp;&nbsp;&nbsp;&nbsp;"JWTtoken": "eyJhbGciOiJIUzUxMiJ9.eyJhdXR9mnJpdGllcyI6IltdIiwic3ViIjoianRlamFkYUBib2xzYWRlaWRlYXMuY29tIn0.BtPAFSLaRtqFlFEZwivJW8rbviK_jZ6hKObqfOqBu3hkWvyyL_7XvbvQsYEnmkhZCoNIYdHyrLfGwsXdmQTj6Q",\
    &nbsp;&nbsp;&nbsp;&nbsp;"distrito": "Villa el Salvador",\
    &nbsp;&nbsp;&nbsp;&nbsp;"distritoId": 42,\
    &nbsp;&nbsp;&nbsp;&nbsp;"clienteId": 3,\
    &nbsp;&nbsp;&nbsp;&nbsp;"success": true,\
    &nbsp;&nbsp;&nbsp;&nbsp;"nombre": "Justo",\
    &nbsp;&nbsp;&nbsp;&nbsp;"email": "jtejada@gmail.com",\
    &nbsp;&nbsp;&nbsp;&nbsp;"token": "ExponentPushToken[rgFB-WIo5OY372osTohuPe]"\
}

If login was unsuccessful returns success = false:

##### Schema

{\
&nbsp;&nbsp;&nbsp;&nbsp;success *boolean\
}

##### Example value

{\
    &nbsp;&nbsp;&nbsp;&nbsp;"success": false\
}

### **Update Push Notification Token**

It updates the push notification token of a logged in user if the token of the device is different from the one stored in the database.

Type: **POST**
``` 
/api/token
```

**Request Body**

`Required: application/json`

**Responses**:
| Code | Description     |
| :-------- | :------- |
| `201` | `Returns true, indicating the token was successfully updated` |

### **List constructor professionals**

It lists all available constructor professionals for a determined service and district, and also sorts them by various criteria.

Type: **GET**
``` 
/api/listar/{servicioId}/{distritoId}
```

**Parameters:**
| Name | Description     |
| :-------- | :------- |
| `servicioId` **required** *path* | `Id of the service` |
| `distritoId` **required** *path* | `Id of the district` |
| `criterio` *query* | `Order criteria, default is reputacion. It can also be numero_trabajos_culminados or fecha_de_registro` |
| `orden` **required** *query* | `Order of the list. 0 for ASC, and 1 for DESC` |
| `inicio` **required** *query* | `Select which one would be the first result. Used to limit the number of results` |
| `total` **required** *query* | `Select the total number of results` |

**Responses**:
| Code | Description     |
| :-------- | :------- |
| `200` | `Returns a list a professionals` |

### **Send push notifications**

It sends push notifications to mobile devices whenever a client or a professional sends a message to each other. It also updates a message in the database.

Type: **POST**
``` 
/api/enviar
```
**Request Body**

`Required: application/json`

**Responses**:
| Code | Description     |
| :-------- | :------- |
| `201` | `Returns true indicating the message was updated` |

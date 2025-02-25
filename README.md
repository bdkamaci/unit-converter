# Unit Converter

A simple Spring Boot application for converting between different units of measurement including temperature, length, and weight.

---

## **Table of Contents**
- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
    - [Prerequisites](#prerequisites)
    - [Installation and Running](#installation-and-running)
- [API Usage](#api-usage)
  - [REST Endpoints](#rest-endpoints)
    - [Temperature Conversion](#temperature-conversion)
    - [Length Conversion](#length-conversion)
    - [Weight Conversion](#weight-conversion)
- [Running Tests](#running-tests)
- [Project Structure](#project-structure)
- [Contribution](#contribution)
- [License](#license)
- [Acknowledgments](#acknowledgments)
- [Contact](#contact)

---

## **Features**

- Temperature conversion (Celsius, Fahrenheit, Kelvin)
- Length conversion (Meter, Kilometer, Mile, Foot, Inch)
- Weight conversion (Kilogram, Gram, Pound, Ounce)
- User-friendly web interface
- RESTful API endpoints for programmatic access

---

## **Technologies Used**

- Java 21
- Spring Boot 3.2.2
- Thymeleaf for server-side templating
- Bootstrap for responsive design
- JUnit 5 for testing

---

## **Getting Started**

### **Prerequisites**

- JDK 21 or later
- Maven 3.6 or later

### **Installation and Running**

1. Clone the repository
```bash
git clone https://github.com/bdkamaci/unit-converter.git
cd unit-converter
```

2. Build the application
```bash
mvn clean install
```

3. Run the application
```bash
mvn spring-boot:run
```

4. Access the application
   Open your browser and navigate to `http://localhost:8080`

---

## **API Usage**

### **REST Endpoints**

#### **Temperature Conversion**
```
POST /api/convert/temperature
Content-Type: application/json

{
  "value": 100,
  "fromUnit": "CELSIUS",
  "toUnit": "FAHRENHEIT"
}
```

#### **Length Conversion**
```
POST /api/convert/length
Content-Type: application/json

{
  "value": 10,
  "fromUnit": "METER",
  "toUnit": "FOOT"
}
```

#### **Weight Conversion**
```
POST /api/convert/weight
Content-Type: application/json

{
  "value": 5,
  "fromUnit": "KILOGRAM",
  "toUnit": "POUND"
}
```

---

## **Running Tests**

```bash
mvn test
```

---

## **Project Structure**

```
src/
├── main/
│   ├── java/
│   │   └── com/
│   │       └── bdkamaci/
│   │           └── unitconverter/
│   │               ├── controller/
│   │               │   └── ConverterController.java
│   │               ├── enums/
│   │               │   ├── LengthUnit.java
│   │               │   ├── TemperatureUnit.java
│   │               │   └── WeightUnit.java
│   │               ├── model/
│   │               │   └── Conversion.java
│   │               ├── service/
│   │               │   ├── ConverterService.java
│   │               │   └── impl/
│   │               │       └── ConverterServiceImpl.java
│   │               └── UnitConverterApplication.java
│   └── resources/
│       ├── static/
│       │   ├── css/
│       │   │   └── style.css
│       │   └── js/
│       │       └── script.js
│       ├── templates/
│       │   ├── index.html
│       │   ├── length.html
│       │   ├── temperature.html
│       │   └── weight.html
│       └── application.properties
└── test/
    └── java/
        └── com/
            └── bdkamaci/
                └── unitconverter/
                    ├── controller/
                    │   └── ConverterControllerTest.java
                    └── service/
                        └── impl/
                            └── ConverterServiceImplTest.java
```

---

## **Contribution**

1. Fork the project
2. Create your feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

---

## **License**

This project is licensed under the MIT License - see the LICENSE file for details.

---

## **Acknowledgments**

- Spring Boot Documentation
- https://roadmap.sh/projects/unit-converter

---

## **Contact**

Created by Burcu Doga KAMACI - feel free to contact me!

---
# RestAssured API Automation Framework 🚀

## 📌 Overview
This is an **API Automation Testing Framework** built using **RestAssured (Java)**, integrated with **TestNG, Maven, and CI/CD (Jenkins/GitHub Actions)**.  
The framework is designed to automate testing for **RESTful APIs**, including validation of responses, authentication handling, and data-driven testing.

---

## 📌 Features ✅
- **Automated API Testing** using RestAssured (Java).
- **TestNG Framework** for test execution and reporting.
- **Data-Driven Testing** using JSON, CSV, and Excel.
- **Authentication Handling** (Basic Auth, OAuth2, JWT).
- **CI/CD Integration** with Jenkins/GitHub Actions.
- **Allure Reports** for visual test reporting.
- **Logging & Exception Handling** for debugging.
- **Parallel Execution** using TestNG.

---

## 📌 Tech Stack ⚙️
| **Technology**  | **Purpose** |
|----------------|------------|
| **Java**       | Main programming language |
| **RestAssured** | API Automation |
| **TestNG**     | Test execution & reporting |
| **Maven**      | Dependency management |
| **Jenkins/GitHub Actions** | CI/CD integration |
| **Allure Reports** | Test reporting |
| **JSON, CSV, Excel** | Data-driven testing |

---

## 📌 Project Structure 📂
```
RestAssured-API-Automation
│── src
│   ├── main
│   │   ├── utils
│   │   │   ├── ConfigReader.java  # Read config files
│   │   │   ├── ExcelUtil.java  # Read test data from Excel
│   │   │   ├── LoggerUtil.java  # Log handling
│   ├── test
│   │   ├── apiTests
│   │   │   ├── UserTests.java  # API Test cases
│   │   │   ├── AuthTests.java  # Authentication Tests
│   │   ├── resources
│   │   │   ├── testData.json  # Test data for API
│   ├── reports
│   │   ├── allure-results  # Allure Reports
│── pom.xml  # Maven dependencies
│── testng.xml  # TestNG test suite
│── README.md  # Documentation
```

---

## 📌 Setup & Installation 🔧
### **1️⃣ Prerequisites**
- Install **Java 11+**
- Install **Maven**
- Install **IntelliJ IDEA / Eclipse**
- Install **Allure Reports** (for reporting)

### **2️⃣ Clone the Repository**
```sh
git clone https://github.com/yourusername/RestAssured-API-Automation.git
cd RestAssured-API-Automation
```

### **3️⃣ Install Dependencies**
```sh
mvn clean install
```

### **4️⃣ Run Tests**
- Run all test cases using TestNG:
```sh
mvn test
```
- Run specific test suite:
```sh
mvn test -Dtest=UserTests
```

---

## 📌 Test Execution & Reports 📊
### **1️⃣ Run API Tests**
```sh
mvn test
```
### **2️⃣ Generate Allure Report**
```sh
allure serve target/allure-results
```
### **3️⃣ View Test Logs**
Logs are generated in the `logs/` folder.

---

## 📌 CI/CD Integration ⚡
### **GitHub Actions Workflow**
The project integrates with **GitHub Actions** to run API tests automatically on each commit.
- **.github/workflows/api-tests.yml**
```yaml
name: API Automation Tests
on: [push, pull_request]

jobs:
  test:
    runs-on: ubuntu-latest
    steps:
      - name: Checkout code
        uses: actions/checkout@v2

      - name: Set up JDK 11
        uses: actions/setup-java@v2
        with:
          java-version: '11'
          distribution: 'adopt'

      - name: Install dependencies
        run: mvn clean install

      - name: Run API Tests
        run: mvn test
```

---

## 📌 Test Cases 📝
| **Test Case**  | **API Endpoint** | **Method** | **Description** |
|---------------|----------------|------------|----------------|
| `TC_001` | `/api/users` | `GET` | Fetch list of users |
| `TC_002` | `/api/users/{id}` | `GET` | Fetch a user by ID |
| `TC_003` | `/api/users` | `POST` | Create a new user |
| `TC_004` | `/api/users/{id}` | `PUT` | Update user information |
| `TC_005` | `/api/users/{id}` | `DELETE` | Delete a user |

---

## 📌 Future Improvements 🚀
- Implement **Parallel Execution** with TestNG.
- Enhance **Performance Testing** with JMeter.
- Integrate **Database Testing** with MySQL.

---

## 📌 Contributors 👨‍💻
- **[Your Name]** - *Lead Developer*
- **[Other Contributors]** - *QA Automation Engineers*

📌 **Feel free to contribute to this project!** 🎯
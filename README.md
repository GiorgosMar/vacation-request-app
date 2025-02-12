# Vacation Tool Backend

## Overview
The **Vacation Tool Backend** is a Spring Boot application designed to manage employee vacation schedules, calculate seasonal bonuses, and track company assets such as employee-assigned products. It uses **PostgreSQL** as the database, **JWT authentication** for security, and **Postman** for API testing.

## Features
- **Employee Management**: Store employee details along with their associated company.
- **Vacation Scheduling**: Employees can schedule their vacation days.
- **Bonus Calculation**: Automatically calculates bonuses per season for employees.
- **Asset Tracking**: Stores information about the products assigned to employees (e.g., PCs, peripherals, etc.).
- **Authentication & Authorization**: Secured using JWT authentication.

## Tech Stack
- **Backend**: Spring Boot (Spring MVC, Spring Security, Spring Data JPA)
- **Database**: PostgreSQL
- **Authentication**: JWT (JSON Web Token)
- **Testing**: Postman

## Installation & Setup
### Prerequisites
Ensure you have the following installed:
- Java 17+
- PostgreSQL
- Maven

### Clone the Repository
```bash
$ git clone https://github.com/your-username/vacation-tool-backend.git
$ cd vacation-tool-backend
```

### Configure Database
Update the **application.properties** or **application.yml** file with your PostgreSQL credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/vacation_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### Build and Run the Application
```bash
$ mvn clean install
$ mvn spring-boot:run
```

The backend will start on `http://localhost:8080`.

## API Endpoints
| Method | Endpoint                           | Description                           |
|--------|-----------------------------------|--------------------------------------|
| POST   | `/auth/register`                 | Register a new user                  |
| POST   | `/auth/login`                    | Authenticate and get JWT token       |
| GET    | `/employees`                     | Retrieve all employees               |
| POST   | `/employees`                     | Add a new employee                   |
| GET    | `/vacations`                     | Get all scheduled vacations          |
| POST   | `/vacations`                     | Schedule a vacation                  |
| GET    | `/bonus`                         | Retrieve all bonuses                 |
| GET    | `/bonus/{bonusId}`               | Get bonus by ID                      |
| GET    | `/bonus/calculateOfBonus`        | Calculate seasonal bonus             |
| POST   | `/bonus/newBonus`                | Add a new bonus                      |
| POST   | `/bonus`                         | Create a new bonus                   |
| DELETE | `/bonus/{bonusId}`               | Delete a bonus                       |
| PUT    | `/bonus/{bonusId}`               | Update a bonus                       |
| GET    | `/company`                       | Retrieve all companies               |
| GET    | `/company/{companyId}`           | Get company by ID                    |
| GET    | `/company/monthlyExpenses/{companyId}` | Get monthly expenses for a company |
| POST   | `/company`                       | Register a new company               |
| DELETE | `/company/{companyId}`           | Delete a company                     |
| PUT    | `/company/{companyId}`           | Update a company                     |
| GET    | `/employee`                      | Retrieve all employees               |
| GET    | `/employee/{employeeId}`         | Get employee by ID                   |
| POST   | `/employee`                      | Register a new employee              |
| DELETE | `/employee/{employeeId}`         | Delete an employee                   |
| PUT    | `/employee/{employeeId}`         | Update an employee                   |
| GET    | `/employeeProduct/company/{companyId}` | Get employee products by company |
| GET    | `/employeeProduct`               | Retrieve all employee products       |
| GET    | `/employeeProduct/{employeeProductId}` | Get employee product by ID       |
| POST   | `/employeeProduct`               | Add a new employee product           |
| DELETE | `/employeeProduct/{employeeProductId}` | Delete an employee product       |
| PUT    | `/employeeProduct/{employeeProductId}` | Update an employee product       |
| POST   | `/users/login/authenticate`      | Authenticate a user                  |
| GET    | `/users/verify`                  | Verify user authentication           |
| GET    | `/vacationReq`                   | Retrieve all vacation requests       |
| GET    | `/vacationReq/{vacationRequestId}` | Get vacation request by ID         |
| GET    | `/vacationReq/timeline`          | Get vacation request timeline        |
| POST   | `/vacationReq`                   | Create a new vacation request        |
| DELETE | `/vacationReq/{vacationRequestId}` | Delete a vacation request         |
| PUT    | `/vacationReq/{vacationRequestId}` | Update a vacation request         |
| PUT    | `/vacationReq/status/{vacationId}` | Update vacation request status    |

### Authentication
- Use the `/auth/login` endpoint to obtain a JWT token.
- Include the token in the **Authorization** header for secured requests:
  ```http
  Authorization: Bearer your_jwt_token
  ```

## Testing with Postman
1. Import the provided Postman collection (if available).
2. Use the `/auth/login` endpoint to authenticate and receive a JWT token.
3. Test secured endpoints by including the token in the **Authorization** header.

## Contributing
Contributions are welcome! Feel free to submit a pull request.

## License
This project is licensed under the MIT License.

---
Feel free to update the repository URL, license, or any additional details specific to your project!

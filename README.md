# springboot-drools-decisiontable

- Sample Code using drools decision tables with different objects used for request condition and response Action.
- Provides examples of using boolean/string/number for CONDITION and setting array values as an ACTION in response.

## Project Dependencies

- Java 21
- Spring Boot 3.3.6
- Maven
- Drools 10.0.0

## Run Instructions

1. Clone the repository:
    ```sh
    git clone <repository-url>
    cd springboot-drools-decisiontable
    ```

2. Build the project using Maven:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```
   or run the Application.main() method from your IDE.

4. Sample Request:
    ```sh
   curl --request POST --url http://localhost:9095/eligibleRoles --header 'Content-Type: application/json' --data '{"currentRole":"DEVELOPER","domain": "TELECOM","experience":10,"referred": false}'
    ```
5. Sample Response:
    ```sh
    {
        
        "eligibleRoles": [
            "ARCHITECT",
            "MANAGER"
        ],
   "salaryPerAnnum": 90000
    }
    ```
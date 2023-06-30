<br />
<div align="center">
  <h2>User Microservice</h2>
  <p align="center">
   The backend of this system handles the management of messaging and notifications
  </p>
</div>

### Built With

* ![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=java&logoColor=white)
* ![Spring](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
* ![Gradle](https://img.shields.io/badge/Gradle-02303A.svg?style=for-the-badge&logo=Gradle&logoColor=white)
* ![Twilio](https://img.shields.io/badge/Twilio-blue?style=for-the-badge&logo=Twilio&logoColor=white)
* ![OpenAPI](https://img.shields.io/badge/OpenAPI-<COLOR>?style=for-the-badge&logo=OpenAPI%20Initiative&logoColor=white)

<!-- GETTING STARTED -->
## Getting Started

To get a local copy up and running follow these steps.

### Prerequisites

* JDK 17 [https://jdk.java.net/java-se-ri/17](https://jdk.java.net/java-se-ri/17)
* Gradle [https://gradle.org/install/](https://gradle.org/install/)

### Recommended Tools
* IntelliJ Community [https://www.jetbrains.com/idea/download/](https://www.jetbrains.com/idea/download/)
* Postman [https://www.postman.com/downloads/](https://www.postman.com/downloads/)


### Installation

1. Clone the repository
2. Change directory
   ```sh
   cd power-up-v4-messaging-twilio-v1
   ```
3. Update the messaging service connection settings
   ```yml
   # src/main/resources/application-dev.yml
   app:
      messaging:
         twilio:
            Account_SID: "<Your-Twilio-account-sid>"
            Auth_token: "<Your-Twilio-auth-token>"
            Service_SID: "<Your-Twilio-messaging-service-sid>"
   ```
<!-- USAGE -->
## Usage

1. Right-click the class MessagingTwilioApplication and choose Run
2. You must run the User Microservice project
3. Open [http://localhost:8092/swagger-ui/index.html](http://localhost:8092/swagger-ui/index.html) in your web browser

<!-- ROADMAP -->
## Tests

- Right-click the test folder and choose Run tests with coverage

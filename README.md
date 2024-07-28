1. StockExchanger application was developed as a Spring Boot application. Therefore, the main class "StockExchangerApplication" should be started to launch the application.
2. Application uses Spring Security and Basic Authentication to control access to the REST end points. Therefore, the following credentials should be used to access end-points.
   User: "stockUser" password: "pass1234"
3. Application uses Hibernate Optimistic Locking mechanism. As a result, in case of multiple users trying to update the same resource the application produces Http 409 Conflict error.
4. Postman Api Tests are included in the "Postman_Api_Tests"  folder under the base directory.
5. Development tests were run against MySql database. Db operations then switched H2 database. Db operations can now be run against in-memory H2 database.

# House Application

In this app, you can save and load data about housekeeping, track user locations, and determine if they attended the annual meeting.

The application is built in Java using Maven. You can build and run it from the terminal with the following commands:

## Run in IDE
If you run the application (specifically the HouseDataApplication class) in IntelliJ or another IDE, the database is already created and connected, so you don't need to make any changes.
## Run in terminal
Navigate to the project folder.
Execute the following command to run the application pack:

    ./mvnw package

it will create target folder. In command line change folder to /target and run command:
    
    java -jar House-0.0.1-SNAPSHOT.jar

Please be cautious, as you need to establish a connection to the database in the application.properties file if you run the application from the terminal.

## Requests

Address of API is http://localhost:8080/
I recommend using the Postman app for testing requests. You can download it from Postman's [official website](https://www.postman.com/downloads/).

### Apartments requests:

1. Get all apartments in json: (GET) http://localhost:8080/api/apartments/
   
2. Adding apartment to year meeting means Users have come there: (PUT) http://localhost:8080/api/apartments/ and json body

`{
   "apartment":4,
   "houseMeeting":3
}`

3. Get apartment by ID it is apartment number: (GET) http://localhost:8080/api/apartments/apartment_id

### Users requests:
1. Get all users: (GET) http://localhost:8080/api/users/
   
2. Get user by id: (GET) http://localhost:8080/api/users/user_id
   
3. Create new user: (POST) http://localhost:8080/api/users/ and json body

`{
   "username":"Ala",
   "email":"ala@s.z",
   "phone":125432,
   "owner":true,
   "apartment":126
}`

4. Update user: (PUT) http://localhost:8080/api/users/ and json body

`{
   "id":"131",
   "username":"Ala",
   "email":"ala@s.z",
   "phone":125432,
   "owner":true,
   "apartment":2
}`

5. Delete user: (DEL) http://localhost:8080/api/users/1user_id

### Meetings requests:
1. Create meeting: (POST) http://localhost:8080/api/houseMeetings/ and json body

`{
   "date":"1.1.2001",
   "name":"Third Meeting.",
   "topics":[
   "1. First topic. ",
   "2. Second topic. ",
   "3. Third topic. "
   ]
}`

2. Get all meetings: (GET) http://localhost:8080/api/houseMeetings/
   
3. Get meeting by id: (GET) http://localhost:8080/api/houseMeetings/meeting_id


## Structure:

Rest contain classes responsible for handling HTTP requests and responses.
Entity represent the data structure of application.
Dao classes responsible for interacting with the database.
Service interact with the DAO layer to retrieve or update data, and may perform other tasks such as validation or data transformation.

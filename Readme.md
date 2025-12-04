# QAP4 - Golf Club Tournament & Membership API Documentation
**Justin Greenslade**  
**Submission: December 3, 2025**
## (All screenshots for work are in screenshot folder)
## Search APIs 

### Member Searches – GET /api/members/search
- By name:              `?name=Ross`
- By phone:             `?phone=709` ( Supports partial search )
- By membership type:   `?membershipType=Gold`
- By tournament start date: `?tournamentStartDate=2025-07-10`

### Tournament Searches – GET /api/tournaments/search
- By start date:        `?startDate=2025-08-15`
- By location:          `?location=Tree` ( Supports partial search)


### Find all members in a tournament
- GET /api/tournaments/{id}/members
- All other CRUD endpoints are also fully functional (POST, GET by ID, etc.).

## Docker

For Docker firstly I created my Dockerfile and my Docker-compose.yml in the root of my project 
and added the appropriate information. Updating my Java version to match my pom file. 
Then to build the image and run my container I ran two commands:
- `docker build -t thelostmrj/golftournamentapp`
- `docker compose up`

## Connecting to AWS RDS

- Created an AWS RDS MySQL database and turned on public access.
- Used the RDS endpoint, username, and password to connect to it with MySQL Workbench.
- In MySQL Workbench, I created the database/schema manually just to test everything.
- Ran my Spring Boot app from IntelliJ so JPA would create all the tables.
- Updated application.properties with the RDS URL, username, and password.
- Also updated docker-compose.yml to point to the RDS database instead of the local one.
- Tested everything with Postman. Sent some requests and data was sent.
- Went back to MySQL Workbench and ran SELECT * FROM members. The data I added through the app was there.

## Feedback
- Docker took me a while to figure out at first. I kept making silly spelling mistakes with the commands 
but once I fixed those small things, everything worked perfectly. The GitHub Actions part was actually really cool,
seeing it build and push the image automatically. I ended up loving Docker once the typos stopped haunting me!
- AWS RDS was way easier and more fun than I expected. Setting it up was straightforward, and I loved that it offered
to create the security group for me. The best part was opening MySQL Workbench, connecting to my cloud database with the endpoint,
and actually seeing my tables and data there. Being able to run my app locally but have the data live in AWS was honestly a great experience.

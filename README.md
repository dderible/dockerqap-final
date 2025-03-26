Declan's Golf Club API QAP (read last section jamie please)
***************************
This project features endpoints that allow for the following:
- Add/Delete Members (ID, Name, Address, Email, Phone Number, Start Date, Membership Duration)
- Add/Delete Tournaments (ID, Start Date, End Date, Location, Entry Fee, Grand Prize)
- Add/Delete Members to Tournaments (stored as an array)
***************************
Installation Process:
1) Clone this repository
2) Run the following Docker commands in order:
   - First, create a Maven package of this project
   - Second, run this command: docker build -t golfclubqap .
   - Thirdly, run this command: docker compose up
   - Finally, run the project!
3) And you're live! Feel free to test this as you wish! All API Endpoints can be found in these files:
- MemberController.java
- TournamentController.java

This project also has Docker Support for cloning and testing!
***************************
Jamie's section

Okay so I've met with Jordan a few times and while the project works fine locally, when it runs solely from docker it bugs out.
Basically, all API endpoint tests come back empty. When switched back to local, it still remains empty. SQL Workbench still
picks up on all API endpoints however. Jordan and myself could not figure out a fix in time but the project works locally.

# laboramus-sales

This is the backend Engine for the sales reporting application.

Language: Java

Framework: Spring Boot

IDE Used: Intellij 

Database : PostgreSQL.

Details:
The application exposes REST APIs which include;

1. /api/sales/upload-csv-file
This is the endpoint which recieves a CSV file, processes it and saves the data into the database.

2. /api/sales/getRecords
 This returns a list of sales records querried over a specified period of time.
 
3. /api/sales/getAnalytics
Returns a summary of records (number of countries, number of regions, number of item types, total profits)  

4. /api/sales/getSales
Returns a summury of top 5 profitable item types.

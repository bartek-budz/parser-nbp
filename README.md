# Parser NBP

Solution for a coding exercise. Originally created in 2014, then updated in 2016.

The goal was to parse files with currency exchange rates from the website of National Bank of Poland; then based on the application parameters:
- currency code
- time period

the application should calculate and print out:
- average buy price
- sell price standard deviance 

The full exercise content (in Polish) is available at: http://www2.smart4aviation.aero/java_developer/task.php

Please note that since solution has been created, the NBP has exposed new XML/JSON api available at: http://api.nbp.pl
However in the beginning of 2019 the solution has been still working as designed, but only for the current year.

## 1. Prerequisites
- Java 8 installed
- Internet connection

## 2. Installation
Execute the following console command:
__gradlew installDist__
The application will be installed in the __build\install\ParserNBP__ folder

## 3. Usage
Execute one of the OS specific scripts to run the project as a JVM application.
By default, the scripts are generated in the __build\install\ParserNBP\bin__ directory

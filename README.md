# Employee Management

This project helps you to add employees and list them (sorted by employee name) using using angular(front side) and 
  java(spring booot - rest services).

There are two mdules under SocietyProject- 

  1. employee - This is spring boot project. [REST SERVICE for Employee Management UI] 
                
                a. Import it in eclipse and run SocietyProject/employee/src/main/com/society/employee/EmployeeApplication. 
                    Or even you can directly run the jar - target/employee-0.0.1-SNAPSHOT.jar
                b. The application will start on port 8447. You can even change the port in 
                    SocietyProject/employee/src/main/resources/application.properties 
                c. It is configured with http by default.
                d. REST SERVICE maintains a local cache to hold the employees.
                e. It has all "CRUD operations".

  2. employee-ui - This is a angular project. [UI for Employee Management]
  
                a. Import this project in visual studio code.
                b. Do "npm install" to generate node modules.
                c. In case you are not running REST SERVICE in same machine or port (8447) then please change the base URL in 
                    SocietyProject/employee-ui/src/app/employee.service.ts
                d. Run "ng s" in terminal. By default the port is 4200. You can change it by ng s --port <port>
                e. Open "http://<IP>:<PORT>/" in browser. (By default - http://localhost:4200)
                f. The list of employees will be displayed sorted by name. (By default it is empty)
                g. There is a button to add new employee.On clicking it, it will route you to a detail page where you can
                   can fill details of employee and click save to submit it to rest service.
                h. After clicking save you will be routed back to listing page.
                i. In listing page the new value will be added.


#Note : Rest Server has all crud operations but angular has only get and post operation (as per UI requirement).

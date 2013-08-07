samples
=======
1. Start JettyServer.java
2. curl -X POST -H "Content-Type:application/json" -H "Accept:application/xml" -d "{employee:{'name':'ManagerNotExist','managerId':'9999','departmentId':'abc'}}"  http://localhost:8080/employees/
3. curl -X GET -H "Accept:application/json" http://localhost:8080/employees/
4. curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d "{employee:{'name':'InvalidDepartment','managerId':1,'departmentId':999}}"  http://localhost:8080/employees/
5. curl -X POST -H "Content-Type:application/json" -H "Accept:application/json" -d "{employee:{'name':'Valid Employee','managerId':1,'departmentId':1}}"  http://localhost:8080/employees/
6. curl -X GET -H "Accept:application/json" http://localhost:8080/employees/1
7. curl -X GET -H "Accept:application/json" http://localhost:8080/employees/exception
8. curl -X GET -H "Accept:application/json" http://localhost:8080/employees/exception2
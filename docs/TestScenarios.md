# Test Scenarios – OrangeHRM Demo Application

## Authentication Module
1. Verify user can login with valid credentials
2. Verify login fails with invalid username
3. Verify login fails with invalid password
4. Verify login fails with empty username and password
5. Verify user can logout successfully
6. Verify session timeout after inactivity

---

## Employee Management Module
7. Verify admin can add a new employee with valid data
8. Verify mandatory fields validation while adding employee
9. Verify admin can search employee by name
10. Verify admin can edit employee details
11. Verify admin can't add employee with very long first name
12. Verify date is not saved when refreshing the page without saving
13. Verify admin can delete an employee
14. Verify system prevents duplicate employee records

---

## Leave Management Module
15. Verify admin can assign leave to an employee
16. Verify leave assignment with invalid date range
17. Verify employee leave balance is updated correctly  
18. Verify leave request appears in leave list
19. Verify leave status changes correctly (Pending / Approved / Rejected)

---

## Recruitment Module
20. Verify admin can add a new candidate
21. Verify mandatory fields validation while adding candidate
22. Verify admin can reject a candidate
23. Verify candidate status updates correctly

---

## UI and General Scenarios
24. Verify all required fields show validation messages
25. Verify error messages are user-friendly
26. Verify application behavior on browser refresh
27. Verify application behavior on browser backbutton after logging out
28. Verify unauthorized user cannot access restricted pages
29. Verify application displays proper success messages

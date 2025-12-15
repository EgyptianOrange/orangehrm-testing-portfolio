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
11. Verify admin can delete an employee
12. Verify system prevents duplicate employee records

---

## Leave Management Module
13. Verify admin can assign leave to an employee
14. Verify leave assignment with invalid date range
15. Verify employee leave balance is updated correctly
16. Verify leave request appears in leave list
17. Verify leave status changes correctly (Pending / Approved / Rejected)

---

## Recruitment Module
18. Verify admin can add a new candidate
19. Verify mandatory fields validation while adding candidate
20. Verify admin can schedule an interview
21. Verify candidate status updates correctly

---

## UI and General Scenarios
22. Verify all required fields show validation messages
23. Verify error messages are user-friendly
24. Verify application behavior on browser refresh
25. Verify application navigation menu works correctly
26. Verify unauthorized user cannot access restricted pages
27. Verify application handles special characters input
28. Verify application displays proper success messages

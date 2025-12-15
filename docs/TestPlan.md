# Test Plan – OrangeHRM Demo Application

## 1. Introduction
This test plan describes the testing approach, scope, resources, and schedule
for testing the OrangeHRM Demo web application.
The purpose is to ensure that the core HR functionalities work as expected
and meet the defined requirements.

---

## 2. Application Under Test (AUT)
- Application Name: OrangeHRM Demo
- Application Type: Web-based HR Management System
- Environment: Demo / Staging
- Browser: Google Chrome (latest)

---

## 3. Test Scope

### 3.1 In Scope
- Login and Logout functionality
- Employee Management (Add, Edit, Search Employee)
- Leave Management (Assign Leave, View Leave List)
- Basic Recruitment flows
- UI validation and form validations
- Smoke and Regression testing

### 3.2 Out of Scope
- Performance testing
- Security testing
- Payroll module
- Advanced reporting features

---

## 4. Test Approach
- Manual testing will be performed for all functional flows.
- Test cases will be designed based on functional requirements.
- Smoke testing will be executed on every new build.
- Regression testing will be performed after major changes.
- Automation testing (Selenium) will be implemented for critical smoke flows.

---

## 5. Test Types
- Smoke Testing
- Functional Testing
- Regression Testing
- UI Testing

---

## 6. Test Environment
- Operating System: Windows 10
- Browser: Google Chrome
- Tools:
  - VS Code
  - GitHub
  - Selenium WebDriver (for automation)
  - Excel / Markdown for documentation

---

## 7. Entry and Exit Criteria

### 7.1 Entry Criteria
- Application is accessible
- Test environment is stable
- Test data is available

### 7.2 Exit Criteria
- All critical test cases are executed
- Critical and high severity defects are fixed or accepted
- Smoke tests pass successfully

---

## 8. Roles and Responsibilities
- Test Planning: Software Tester
- Test Case Design: Software Tester
- Test Execution: Software Tester
- Defect Reporting: Software Tester

---

## 9. Risks and Mitigation
| Risk | Impact | Mitigation |
|------|--------|------------|
| Demo site downtime | High | Pause testing and resume when available |
| Limited test data | Medium | Create dummy data for testing |

---

## 10. Deliverables
- Test Plan document
- Test Scenarios
- Test Cases
- Bug Reports
- Traceability Matrix
- Automation Scripts

---

## 11. Schedule
| Activity | Duration |
|--------|----------|
| Test Planning | 1 Day |
| Test Scenario Design | 2 Days |
| Test Case Writing | 3 Days |
| Test Execution | 2 Days |
| Bug Reporting | 2 Days |
| Automation (Basic) | 2 Days |

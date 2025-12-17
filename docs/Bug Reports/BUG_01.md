# Bug Report

## Bug ID
BUG_01

## Title
System allows applying leave with a past date

## Module
Leave Management

## Environment
- Application: OrangeHRM
- Browser: Chrome
- OS: Windows 11

## Severity
Major

## Priority
High

## Precondition
- Admin is logged in

## Steps to Reproduce
1. Login to the system
2. Navigate to Leave → Apply
3. Select a date in the past
4. Click on Submit

## Expected Result
System should not allow applying leave for past dates and should display a validation message.

## Actual Result
System allows submitting leave request with a past date successfully.
This behavior may affect leave balance calculation and payroll accuracy.

## Status
Open



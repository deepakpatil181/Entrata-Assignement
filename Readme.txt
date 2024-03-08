Steps To Run The Test Cases:
Clone the Project Folder In Eclipse.
Go to src/test/java.
Right click on EtrataAssignment.EtrataAssignment Package.
Click on RunAs.
Click on TestNg Test.

Test Cases for Entrata Website Testing
Test Case 01: Verify Footer Copyright Information
Goal: Verify that the copyright information in the website footer contains the current year.

Steps:

Open the Entrata website using the chosen WebDriver.
Find the element containing the copyright information in the footer. You can use XPath or CSS selectors to target the specific element based on its attributes or location on the page.
Extract the text content from the copyright element.
Assert that the extracted text contains the expected string "Copyright © Entrata [Current Year]". You can use regular expressions or string manipulation techniques to verify that the current year is present within the copyright text.
Test Case 02: Validate Property Manager Login Page Elements with Explicit Wait
Goal: Verify that the username and password fields are present on the Login page after waiting for them to load.

Steps:

Open the Entrata Login page using the chosen WebDriver.
Use an explicit wait (e.g., WebDriverWait with ExpectedConditions.presenceOfElementLocated) to wait for the username field to be present on the page.
Find the element for the username field.
Assert that the username field is found and displayed.
Test Case 03: Verify Sign In Page Title
Goal: Verify that the title of the Entrata homepage is "Entrata Sign In".

Steps:

Open the Entrata sign website using the chosen WebDriver.
Get the actual title of the page.
Assert that the actual title is equal to the expected title ("Entrata Sign In").
Test Case 04: Entrata Summit Registration Page Element Verification
Goal: To verify the presence and visibility of required elements on the Entrata Summit registration page.

Steps:

Open the Entrata website using the chosen WebDriver.
Navigate to "https://www.entrata.com".
Scroll down to locate the Summit section.
Ensure the Summit section is visible on the webpage.
Click on the "Summit" link.
Confirm that the Summit page is loaded successfully.
Click on the "Register Now" button.
Ensure the registration page opens.
Switch to the new window opened for registration.
Confirm the focus is on the registration page.
Assert all the elements using explicit waits to ensure they are displayed:
Verify the visibility of the "First Name" field.
Verify the visibility of the "Last Name" field.
Verify the visibility of the "Preferred Name" field.
Verify the visibility of the "Company" field.
Verify the visibility of the "Title" field.
Verify the visibility of the "Email Address" field.
Verify the visibility of the "Mobile" field.
Verify the visibility of the "I'm registering on behalf of this person" checkbox.
Verify the visibility of the "Next" button.
Test Case 05: Validate Presence of Watch Demo Form
Goal: To verify that the Watch Demo form is present on the Entrata Watch Demo page.

Steps:

Open Entrata Watch Demo Page:
Open a web browser (Chrome).
Enter the URL for the Entrata Watch Demo page: https://go.entrata.com/watch-demo.html
Press Enter or click 'Go'.
Wait for Page Load:
Wait for the page to load completely.
Verify Presence of Watch Demo Form:
Look for the Watch Demo form displayed on the page.
Ensure that the form is visible and rendered properly.
Confirmation:
Confirm that the Watch Demo form is present on the page.

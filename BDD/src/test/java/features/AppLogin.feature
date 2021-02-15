Feature: Login QAClickAcademy

Scenario Outline: Integrating Login QA to BDD framework
Given Initialize driver
And Navigate to "http://www.qaclickacademy.com/"  site
And Click on SignIn CTA and Land on Sign In page
When Enter Credentials <Username> and <Password>
Then Verify text present
And close the browser

Examples:
|Username           |   Password|
|uyeiu@gmail.com    |123456     |
|test99@gmail.com   |98usui     |
|iuwiuw@gmail.com   |khsui8     |
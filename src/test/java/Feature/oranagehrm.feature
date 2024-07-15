Feature: Orange HRM Application

  Scenario: validate login functionality
    Given user is on login page
    When And user enter password as "Admin" and username as "admin123"
    Then user click on login button

  Scenario: validate HomePage functionality
    Given user is on home page
    Then user validate homepageURL
    And user validate HomepageTitle
    And user validate logo

  Scenario Outline: validate PIM functionality
    Given user is on pim page when click on PIM link
    Then user click on add employee
    And Enter "<firstname>","<middlename>","<lastname>" and capture the employee id
    And click on save button
    Then enter "<Country>" and select "<gender>"
    And click on the save button
    Then click on employee list button
    And enter the employee id
    And click on search button
    Then delete employee and confirm delete

    Examples: 
      | firstname | middlename | lastname | Country  | gender |
      | Alfiya    | Iliyas     | Sanadi   | Indian   | Female |
      | Nida      | Faisu      | Khan     | American | Female |
      | Imran     | Adil       | Shaikh   | Indian   | Male   |

  Scenario: validate logout functionality
    When user click on profile icon
    And click on logout
    Then user is on loginPage again

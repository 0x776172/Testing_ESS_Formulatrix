Feature: Testing login page

Scenario: Positive case login page
  When enter "admin" and "123456"
  And click login button
  When check valid
  Then click burger icon
  #   And click menu 1
  #   And click menu 2
  #   And click menu 3
  #   And click menu 4
  #   And click menu 5
  #   And click menu 6
  # Then click logout

Scenario: Negative case login page
  When enter "username" and "password"
  And click login button
  Then check valid
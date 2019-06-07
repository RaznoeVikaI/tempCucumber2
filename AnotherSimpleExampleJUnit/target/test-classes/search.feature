Feature: Search
  Scenario:: Find mobile
    Given I browse to yandex.ru for mobile
    When I click "Market for Mobile" link
    When I click "Elektronika for Mobile" link
    When I click "Mobile" link
    Then I see "48 mobile" item
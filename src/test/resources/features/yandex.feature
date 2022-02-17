Feature: Yandex inbox
  @yandexInbox
  Scenario: Enter the mailbox on www.yandex.ru
    Given user navigates to www.yandex.ru
    And user clicks the inbox
    Then user should see the login page

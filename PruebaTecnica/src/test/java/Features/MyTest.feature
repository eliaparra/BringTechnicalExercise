Feature: Reset functionality on login page of Application

  Background: Open the Firefox and launch the application
    Given Open the Firefox and launch the application

  Scenario: Book a fligth

    When Enter "Portugal" "Lisbon"  and "France" "Paris Beauvais"
    And Enter departureDate
    And Enter comeBackDate
    And Add 2 adults and 1 child
    And Open departureDate
    And Select month "Dec"
    And Select new departure date "2023-12-06"
    And Select new comeback date "2023-12-12"
    And Click on Search button
    And Select FirstFlight
    And Select SecondFlight
    And Select "regular" fare
    And Click on Log in later
    And Fill "Mrs" "Sónia" "Pereira"
    And Fill "Mr" "Diogo" "Bettencourt"
    And Fill child "Inês" "Marçal"
    And Click on Continue button
    And Click OKay modal
    And Select 3 seats
    And Click on Next Flight
    And Select 3 seats
    And Click on Continue button Seats Page
    And Do not Add Fast Track
    And Select small bag
    And Click on Continue button Bags Page
    And Click on Continue button Extras Page
    And Click on Continue button Extras TransportPage
    Then Payment page is reached


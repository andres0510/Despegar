Feature: Flight reservation for Despegar web app

  @FlightReservation
  Scenario Outline: Reservation for flight between cities
    Given two cities <origin> and <destination>
    When a flight reservation is made
    Then the application shows correct info for reservation
      Examples:
      | origin   | destination |
      | Medellín | Bogotá      |

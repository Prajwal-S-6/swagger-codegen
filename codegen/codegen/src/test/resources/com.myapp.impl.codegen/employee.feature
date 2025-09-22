Feature: Employee REST using openapi codegen

  Scenario: Get Employees
    Given The system has employees
    When Requested for GET "/employees"
    Then Should respond with status 200
    And Should return 1 employee
    And Should return employee with firstName as "praj"
    And Should return employee with lastName as "s"

  Scenario: Post Employees
    Given The employee payload
    """
      {
        "id": 2,
        "firstName": "john",
        "lastName": "doe"
      }
     """
    When POST request is sent for "/employees"
    Then Should respond with status 201
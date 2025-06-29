DECLARE
  -- Variables to simulate mocking
  mock_called BOOLEAN := FALSE;
  mock_result VARCHAR2(50);

  -- ====== STUBBED PROCEDURE ======
  -- Simulates a database call or external logic
  PROCEDURE get_customer_name_stub(customer_id IN NUMBER, name OUT VARCHAR2) IS
  BEGIN
    mock_called := TRUE; -- mock tracking
    name := 'Test User'; -- stubbed fixed return value
  END;

  -- ====== PROCEDURE UNDER TEST ======
  -- Depends on get_customer_name (stubbed here)
  PROCEDURE greet_customer(customer_id IN NUMBER, greeting OUT VARCHAR2) IS
    customer_name VARCHAR2(50);
  BEGIN
    get_customer_name_stub(customer_id, customer_name); -- stub call
    greeting := 'Hello, ' || customer_name || '!';
  END;

  -- ====== TEST CASE ======
  PROCEDURE test_greet_customer IS
    expected_greeting VARCHAR2(100) := 'Hello, Test User!';
    actual_greeting   VARCHAR2(100);
  BEGIN
    greet_customer(101, actual_greeting);

    -- Assert (check result)
    IF actual_greeting = expected_greeting THEN
      DBMS_OUTPUT.PUT_LINE('✅ Test Passed: Greeting = ' || actual_greeting);
    ELSE
      DBMS_OUTPUT.PUT_LINE('❌ Test Failed: Expected ' || expected_greeting || ' but got ' || actual_greeting);
    END IF;

    -- Mock Verification
    IF mock_called THEN
      DBMS_OUTPUT.PUT_LINE('✅ Mock Verified: Stub was called.');
    ELSE
      DBMS_OUTPUT.PUT_LINE('❌ Mock Not Called!');
    END IF;
  END;

BEGIN
  test_greet_customer;
END;
/

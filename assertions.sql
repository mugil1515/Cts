DECLARE
  -- Variables for testing
  expected_result NUMBER := 25;
  actual_result   NUMBER;
  
  -- Procedure to be tested
  PROCEDURE square_number(num IN NUMBER, squared OUT NUMBER) IS
  BEGIN
    squared := num * num;
  END;

BEGIN
  -- Step 1: Call the procedure with input 5
  square_number(5, actual_result);

  -- Step 2: Simulate JUnit's assertEquals
  IF actual_result = expected_result THEN
    DBMS_OUTPUT.PUT_LINE('✅ Test Passed: 5 * 5 = ' || actual_result);
  ELSE
    DBMS_OUTPUT.PUT_LINE('❌ Test Failed: Expected ' || expected_result || ' but got ' || actual_result);
  END IF;

END;
/

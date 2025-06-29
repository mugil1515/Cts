DECLARE
  input_val NUMBER := 5;
  expected_result NUMBER := 25;
  actual_result NUMBER;
BEGIN
  -- Call the procedure
  square_number(input_val, actual_result);

  -- Manual assertion
  IF actual_result = expected_result THEN
    DBMS_OUTPUT.PUT_LINE('✅ Test Passed: Result is ' || actual_result);
  ELSE
    DBMS_OUTPUT.PUT_LINE('❌ Test Failed: Expected ' || expected_result || ' but got ' || actual_result);
  END IF;
END;
/

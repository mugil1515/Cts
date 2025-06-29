DECLARE
  -- Logging procedure
  PROCEDURE log_message(
    p_message IN VARCHAR2,
    p_level   IN VARCHAR2 DEFAULT 'INFO' -- INFO, WARN, ERROR
  ) IS
  BEGIN
    DBMS_OUTPUT.PUT_LINE('[' || UPPER(p_level) || '] ' || p_message);
  END;

  -- Procedure that might throw an error
  PROCEDURE divide_numbers(a IN NUMBER, b IN NUMBER, result OUT NUMBER) IS
  BEGIN
    IF b = 0 THEN
      log_message('Attempt to divide by zero', 'ERROR');
      RAISE_APPLICATION_ERROR(-20001, 'Division by zero is not allowed');
    ELSIF b < 0 THEN
      log_message('Dividing by a negative number', 'WARN');
    ELSE
      log_message('Performing safe division', 'INFO');
    END IF;

    result := a / b;
  EXCEPTION
    WHEN OTHERS THEN
      log_message('Exception occurred: ' || SQLERRM, 'ERROR');
      RAISE;
  END;

  -- Test the logger
  result_value NUMBER;
BEGIN
  log_message('Starting division operation', 'INFO');

  -- Example 1: valid input
  divide_numbers(10, 2, result_value);
  log_message('Result: ' || result_value, 'INFO');

  -- Example 2: warning (negative number)
  divide_numbers(10, -2, result_value);
  log_message('Result: ' || result_value, 'INFO');

  -- Example 3: error (divide by zero)
  divide_numbers(10, 0, result_value);

EXCEPTION
  WHEN OTHERS THEN
    log_message('Unhandled exception in main block: ' || SQLERRM, 'ERROR');
END;
/

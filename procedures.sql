-- Step 1: Create the stored procedure
CREATE OR REPLACE PROCEDURE add_numbers (
    a IN NUMBER,
    b IN NUMBER,
    result OUT NUMBER
)
IS
BEGIN
    result := a + b;
END;
/

-- Step 2: Call the stored procedure in an anonymous block
DECLARE
  num1 NUMBER := 15;
  num2 NUMBER := 25;
  sum_result NUMBER;
BEGIN
  -- Call the procedure
  add_numbers(num1, num2, sum_result);

  -- Display the result
  DBMS_OUTPUT.PUT_LINE('Sum of ' || num1 || ' and ' || num2 || ' is: ' || sum_result);
END;
/

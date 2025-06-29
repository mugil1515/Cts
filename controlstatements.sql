DECLARE
  i NUMBER := 1;
  salary NUMBER := 3000;
BEGIN
  -- IF-ELSIF-ELSE
  IF salary > 5000 THEN
    DBMS_OUTPUT.PUT_LINE('High Salary');
  ELSIF salary > 2000 THEN
    DBMS_OUTPUT.PUT_LINE('Medium Salary');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Low Salary');
  END IF;

  -- LOOP with EXIT
  LOOP
    DBMS_OUTPUT.PUT_LINE('LOOP i = ' || i);
    i := i + 1;
    EXIT WHEN i > 3;
  END LOOP;

  -- WHILE LOOP
  WHILE i <= 5 LOOP
    DBMS_OUTPUT.PUT_LINE('WHILE i = ' || i);
    i := i + 1;
  END LOOP;

  -- FOR LOOP
  FOR j IN 1..3 LOOP
    DBMS_OUTPUT.PUT_LINE('FOR j = ' || j);
  END LOOP;

  -- GOTO Statement
  GOTO end_block;

  DBMS_OUTPUT.PUT_LINE('This will be skipped');

  <<end_block>>
  DBMS_OUTPUT.PUT_LINE('Reached the end of the program');

END;

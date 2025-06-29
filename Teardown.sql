DECLARE
  -- ====== SETUP (Test Fixture) ======
  PROCEDURE setup_test IS
  BEGIN
    DBMS_OUTPUT.PUT_LINE('--- [Setup] Initializing test data ---');
  END;

  -- ====== TEARDOWN (Cleanup) ======
  PROCEDURE teardown_test IS
  BEGIN
    DBMS_OUTPUT.PUT_LINE('--- [Teardown] Cleaning up test data ---');
  END;

  -- ====== PROCEDURE TO TEST ======
  PROCEDURE square_number(n IN NUMBER, result OUT NUMBER) IS
  BEGIN
    result := n * n;
  END;

  -- ====== TEST CASE USING AAA PATTERN ======
  PROCEDURE test_square_number IS
    -- Arrange
    input NUMBER := 4;
    expected NUMBER := 16;
    actual NUMBER;
  BEGIN
    DBMS_OUTPUT.PUT_LINE('--- [Test] Square Number ---');

    -- Act
    square_number(input, actual);

    -- Assert
    IF actual = expected THEN
      DBMS_OUTPUT.PUT_LINE('✅ Test Passed: ' || input || '^2 = ' || actual);
    ELSE
      DBMS_OUTPUT.PUT_LINE('❌ Test Failed: Expected ' || expected || ', but got ' || actual);
    END IF;
  END;

BEGIN
  -- Simulate JUnit lifecycle
  setup_test;
  test_square_number;
  teardown_test;
END;
/

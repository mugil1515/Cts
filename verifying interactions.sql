DECLARE
  -- ======= MOCKING STATE =======
  mock_called BOOLEAN := FALSE;
  mock_call_count NUMBER := 0;
  last_order_id NUMBER;

  -- ======= STUBBED DEPENDENCY (mocked) =======
  PROCEDURE process_order(order_id IN NUMBER) IS
  BEGIN
    mock_called := TRUE;         -- Simulate "interaction"
    mock_call_count := mock_call_count + 1;
    last_order_id := order_id;   -- Capture input for verification
    DBMS_OUTPUT.PUT_LINE('Mock: process_order called with order_id = ' || order_id);
  END;

  -- ======= PROCEDURE UNDER TEST =======
  PROCEDURE checkout(customer_id IN NUMBER) IS
    dummy_order_id NUMBER := 1001; -- Simulated order ID
  BEGIN
    -- In real logic, this would call real process_order
    process_order(dummy_order_id);
  END;

  -- ======= TEST CASE =======
  PROCEDURE test_checkout_interaction IS
  BEGIN
    checkout(10); -- Call method under test

    -- ======== VERIFY INTERACTION ========
    IF mock_called THEN
      DBMS_OUTPUT.PUT_LINE('✅ Verified: process_order was called.');
    ELSE
      DBMS_OUTPUT.PUT_LINE('❌ Not called: process_order was NOT invoked.');
    END IF;

    IF mock_call_count = 1 THEN
      DBMS_OUTPUT.PUT_LINE('✅ Verified: process_order called exactly once.');
    ELSE
      DBMS_OUTPUT.PUT_LINE('❌ process_order called ' || mock_call_count || ' times.');
    END IF;

    IF last_order_id = 1001 THEN
      DBMS_OUTPUT.PUT_LINE('✅ Verified: process_order called with correct order_id.');
    ELSE
      DBMS_OUTPUT.PUT_LINE('❌ Incorrect order_id: got ' || last_order_id);
    END IF;
  END;

BEGIN
  test_checkout_interaction;
END;
/

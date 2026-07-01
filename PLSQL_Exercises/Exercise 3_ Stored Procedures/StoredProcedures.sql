-- Scenario 1: Process monthly interest for all savings accounts
-- Question: Calculate and update the balance of all savings accounts by applying a 1% interest rate[cite: 292, 293].
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01,
        LastModified = SYSDATE
    WHERE AccountType = 'Savings';
    
    DBMS_OUTPUT.PUT_LINE('Monthly interest of 1% applied to all Savings accounts.');
    COMMIT;
END;
/

-- Scenario 2: Implement a bonus scheme for employees based on performance
-- Question: Update the salary of employees in a given department by adding a bonus percentage[cite: 294, 295].
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department IN VARCHAR2,
    p_bonus_percentage IN NUMBER
) IS
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + (p_bonus_percentage / 100))
    WHERE Department = p_department;
    
    DBMS_OUTPUT.PUT_LINE('Applied a ' || p_bonus_percentage || '% bonus to all employees in the ' || p_department || ' department.');
    COMMIT;
END;
/

-- Scenario 3: Transfer funds between accounts with balance checks
-- Question: Transfer specified amount from one account to another after verifying sufficient balance[cite: 296, 297].
CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account IN NUMBER,
    p_dest_account IN NUMBER,
    p_amount IN NUMBER
) IS
    v_current_balance NUMBER;
BEGIN
    -- Check current balance of the source account
    SELECT Balance INTO v_current_balance 
    FROM Accounts 
    WHERE AccountID = p_source_account;
    
    IF v_current_balance >= p_amount THEN
        -- Deduct from source
        UPDATE Accounts 
        SET Balance = Balance - p_amount, LastModified = SYSDATE 
        WHERE AccountID = p_source_account;
        
        -- Add to destination
        UPDATE Accounts 
        SET Balance = Balance + p_amount, LastModified = SYSDATE 
        WHERE AccountID = p_dest_account;
        
        DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || ' from Account ' || p_source_account || ' to Account ' || p_dest_account);
        COMMIT;
    ELSE
        DBMS_OUTPUT.PUT_LINE('Transaction Failed: Insufficient funds in Account ' || p_source_account);
    END IF;
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Transaction Failed: One or both Account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transaction Failed: An unexpected error occurred.');
END;
/
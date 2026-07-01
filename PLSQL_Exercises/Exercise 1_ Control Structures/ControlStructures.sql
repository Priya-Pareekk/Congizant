-- Scenario 1 Block
DECLARE
    -- Cursor to find customers older than 60 with active loans
    CURSOR c_senior_loans IS
        SELECT l.LoanID, l.InterestRate, c.Name, 
               FLOOR(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) AS Age
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID;
BEGIN
    FOR r_loan IN c_senior_loans LOOP
        -- Check if the customer's age is strictly above 60
        IF r_loan.Age > 60 THEN
            -- Apply a 1% discount to their interest rate (e.g., 5% becomes 4%)
            UPDATE Loans
            SET InterestRate = InterestRate - 1
            WHERE LoanID = r_loan.LoanID;
            
            DBMS_OUTPUT.PUT_LINE('Applied 1% discount to Loan ID: ' || r_loan.LoanID || ' for Customer: ' || r_loan.Name);
        END IF;
    END LOOP;
    COMMIT;
END;
/
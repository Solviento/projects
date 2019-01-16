IMPORTANT!!

Check Table properties AND Stored Procedures match according to DATATYPE AND MEMORY ALLOCATION
- Otherwise, python+stored procedure will not call and execute correctly
- Example:
  - Stored procedure: p_password VARCHAR(300)
  - Table properties: user_password VARCHAR(300)
  - Will work!
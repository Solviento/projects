IMPORTANT!!

Pip
- pip install flaskext-mysql

Check Table properties AND Stored Procedures match according to DATATYPE AND MEMORY ALLOCATION
- Otherwise, python+stored procedure will not call and execute correctly
- Example:
  - Stored procedure: p_password VARCHAR(300)
  - Table properties: user_password VARCHAR(300)
  - Will work!
  
Functions
- In mysql console:
``` SQL
SET GLOBAL log_bin_trust_function_creators = 1;
```
- This will allow non deterministic functions, these functions modify data (insert, delete)
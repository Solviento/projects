
- This input button with id "fileUpload" should handle how below img src is made in jquery call
``` HTML
<span class="btn btn-primary btn-file">
  Browse&hellip;
  <input type="file" id="fileupload" name="file" multiple>
</span>
```
- Once image has been uploaded, src of below should be changed, this then gets pulled by app.py (at least for now)
- img tag is used to create a mini preview while input is used to allow flask mysql to pull data back into db
``` HTML
<img id="imgUpload" style="width: 140px; height: 140px;" class="img-thumbnail">
<input type="hidden" name="newfilePath"id="newfilePath"></input>
```

Process of pulling different data from SQL
- First create or modify a stored procedure
- Once changes are made, test and call the SP to ensure it gives correct output
- Change SP call within controller and proceed normally

SQL Functions inside Stored Procedures
- The function 'getUsername()' can be used as shown below
``` SQL
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GetAllPublicPosts`(
	p_user_id int
)
BEGIN
	select post_id, post_title, post_description, post_file_path, post_date, getUsername(p_user_id)
    from tbl_posts where post_private = 0;
END
```
``` SQL
CREATE DEFINER=`root`@`localhost` FUNCTION `getUsername`(
    p_user_id int
) RETURNS varchar(45) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
    select user_username into @sm from tbl_users where user_id = p_user_id;
RETURN @sm;
END
```
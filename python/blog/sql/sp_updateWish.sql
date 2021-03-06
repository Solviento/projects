CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_updateWish`(
IN p_title varchar(45),
IN p_description varchar(1000),
IN p_wish_id bigint,
In p_user_id bigint,
IN p_file_path varchar(200),
IN p_is_private int,
IN p_is_done int
)
BEGIN
update tbl_wish set
    wish_title = p_title,
    wish_description = p_description,
    wish_file_path = p_file_path,
    wish_private = p_is_private,
    wish_accomplished = p_is_done
    where wish_id = p_wish_id and wish_user_id = p_user_id;
END
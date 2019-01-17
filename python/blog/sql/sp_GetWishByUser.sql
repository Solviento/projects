CREATE DEFINER=`solviento`@`%` PROCEDURE `sp_GetWishByUser`(
IN p_user_id int
)
BEGIN
    select * from tbl_wish where wish_user_id = p_user_id;
END
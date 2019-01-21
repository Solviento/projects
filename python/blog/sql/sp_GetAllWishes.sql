CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_GetAllWishes`(
	p_user int
)
BEGIN
	select wish_id,wish_title,wish_description,wish_file_path,getSum(wish_id),hasLiked(wish_id,p_user)
    from tbl_wish where wish_private = 0;
END
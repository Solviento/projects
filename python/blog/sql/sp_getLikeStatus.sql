CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_getLikeStatus`(
    IN p_wish_id int,
    IN p_user_id int
)
BEGIN
    select getSum(p_wish_id),hasLiked(p_wish_id,p_user_id);
END
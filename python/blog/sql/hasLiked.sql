CREATE DEFINER=`root`@`localhost` FUNCTION `hasLiked`(
    p_wish int,
    p_user int
) RETURNS int(11)
    DETERMINISTIC
BEGIN
     
    select wish_like into @myval from tbl_likes where wish_id =  p_wish and user_id = p_user;
RETURN @myval;
END
CREATE DEFINER=`root`@`localhost` FUNCTION `getSum`(
    p_wish_id int
) RETURNS int(11)
    DETERMINISTIC
BEGIN
    select sum(wish_like) into @sm from tbl_likes where wish_id = p_wish_id;
RETURN @sm;
END
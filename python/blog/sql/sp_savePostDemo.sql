CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_savePostDemo`(
    IN p_title VARCHAR(90),
    IN p_text TEXT(1000)
)
BEGIN
	insert into post_demo(
					post_title,
					post_text
				)
				values
				(
					p_title,
					p_text
				);
END
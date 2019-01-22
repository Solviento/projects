CREATE TABLE `tbl_likes` (
  `like_id` int(11) NOT NULL AUTO_INCREMENT,
  `wish_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `wish_like` int(11) DEFAULT '0',
  PRIMARY KEY (`like_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(45) DEFAULT NULL,
  `user_username` varchar(45) DEFAULT NULL,
  `user_password` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `tbl_wish` (
  `wish_id` int(11) NOT NULL AUTO_INCREMENT,
  `wish_title` varchar(45) DEFAULT NULL,
  `wish_description` varchar(5000) DEFAULT NULL,
  `wish_user_id` int(11) DEFAULT NULL,
  `wish_date` datetime DEFAULT NULL,
  `wish_file_path` varchar(200) DEFAULT NULL,
  `wish_accomplished` int(11) DEFAULT '0',
  `wish_private` int(11) DEFAULT '0',
  PRIMARY KEY (`wish_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

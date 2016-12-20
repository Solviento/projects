Quick Notes:

Sockets API Summary

  CLIENT				SERVER			int socket(domain, type, protocol)
  									
  socket				socket			bind(server_sock, &server_addr, server_sock)
	|					  |	
	|					 bind			listen(server_sock, backlog)
    |					  |
  	|					listen			accept(server_sock, &client_addr, &client_len)
	|					  |
 connect--------------->accept<--.		connect(client_sock, &server_addr, server_len)
   	|					  | 	 |
.>send------------------>recv<.	 |:
|	|					  |	  |	 |
'-recv<------------------send-'	 |
	|					  |		 |
  close----EOF---------=>read	 |
						  |		 |
						 close---'


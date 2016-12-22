Quick Notes:

Sockets API Summary

  CLIENT				SERVER			int socket(domain, type, protocol)
  									
  socket				socket			bind(server_sock, &server_addr, server_len)
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

socket(domain, type, protocol)
- Called by both client and server
- The server uses socket() to create a listening socket.
  This listening socket it later used to create a connected socket
  using accept().

bind(server_sock, &server_addr, server_len)
- Called by server only
- Binds a listening socket to a specific port number that the client
  uses to connect.

listen(server_sock, backlog)
- Called by server only
- Sets up with listening socket to accept connections

accept(server_sock, &client_addr, &client_len)
- Called by server only
- Creates and returns a brand new connected socket for each successive client

connect(client_sock, &server_addr, server_len)
- Called by client only
- Creates a connection between client and server, data may be sent back and forth

send() recv()
- Called by client and server
- Reads and writes to the other side
- Message boundaries may not always be preserved



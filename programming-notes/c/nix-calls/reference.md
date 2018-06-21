cat -

- Adding the parameter '-' will cause the machine to wait for
  user input (which is considered stdin 'standard input')

- This will literally echo (or reflect) your input back into
  the standard output (your computer screen) 

- According to the man page, '-' will set cat to patiently 
  wait for stdin and then echo that input data back as stdout data

- Jae had this interesting problem (really crazy)
	cat - | nc -l 10200 | cat -
	
	- In this pipeline, the client machine (i.e. the one that called nc -l)
	calls 'cat -' first, opens a tcp connection, then calls 'cat -' again
	
	- Breakdown:
	The first cat call (wow, just noticed that..) will tell the machine to
	essentially turn keyboard input into screen output
	The netcat call will then set up a connection to some client that calls:
	
	nc clac 10200 (connected! can now send messages to nc server)
	I am a message
	
	The second cat call will BE SENT to the client machine to also turn any stdin
	data into stdout data. So in full effect, any message typed into the server
	will be sent as stdout -> then into the tcp connection -> and finally as
	incoming stdin to client machines -> which is inserted into stdout and displayed
	as regular text on your screen.
	
	Server machine (after sending 'I am a message' on client):
	
	I am a message
	
	Messages can be echoed back and forth as so (from client-server and server-client)

	This is literally doing the same as a normal nc connection but Jae makes it
	more confusing.

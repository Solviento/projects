System Calls
	
	The system calls in this guide will allow you to access the network
	functionality of a Unix box, or any box that supports the sockets API.
	By using these functions, the kernel takes over and does all the work.

getaddrinfo()

	getaddrinfo() does DNS and service name lookups like so:

	#include <sys/types.h>
	#include <sys/socket.h>
	#include <netdb.h>

	int getaddrinfo(const char *node,     // e.g. "www.example.com" or IP
			const char *service,  // e.g. "http" or port number
			const struct addrinfo *hints,
        		struct addrinfo **res); // Should be returning this?
			
	Once given the parameters it returns a pointer to a linked list of
	'res' results.

	*node parameter - host name to connect to (usually IP address)
	*service parameter - typically a port number or name of service ("http")
	*hints parameter - already filled out with relevant information

	* Structures *

	For server who wants to listen on host's IP address with port 3490 (set up only)

	int status;
	
	struct addrinfo hints;
	struct addrinfo *servinfo;  // will point to the results

	memset(&hints, 0, sizeof hints); // make sure the struct is empty
	
	hints.ai_family   = AF_UNSPEC;      // don't care IPv4 or IPv6
	hints.ai_socktype = SOCK_STREAM;    // TCP stream sockets
	hints.ai_flags    = AI_PASSIVE;     // fill in my IP for me

	if ((status = getaddrinfo(NULL, "3490", &hints, &servinfo)) != 0) {
		fprintf(stderr, "getaddrinfo error: %s\n", gai_strerror(status));
		exit(1);
	}

	// servinfo now points to a linked list of 1 or more struct addrinfos

	// ... do everything until you don't need servinfo anymore ....

	freeaddrinfo(servinfo); // free the linked-list

	Should note that *servinfo will point to a linked list of struct addrinfos
	each of which contain a struct sockaddr that can be used later.

	For client who wants to connect to www.example.net with port 3490 (set up)

	int status;
	
	struct addrinfo hints;
	struct addrinfo *servinfo;  // will point to the results

	memset(&hints, 0, sizeof hints); // make sure the struct is empty
	
	hints.ai_family   = AF_UNSPEC;     // don't care IPv4 or IPv6
	hints.ai_socktype = SOCK_STREAM; // TCP stream sockets

	// get ready to connect
	status = getaddrinfo("www.example.net", "3490", &hints, &servinfo);

	// servinfo now points to a linked list of 1 or more struct addrinfos

	

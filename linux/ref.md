Personal Reference Sheet on Linux Commands

	Setting up PATH variables

	The PATH is essentially the list of directories in which the shell
	will look through when executing commands like

	echo, find, man, etc

	These commands are all found in the bin folder. You may also view
	them on Linux machine by entering

	echo $PATH

	In order to permanently change (or append) to a PATH, you may do the 
	following:

	PATH=${PATH}:/home/someDirectory/..


	If, Else 

	Example of a script using if/else statements

	#!/bin/bash

	if [[ $# -wq ]]; then

		echo 'meh'
	fi

	case "$1" in

		"exclaim") echo "I am $1, yay." ;;
		"complain") echo "I'm $1." ;;
	esac

	Breakdown

	All If, Elif and Else statements MUST end with fi.

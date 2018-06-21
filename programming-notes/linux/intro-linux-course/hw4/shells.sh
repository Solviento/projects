#!/bin/bash

#Must return number of users, shell-name, Rpm package that installs shell

retshells (){
#Will return all unique sells in use on the system, one per line	
	
	#Pipes! Where the output of one command is fed into the input of another comman
	cat /etc/passwd | cut -d ":" -f 7- $1 | sort $1 | uniq $1

}

findpkg(){
#Given a shell, will return the rpm that installs this shell
	rpm -qf $1

}

countshells(){
#This function will return a count of te users that have this as their default shell in /etc/passwd
	grep -o $1 /etc/passwd | wc -l

}

for i in $(retshells);
do 
	echo $(countshells ${i}), ${i}, $(findpkg ${i})
done
#retshells
#countshells
#findpkg

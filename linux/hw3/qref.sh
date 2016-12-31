#!/bin/bash

if [[ $# -eq 0 ]] ;
then
 	if [[ $PAGER ]] ;
	then
		source $PAGER ~/.quick.ref
	else
		source /bin/cat ~/.quick.ref
	fi

elif [[ $# -eq 1 ]] ;
then
        if [[ -f ~/."$1".quick.ref ]] ; 
	then
		ln -s ~/."$1".quick.ref ~/.quick.ref
		echo "S-link made"
	else
		echo "."$1".quick.ref not found, no s-link made"
	fi
fi

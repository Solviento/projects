#!/bin/bash
export PATH=$PATH:~/coms3102bin/hw5
#ipstuff.sh HNAME ITER

#If 0 args, use cunix.cc.columbia.edu for HNAME
#and 5 for ITER
#If 1 arg, use $1 for HNAME, also use 5 for ITER
#If 2 args, use $1 for HNAME and $2 for ITER
ITER=$2
HNAME=$1

if [ "$#" -eq 0 ]; then
#if number of args = 0
	HNAME=cunix.cc.columbia.edu
	ITER=5	

elif [ "$#" -eq 1 ]; then
#if number of args = 1
	HNAME=$1
	ITER=5
else
	HNAME=$1
	ITER=$2
fi

usage(){

        echo "USAGE: ipstuff.sh: [ $HNAME | $HNAME $ITER ]"
        exit 130
}


oneip(){
        if host ${1} > /dev/null; then
                host $HNAME | grep -w "has address" | head -1 | cut -d' ' -f 4
        else
                echo NA;
        fi
}

ipdate(){
	#Print seconds since UNIX epoch
	date +%s

}

ipname(){

	nslookup google.com | head -1 | tr -d '\t' | cut -d':' -f  2 

}

myipfile(){

	grep $(hostname) /etc/hosts | head -1 | awk '{print $1}'
}

# print out csv with ITER lines 
echo "UID, DATE, MYIP-FROM-FILE, MY-DNS, HOSTQUERY, RESP-FROM-DNS"; 
for i in $(seq 1 $ITER); 
do
#echo "$(id -u),$(ipdate),$(myipfile),$(ipns ${HNAME}),${HNAME},$(oneip ${HNAME})"; # lets have a rest for 5 seconds sleep 5;
echo "$(id -u),$(ipdate),$(myipfile),$(ipname ${HNAME}),${HNAME},$(oneip ${HNAME})"; # lets have a rest for 5 seconds sleep 5;


done

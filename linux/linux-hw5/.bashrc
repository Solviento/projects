# .bashrc

# Source global definitions
if [ -f /etc/bashrc ]; then
	. /etc/bashrc
fi

#Prompt change:
if [ $(id -u) -eq 0 ]; then
#root access (#)
	export PS1="\e[0;33m[\t \u@\h \w $HISTCMD]\\'#'"
else 
#non root access ($)
	
	export PROMPT_DIRTRIM=2
	#NEED TO INCLUDE HISTORY COMMAND NUMBER (1000+)
	#PROMPT='$ blah >:'
	export PS1='\e[0;33m[\t \u@\h \w $HISTCMD]\\$'
	
fi

# User specific aliases and functions

alias hwa='echo hello world'

alias cunix='ssh cunix.cc.columbia.edu'

function scpcu {

	scp $1 jp3476@cunix.cc.columbia.edu:~


}


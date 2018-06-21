# .bashrc

# Source global definitions

if [ -f /etc/bashrc ]; then
	. /etc/bashrc
fi

# Custom prompt change:

if [ $(id -u) -eq 0 ]; then
	#root access (#)
	
	export PS1="\e[0;33m[\t \u@\h \w $HISTCMD]\\'#'"

else 
	#non root access ($)
	
	export PROMPT_DIRTRIM=2
	
	export PS1='\e[0;33m[\d, \t \u@\h \w $HISTCMD]\\$'
	
fi

# User specific aliases and functions (aka shortcuts)

alias cunix='ssh jp3476@cunix.cc.columbia.edu'

#alias ...

function scpcu {

	scp $1 jp3476@cunix.cc.columbia.edu:~

}

gitpush(){
    git add .
    git commit -m "$*"
    git push
}
alias gp=gitpush


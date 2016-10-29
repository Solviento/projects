# .bashrc

# Source global definitions
if [ -f /etc/bashrc ]; then
	. /etc/bashrc
fi

# User specific aliases and functions

alias hwa='echo hello world'

alias cunix='ssh cunix.cc.columbia.edu'

function scpcu {

	scp $1 jp3476@cunix.cc.columbia.edu:~


}


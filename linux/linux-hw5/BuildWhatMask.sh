#!/bin/bash

export PATH=$PATH:~/coms3102bin/hw5

INSTALLDIR=~/bin #Creates variable 'bin'

BUILDDIR=~/wmbuild #Creates variable 'wmbuild'

BUILDVER=whatmask-1.2 #Creates variable check for version number

if [ -d "$INSTALLDIR/whatmask" ]; then
	echo "/bin/whatmasknot found"
	exit 0

elif [ ! -d "$INSTALLDIR" ]; then

	echo "/bin created"
	mkdir -p $pwd/$INSTALLDIR 
	#Remember, for variables to be used, must $ them into statement

	if [ ! -d "$BUILDDIR" ]; then
	
		mkdir -p $BUILDDIR
	
		cd $BUILDDIR

		if [ ! -d "$BUILDDIR/whatmask-1.2.tar.gz" ]; then
		
			wget http://www.columbia.edu/~dm2474/3102/whatmask-1.2.tar.gz
			tar -xvf whatmask-1.2.tar.gz
	
			cd $BUILDDIR/$BUILDVER		
		
			./configure || exit
			make || exit

			cp $BUILDDIR/$BUILDVER/whatmask $INSTALLDIR/whatmask
			
			$INSTALLDIR/whatmask $1

			if [ $? -ne 0 ]; then
				echo "Error, exiting"
				exit 0
			fi
	
			rm $BUILDDIR/$BUILDVER -r -f
			cd
			rm $INSTALLDIR -r -f
		fi			
	fi
fi

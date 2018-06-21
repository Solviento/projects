Handy list of useful commands

- which
	
	Ex:
	
	which whoami.file

	Locates and displays all files with search parameter. Not very efficient
	since this uses up a lot of memory during the search process.

- chmod
	
	How it works:

	chmod 700 filename
	
	set permissions of filename to rwx------

	chmod 666 directoryname

	set permissions of directoryname to rw-rw-rw

	The 3 digit number can be set from (0-7)(0-7)(0-7)
	0 being no permissions, 7 being maximum permissions

- ls -l

	- Will list all files and their permissions, fileowner id, group id, etc

- mv

	Ex:

	mv filename newfilename
	
	move contents of filename to newfilename

	mv directoryname newdirectoryname

	move contents of directoryname to newdirectoryname

- export

	Ex:

	export someEnvironmentVariable="value"

	add new environment variable in current shell

- ln

	Ex:

	ln -s source target

	create symbolic link from source to target (ONLY if target does not exist within directory)

- tar
	
	Ex:

	tar cvzf ./filename.tar.gz ./sourceDirectoryorFile

	create tarball of file(s) in source directory/file

	tar tvzf ./filename.tar.gz

	lets you examine contents of tarball

- sed

	Ex:

	sed -e 's, %, $, g'

	replaces all occurrences of % with $

- diff
	
	Ex:

	diff file1 file2

	outputs differences between two files


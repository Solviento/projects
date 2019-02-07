import os 
import sys

def walkfs(startdir, findfile):
    
    if not os.path.exists(startdir): 
        raise FileNotFoundError
        return
    
    if not os.path.isdir(startdir):
        raise NotADirectoryError
        return
        
    if os.path.isdir(startdir):
        
        dircount = 0
        filecount = 0
        
        dictionary = {}
        
        dictionary['findfile'] = findfile
        dictionary['stardir'] = startdir
        
        for curDir, dirs, files in os.walk(startdir):
            
            for file in files:
                
                filecount += len(files)
                dircount += len(dirs)
                
                if file.endswith(findfile):
                    dictionary['findfilepath'] = os.path.join(curDir, file)
                
        dictionary['dircnt'] = dircount
        dictionary['filecnt'] = filecount
           
    return(dictionary)
    
def report(startdir, findfile, reportpath):
    
    diction = walkfs(startdir, findfile)
    
    dcount = 0
    fcount = 0
    
    for key, value in diction.items():
        
        dcount = diction.get('dircnt')
        fcount = diction.get('filecnt')
            
        if key == 'findfilepath':
            
            fpath = diction.get(key)
            
            with open(reportpath, 'w') as report:
                
                report.write("recursively searched from startdir:\n%s\nfound %d dirs \nfound %d files \n\nfound file: \n%s \nfilecontents: \n\n" % (startdir, dcount, fcount, fpath))
                
            foundpath = diction.get('findfilepath')
                
            with open(foundpath, "r") as p:
                    with open(reportpath, "a") as f:
                        for line in p:
                            f.write(line)
                
            break
        else:
            with open(reportpath, 'w') as report:
                
                report.write("recursively searched from startdir:\n%s\nfound %d dirs \nfound %d files \n\ndid not find file: \n%s " % (startdir, dcount, fcount, findfile))
                break
  
#Report.txt is written in the filepath
# \\tmp when run

def report(startdir, findfile, reportpath):
    
    diction = walkfs(startdir, findfile)
    
    dcount = 0
    fcount = 0
    
    for key, value in diction.items():
        
        dcount = diction.get('dircnt')
        fcount = diction.get('filecnt')
            
        if key == 'findfilepath':
            
            fpath = diction.get(key)
            
            with open(reportpath, 'w') as report:
                
                report.write("recursively searched from startdir:\n%s\nfound %d dirs \nfound %d files \n\nfound file: \n%s \nfilecontents: \n\n" % (startdir, dcount, fcount, fpath))
                
            foundpath = diction.get('findfilepath')
                
            with open(foundpath, "r") as p:
                    with open(reportpath, "a") as f:
                        for line in p:
                            f.write(line)
                
            break
        else:
            with open(reportpath, 'w') as report:
                
                report.write("recursively searched from startdir:\n%s\nfound %d dirs \nfound %d files \n\ndid not find file: \n%s " % (startdir, dcount, fcount, findfile))
                break
    return(diction)

#!/usr/bin/python

#When run on personal computer, jupyter did not read filepath 
#correctly when calling through the report.py script
#walkfs and report work normally for my PC (windows - 64bit)
#but with the way jupyter and anacadonda seem to be set up
#the relative root filepath changes between
#C:\Users\Jason and C:\User\Jason\Documents\Python
#This technicality made it extrememly difficult for me to debug
#my code, therefore, my script most likely does not work
#as jupyter did not let me run command line arguments as
#instructed in the assignment "python report.py reportpath ..."
#However, the try block is included with both exceptions
#and sys.argv arguments, so there should be some exception
#pulled if filenotfound or notadirectoryerror is raised

#REPORT.PY SCRIPT

import sys
import os

def walkfs(startdir, findfile):
    
    
    if not os.path.exists(startdir):
        raise FileNotFoundError
        return
    
    if not os.path.isdir(startdir):
        raise NotADirectoryError
        return
        
    if os.path.isdir(startdir):
        
        dircount = 0
        filecount = 0
        
        dictionary = {}
        
        dictionary['findfile'] = findfile
        dictionary['stardir'] = startdir
        
        for curDir, dirs, files in os.walk(startdir):
            
            for file in files:
                
                filecount += len(files)
                dircount += len(dirs)
                
                if file.endswith(findfile):
                    dictionary['findfilepath'] = os.path.join(curDir, file)
                
        dictionary['dircnt'] = dircount
        dictionary['filecnt'] = filecount
           
    return(dictionary)
    
def report(startdir, findfile, reportpath):
    
    diction = walkfs(startdir, findfile)
    
    dcount = 0
    fcount = 0
    
    
    while True:
        
        dcount = diction.get('dircnt')
        fcount = diction.get('filecnt')
            
        if 'findfilepath' in diction:
            
            fpath = diction.get('findfilepath')
            
            with open(reportpath, 'w') as report:
                
                report.write("recursively searched from startdir:\n%s\nfound %d dirs \nfound %d files \n\nfound file: \n%s \nfilecontents: \n\n" % (startdir, dcount, fcount, fpath))
                
            foundpath = diction.get('findfilepath')
                
            with open(foundpath, "r") as p:
                    with open(reportpath, "a") as f:
                        for line in p:
                            f.write(line)
                
            break
        
        else:
            with open(reportpath, 'w') as report:
                
                report.write("recursively searched from startdir:\n%s\nfound %d dirs \nfound %d files \n\ndid not find file: \n%s " % (startdir, dcount, fcount, findfile))
                break

class venditem:
    
    def __init__(self, name, price, quantity):
        
        self.name = name
        self.price = price
        self.quantity = quantity
        
    def __repr__(self):
        
        return("venditem(name=%s, price=%d, quantity=%d)" %(self.name, self.price, self.quantity))

        
    def sale(self):
        self.quantity -= 1
        
    def __str__(self):        
        return self.__repr__()
    
import time

class vendmachine:
    
    items = {}
    cash = 0
    
    def __init__(self, stock):
        
        self.stock = stock
        
        for vend in self.stock:
            vendmachine.items[vend.name] = vend
        
    def buy(self, name, money):
        
        #items = {'someitem': someVendItem}
        if not name in vendmachine.items:
            t = time.strftime('%X %x %Z - ')
            msg = t + ': ' + 'not carried: ' + name
            print(msg)
            
            return(money)
        
        elif vendmachine.items[name].quantity == 0:
            t = time.strftime('%X %x %Z - ')
            msg = t + ': ' + 'out of stock ' + name
            print(msg)
            return(money)
        
        elif money < vendmachine.items[name].price:
            
            t = time.strftime('%X %x %Z - ')
            msg = t + ': ' + 'insufficient funds for: ' + name
            print(msg)
            
            return(money)
        else:
            vendmachine.cash = money
            vendmachine.items[name].sale()
            
            t = time.strftime('%X %x %Z - ')
            msg = t + ': ' + 'sold: ' + name
            print(msg)
            
            change = vendmachine.cash - vendmachine.items[name].price
            return(change)
        
        
    def status(self):
        print ("cash collected: %d" %vendmachine.cash)
        for it in self.stock:
            print(it)




def main():
    
    report(sys.argv[1], sys.argv[2], sys.argv[3])
    vi = venditem('coke', 95, 3)
    vi2 = venditem('pepsi', 110, 1)
    vi3 = venditem('peanut M&Ms', 100,  2)
    stock = [vi, vi2, vi3]

    vm = vendmachine(stock)
    vm.status()

if __name__ == "__main__":
    main() 
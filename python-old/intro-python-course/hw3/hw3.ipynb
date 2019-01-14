"""
Jason Perez
jp3476
Homework 3
"""
def decimals(divisor):
    
    r = 10
    
    #Might want to add divmod here to check for repeating q, r
    
    while(r > 0):
        
        q, r = divmod(r, divisor)
        
        yield(q)
        
        r *= 10

def genlimit(g, limit):
    
    counter = 0
    
    #g is decimals(divisor)
    
    while (counter < limit):
        
        x = next(g)
        
        yield(x)
        
        counter = counter + 1
        
def decimals2(divisor):
    
    #Yields (or generates) the decimals of 1/divisor
    #Halts and yields pattern if one exists
    #i.e. decimals2(3) -> [3, [3]] "1/3 = .33..."
    
    r = 10
    
    seen = []
    repeatedDigits = []
    
    while(r > 0):
        
        q, r = divmod(r, divisor)
        
        if ([q, r] in seen):
            
            break
            #Based on hint from hw
        
        seen.append([q, r])
          
        repeatedDigits.append(q)
                
        yield(q)

        r *= 10
    
    yield (repeatedDigits)
    
def select(inputList, selectors):
    #Note: I changed input to inputList for syntax reasons
    #Will return a list representation like so:
    #abcdef (input)
    #010100 (selector)
    #-b-d-- (Result)

    length = len(inputList)
    
    outputList = []
    
    for i in range(0, length):

        if (type(selectors[i]) == list):
            
            if (len(selectors[i]) != 0):
                
                outputList.append(inputList[i])
        
        if (type(selectors[i]) == str):
            
            if (len(selectors[i]) != 0):
                
                outputList.append(inputList[i])
                
        if (type(selectors[i]) == bool):
            
            if selectors[i] != False:
                
                outputList.append(inputList[i])
                
        if (type(selectors[i]) == int):
            
            if selectors[i] != 0:
                
                outputList.append(inputList[i])
            
    return outputList


def intToNDigits(x, n):
    
    #Converts int x to binary representation
    
    bits = []
    
    division = x // 2
    
    while(division > 0):
        
        division = x // 2
        
        bit = x % 2
        
        bits.insert(0, bit)
        
        x = division
        #Divide by 2, mod remainder by 2, get bit
        #Rinse and repeat
        
    if (x == 1):
        bits.insert(0, 1)
        
    length = len(bits)
    
    difference = n - length
    
    for i in range(0, difference):
        
        bits.insert(0, 0)
    
    #print(bits)
    return (bits)

def powerSet(x):
    #Uses select and intToNDigits functions
    #x is a list

    length = len(x)
    
    power = 2 ** length
    
    selectorList = []
    
    for i in range(1, power): 
        
        selectorList.append(intToNDigits(i, length))
        
    subset = []
    subset.append(set())
    
        
    for j in selectorList:

        sub = set()        

        selectList = select(x, j)     
        
        for m in selectList:
            sub.add(m)
        
        subset.append(sub)
     
    return (subset)


def dotn(*args):
    
    #Dot product of any number of generator and list inputs
    
    x = zip(*args)

    zipList = list(x)
    length = len(zipList) 
    
    dotProduct = 0
    
    for i in range(0, length):

        subZip = zipList[i]
        subLength = len(subZip)
        
        sumProduct = 1
        
        for i in range(0, subLength):
            sumProduct = sumProduct * subZip[i]
            #zip() allows for product of each sublength
        
        dotProduct = dotProduct + sumProduct
        
    return dotProduct        
    

def countBases(dna):
    
    bases = 'ACGT'
    hashDictionary = {}
    
    for i in range(0, 4):

        base = bases[i]
        
        hashDictionary[base] = 0
        
    for j in range(0, len(dna)):
        
        if (dna[j] in hashDictionary.keys()):
            
            count = hashDictionary[dna[j]]
            
            count = count +1
            
            hashDictionary[dna[j]] = count
            #Counter update for each dna strand found
            
    return (hashDictionary)
    
  
def percentBases(string):
   
    #Gives percentage of keys in a hashmap
   
   dnaTable = countBases(string)
   
   total = 0
   
   percentDictionary = {}
   
   for key, value in dnaTable.items():
       
       total = total + value
       
   for i, j in dnaTable.items():
       
       freq = j / total
       insertSubset = {i: freq}
       percentDictionary.update(insertSubset)
       #Updates with alpha and percentage
       
   return (percentDictionary)
    
    
def reverseComplement(dna):
    
    #Will exchange alphas and reverse a dna string
    newDna = ""
    reverseDna = ""
    
    for i in range(0, len(dna)):
        
        if (dna[i] == 'A'):
            newDna = newDna + 'T'
            
        if (dna[i] == 'T'):
            newDna = newDna + 'A'
            
        if (dna[i] == 'C'):
            newDna = newDna + 'G'
            
        if (dna[i] == 'G'):
            newDna = newDna + 'C'
    
    for j in newDna[::-1]: 
        #Reverse transversal of newDna
        
        reverseDna = reverseDna + j
    
    return(reverseDna)


    
"""
Jason Perez
jp3476
Homework 2
"""

def dot(list1, list2):

    list1 = list1[:3]
    list2 = list2[:3]
    'list1[:3] will list up until the first 3 elements'
    'list1[:2] likewise, will list up until the first 2 elements'
    
    xcord1, ycord1, zcord1 = list1
    xcord2, ycord2, zcord2 = list2

    xprod = xcord1 * xcord2
    yprod = ycord1 * ycord2
    zprod = zcord1 * zcord2

    dotproduct = xprod + yprod + zprod

    return dotproduct


def shortlong(list1, list2):
    
    length1 = len(list1)
    length2 = len(list2)
    
    if (length1 < length2):
        
        outputList = [list1, length1, list2, length2]
        return outputList
        
    if (length2 < length1):
        
        outputList = [list2, length2, list1, length2]
        return outputList
        

def dotmv(list1, list2, offset):
    
    length1 = len(list1)
    length2 = len(list2)
    
    if (length1 > length2):
        list1 = list1[offset:]
    if (length2 > length1):
        list2 = list2[offset:]
        
    return dot(list1, list2)
    

def dotpad(list1, list2, padNumber):
    
    length1 = len(list1)
    length2 = len(list2)
    dotProduct = 0
    
    if (length1 > length2):
        iteration = length1 - length2
        for i in range(0, iteration):
            list2.append(padNumber)
            
        for i in range(0, length1):
            cordProduct = list1[i] * list2[i]
            dotProduct = dotProduct + cordProduct
            
    if (length2 > length1):
        iteration = length2 - length1
        for i in range(0, iteration):
            list1.append(padNumber)
            
        for i in range(0, length2):
            cordProduct = list1[i] * list2[i]
            dotProduct = dotProduct + cordProduct
         
    return dotProduct

def removeCharacters(string):
    removeClass = "<class '"
    removeRest = "'>"

    halfString = string.replace(removeClass, "")
    editedString = halfString.replace(removeRest, "")

    return editedString

def cbt(list1):
    
    'Need to implement better subfunctions'
    
    length1 = len(list1)
    
    masterDictionary = {} 
    foundDictionary = {}
    
    stringList = []
    stringConcatAlpha = ""
    floatSum = 0
    intSum = 0
    
    for i in range(0, length1):
        
        key = removeCharacters(str(type(list1[i])))
        
        if (key in masterDictionary):
            
            List = masterDictionary.get(key) #Get list from key
            List.append(list1[i]) #Add element to list
            masterDictionary[key] = List #Updates value in list
            
            #print(List)
            
        if (key not in masterDictionary):
            masterDictionary[key] = [list1[i]] #Create key & list    
        
        if type(list1[i]) in foundDictionary:
            value = foundDictionary.get(type(list1[i]))
            value = value + 1
            foundDictionary[type(list1[i])] = value
            'Looks for key in dictionary, adds +1 to counter'
            
            if (type(list1[i]) == type("Yay")):
                stringList.append(list1[i])
                
            if (type(list1[i]) == type(1)):
                intSum += list1[i]
                
            if (type(list1[i]) == type(1.0)):
                floatSum += list1[i]
                
            'Checks for string, floats, and ints already in dictionary'
                
        else:
            foundDictionary.update({type(list1[i]) : 1})
            'Adds key to dictionary'
            if (type(list1[i]) == type("Yay")):
                stringList.append(list1[i])
                
            if (type(list1[i]) == type(1)):
                intSum += list1[i]
                
            if (type(list1[i]) == type(1.0)):
                floatSum += list1[i]
               
            'Checks for string, floats, and ints'
                
    for key in foundDictionary:
        print("Found " + str(foundDictionary[key]) + " of " + str(key))
    
    if (intSum != 0):
        print("sum of <class 'int'> is " + str(intSum))
        
    if (floatSum != 0):
        print("sum of <class 'float'> is " + str(floatSum))
    'Prints found types and float, int sums'
    
    stringList.sort()
    
    for i in stringList:
        stringConcatAlpha += (i + "|")
    'Alpha sorted concatenation of all string types'
    
    print("alpha sorted concat of strings: " + stringConcatAlpha)
    
    return masterDictionary
    'Returns specified result'

def partition(l, n, overlap):
    
    list1 = [l[i: i + n] for i in range(0, len(l), n-overlap)]
    
    if (overlap > 0):
        #del list1[len(list1) - 1]
        #list1.pop(-1)
        x = 1
    'Need to remove non n segments in return list1'
        
    print(list1)
    return list1
    
def flatten(nestedList):
    
    flatten = []
    
    for i in nestedList:
        
        if type(i) == list:
            for j in i:
                flatten.append(j)
                'Will iterate through an append each element in the list'
        else:
            flatten.append(i)
            'Append each element as normal'
            
    return flatten
    
def expandlazy(anyType):
 
    'Checks each type, acts accordingly for return value'
    
    if (isinstance(anyType, int)):
        return (anyType)
        
    if (isinstance(anyType, str)):
        return anyType
    
    if (isinstance(anyType, range)):
        
        rangeList = list(anyType)
        
        return (rangeList)
    
    if (isinstance(anyType, enumerate)):
        
        enumList = []
        for i in anyType:
            enumList.append(i)
        
        return enumList
        
    if (isinstance(anyType, zip)):
        
        ziplist = []
        
        for i in anyType:
            ziplist.append(i)
        
        return ziplist
        
        
def expandlazylist(anyType):
    
    'Uses expand lazy to evaluate each element in input list'
    
    anyList = []
    
    for i in anyType:
        
        if (isinstance(i, int)):
    
            anyList.append(expandlazy(i))
        
        if (isinstance(i, str)):
            
            anyList.append(expandlazy(i))
            
        if (isinstance(i, range)):
            
            anyList.append(expandlazy(i))
            
        if (isinstance(i, enumerate)):
            
            anyList.append(expandlazy(i))
            
        if (isinstance(i, zip)):
            
            anyList.append(expandlazy(i))
            
    return anyList
    
    
def main():
    
    x = [1,2,3, range(4), 5, zip([1,2,3], [4,5]), 'asdf', enumerate(['a', 'b', 'c'])]
    
    print(flatten([1,[2,3,4,[5,6,[7,8],9],11]]))
    
if __name__ == "__main__":
    main() 
    

class Zillion:
    def __init__(self,x):
        Zillion.y=[]
        #assert type(x)==str
        if len(x)!=0:
            try:
                int(x[0])
                for ch in x:
                    #y=list()
                    if ch is not " " and ch is not ',' :
                        try:
                            (Zillion.y).append(int(ch))
                        except:
                            print("Non-digit is in the string")
                            break
            except:
                print ("No digit in the string")
        else:
            print ("Empty string")
    def __str__(self):
        return str(Zillion.y)
    def increment(self):
        x=Zillion.y.copy()
        x.reverse()
        #print(x)
        for i in range(len(x)):
            if x[i] + 1>=10:
                if i ==len(x)-1:
                    x[i]=0
                    x.append(1)
                    break
                x[i]=0
                continue
            else:
                x[i]=x[i]+1
                break
        x.reverse()
        Zillion.y=x.copy()
    def isZero(self):
        if len(Zillion.y)!=0:
            return (Zillion.y[0]==0)
    def toString(self):
        if len(Zillion.y)!=0:
            for i in range (len(Zillion.y)-2):
                str_y = ""
                str_y =''.join(map(str,Zillion.y))
                return str_y
#c=zillion('999, 999, 999, 9999999 9999 9999')
#c.increment()
#c.increment()
#print(c.isZero())
#print(c.toString())
#######################################################
print("Test Cases.................")

try:
  z = Zillion('')
  #print(z)
except RuntimeError:
  print('Empty string')

# It must print 'Empty string' without apostrophes. 2 points.

try:
  z = Zillion(' , ')
except RuntimeError:
  print('No digits in the string')

# It must print 'No digits in the string' without apostrophes. 2 points.

try:
  z = Zillion('1+0')
except RuntimeError:
  print('Non-digit in the string')

# It must print 'Non-digit in the string' without apostrophes. 2 points.

try:
  z = Zillion('0')
  #print(z)
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000000000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('000 000 000')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing. 2 points.

print(z.isZero())    #  It must print True. 2 points.

try:
  z = Zillion('997')
except RuntimeError:
  print('This must not be printed')

#  It must print nothing.  2 points.

print(z.isZero())    #  It must print False. 2 points.

print(z.toString())  #  It must print 997. 2 points.

z.increment()

print(z.toString())  #  It must print 998. 2 points.

z.increment()

print(z.toString())  #  It must print 999. 2 points.

z.increment()

print(z.toString())  #  It must print 1000. 2 points.

try:
  z = Zillion('0 9,9 9')
except:
  print('This must not be printed')

#  It must print nothing.  3 points.

z.increment()
print(z.toString())  #  It must print 1000. 2 points.

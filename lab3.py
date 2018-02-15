from functools import reduce

def Maximum(x):
       f=lambda x,y: x if x > y else y
       t=reduce(f,x)
       return t

print(Maximum((1,2,5,5,5,5,5,5)))


def Remove(c,v):
   #f=lambda x: x !=v
   t = tuple()
   #return tuple(filter (f,c))

   if len(c)==0 or v not in c:
       return t
   else:

       a = c.index(v)
       d = c[0:a] + c[a+1:]

       return d



#print(Remove((0, 1, 2, 1, 3), 1))
#print(Remove((0, 1), 0))
#print(Remove((), 1))



def Sort(c):
   b = tuple()
   if len(c) == 1:
       #print("here")
       return c
   #    return c
   #else:
   else:
       b = Sort(Remove(c,Maximum(c))) + (Maximum(c),)

       return b


#print(Sort((6)))
#return(Sort((0, 0, 1)))
print(Sort((9, 8, 7, 6, 5, 4, 3, 2, 1)))
print(Sort((1, 2, 1, 4, 2, 5, 4, 5, 3)))

class zillion:
    y=list()
    def __init__(self,x):
        assert type(x)==str
        for ch in x:
            #y=list()
            if ch is not " " and ch is not ',' :
                (zillion.y).append(int(ch))
    def __str__(self):
        return str(zillion.y)
    def increment(self):
        x=zillion.y.copy()
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
        zillion.y=x.copy()
    def isZero(self):
        return (zillion.y[0]==0)
    def toString(self):
        for i in range (len(zillion.y)-2):
            str_y = ""
            str_y =''.join(map(str,zillion.y))
            return str_y
c=zillion('999, 999, 999, 9999999 9999 9999')
c.increment()
#c.increment()
print(c.isZero())
print(c.toString())

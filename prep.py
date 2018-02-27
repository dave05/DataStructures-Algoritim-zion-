
a = 7**5
b = 2**31
class Random:

    def __init__(self,seed):
        self.s = seed # current object will store seed as properties, has the seed and tells


      # random = Random(seed) #instances of class random

    def next(self): # generate the next integer
            self.s= (a*self.s)%(b-1)


        return self.s
    def choose(self, objects): # choose an element from the tuple at random using index

        index = (self.next())%(len(objects))
        chosen = objects[index]

        return chosen


    def __str__ ():
        return str(self.nex)


class Grammar:
    def __init__(self,seed):

        self.grandom = Random(seed) # instances of the random number to generate the pseudo-random integers
        self.mezgeb = {}
        #grammer = Grammer(seed)
    def rule(self, left, right):

        if left not in self.mezgeb.keys():
            self.mezgeb[left] = [right]

        else:
            self.mezgeb[left] += right




    def generating(self, strings):
        self.g = ''

        for string in strings:
            if string not in self.mezgeb.keys():

                self.g = self.g + string + ' '

                print("this is the string "  + string)
            else:
                 j = self.mezgeb[string]
                 k = self.grandom.choose(j)
                 self.g = self.g + self.generating(k)


        return self.g

    def generate(self):
        if 'Start' in self.mezgeb.keys():


            return self.generating(('Start',))

        else:
            raise ValueError

    def __str__(self):  #to retrun a string
        return str(self.g)


G = Grammar(101)
G.rule('Noun',   ('cat',))                                #  01
G.rule('Noun',   ('boy',))                                #  02
G.rule('Noun',   ('dog',))                                #  03
G.rule('Noun',   ('girl',))                               #  04
G.rule('Verb',   ('bit',))                                #  05
G.rule('Verb',   ('chased',))                             #  06
G.rule('Verb',   ('kissed',))                             #  07
G.rule('Phrase', ('the', 'Noun', 'Verb', 'the', 'Noun'))  #  08
G.rule('Story',  ('Phrase',))                             #  09
G.rule('Story',  ('Phrase', 'and', 'Story'))              #  10
G.rule('Start',  ('Story', '.'))

#print(G)

print(G.generate())

print(G.generate())
print(G.generate())







t = Random(101)
print(t.next())
print(t.next())
print(t.next())
print(t.next())
#print(t.nex)

#t.next

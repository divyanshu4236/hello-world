
import math
import os
import random
import re
import sys

n = int(input())
c,mi=0,1000000
ind=0
l=[0]*11
l = [0]*11
for i in range(1,10):
    c = n//i
    if n%i==0:
        mi=c
        ind=i
        break
    if n%i!=0:
        c+=1
        l[i]=1
    if c<mi:
        mi=c
        ind = i
print(mi)
for i in range(mi):
    if i==0 and l[ind]==1:
        print(n%ind,end=" ")
    else:
        print(ind,end=" ")
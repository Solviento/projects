from gopigo import *
from time import sleep

''' file will test accuracy of sonic sensor '''

while True:

    dist = us_dist(15)
    print type(dist)
    print dist

    sleep(1)

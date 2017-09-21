from gopigo import *
from time import sleep

enc_tgt(1, 1, 18)
fwd()

sleep(1)

status = read_enc_status()
print(status)

enc_tgt(1, 1, 18)
bwd()

sleep(1)

status = read_enc_status()
print(status)

import time,threading,os
os.system("cls")
start=time.perf_counter()
threads=[]
def do_something(seconds):
    print("Sleeping for 1 second")
    time.sleep(seconds)
    print("Done Sleeping")
for _ in range(10): 
    t=threading.Thread(target=do_something,args=[1.5])
    t.start()
    threads.append(t)
for thread in threads:
    thread.join()

finish=time.perf_counter()
print(f'Program finished in {round(finish-start,2)}.')

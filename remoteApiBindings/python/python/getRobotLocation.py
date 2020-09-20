import sim
import time

sim.simxFinish(-1)
clientID = sim.simxStart('127.0.0.1', 19999, True, True, 5000, 5)
if clientID != -1:
    print('已经连接到服务器')

    while True:

        a, hexa_base_handle = sim.simxGetObjectHandle(clientID, 'youBot', sim.simx_opmode_blocking)
        b, floor_visible_handle = sim.simxGetObjectHandle(clientID, 'ResizableFloor_5_25', sim.simx_opmode_blocking)
        c, pillar_visible_handle = sim.simxGetObjectHandle(clientID, '80cmHighPillar25cm', sim.simx_opmode_blocking)
        print(hexa_base_handle)
        print(floor_visible_handle)
        ret, positon = sim.simxGetObjectPosition(clientID, hexa_base_handle, floor_visible_handle, sim.simx_opmode_blocking)
        print(positon)
        if ret == sim.simx_return_ok:
            print("Position")
            print(positon)
        time.sleep(0.2)
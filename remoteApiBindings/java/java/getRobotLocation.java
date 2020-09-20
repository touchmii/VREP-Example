import coppelia.FloatWA;
import coppelia.IntW;
import coppelia.IntWA;
import coppelia.remoteApi;

public class getRobotLocation {
    public static void main(String[] args) {
        System.out.println("Program started");
        remoteApi sim = new remoteApi();
        sim.simxFinish(-1);
        int clientID = sim.simxStart("127.0.0.1", 19999, true, true, 5000, 5);
        if (clientID != -1) {
            System.out.println("已经连接到服务器");
            IntW floor_handel = new IntW(-1);
            IntW robot_handel = new IntW(-1);
            int floor_handel_ret = sim.simxGetObjectHandle(clientID, "ResizableFloor_5_25", floor_handel, sim.simx_opmode_blocking);
            int robot_handel_ret = sim.simxGetObjectHandle(clientID, "youBot", robot_handel, sim.simx_opmode_blocking);
            FloatWA position = new FloatWA(3);
            int ret = sim.simxGetObjectPosition(clientID, robot_handel.getValue(), floor_handel.getValue(), position, sim.simx_opmode_blocking);
            if (ret == 0) {
                System.out.println(String.format("Positon: {}", position));
                System.out.println(position);
            }
        }
    }
}

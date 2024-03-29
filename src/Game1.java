import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Ghi chú:
// 1.Game có thể thay đổi size map bằng cách thay số ở mapwidth và mapheight
// 2.Game có thể thêm key và enemy chỉ bằng các biến mới, thuật toán không đổi
//   (vd: thêm 1 enemy 3 ta thêm enemy3X, enemy3Y sau đó copy paste đoạn code có mặt enemy 1 hoặc 2 và thay bằng số 3.)
//   (tương tự với key)
// 3.Luật thắng có giả thiết nếu trong 1 lượt, player, key và enemy trên cùng 1 ô thì player vẫn thắng.


public class Game1 {
    int playerX ;
    int playerY ;

    int enemy1X ;
    int enemy1Y ;

    int enemy2X ;
    int enemy2Y ;

    int mapwidth;
    int mapheight;

    int keyX;
    int keyY;

    int tempX;
    int tempY;

    int cntNeeded = 1;

    List X_used = new ArrayList();
    List Y_used = new ArrayList();

    int size = 0;

    public Game1() {


        this.setUp();
        this.keyX = keyX;
        this.keyY = keyY;
        //day la toa do player
        this.playerX = playerX;
        this.playerY = playerY;

        this.enemy1X = enemy1X;
        this.enemy1Y = enemy1Y;

        this.enemy2X = enemy2X;
        this.enemy2Y = enemy2Y;

        this.mapheight = 4;
        this.mapwidth = 4;



    }

    public void setUp(){

        int isOk = 0;
        Random rand = new Random();
        while (isOk < cntNeeded ){
            System.out.println(isOk);
            System.out.println(cntNeeded);

            keyX =  rand.nextInt(4);
            keyY =  rand.nextInt(4);
            tempX = keyX;
            tempY = keyY;

            System.out.println(keyX);
            System.out.println(keyY);

            System.out.println("-------------------");
            isOk++;
        }

        this.nextStep();
        while (isOk < cntNeeded ){
            System.out.println(isOk);
            System.out.println(cntNeeded);

            int isSame = 0;
            playerX = tempX = rand.nextInt(4);
            playerY = tempY = rand.nextInt(4);

            System.out.println(playerX);
            System.out.println(playerY);
            System.out.println(X_used);
            System.out.println(Y_used);
            System.out.println("-------------------");
            for(int k = 0; k < size; k ++){
                int lolX = (int) X_used.get(k);
                int lolY = (int) Y_used.get(k);
                if (playerX == lolX && playerY == lolY){
                    isSame++;
                }
            }
            if (isSame == 0){
                isOk++;
            }
        }
        this.nextStep();
        while (isOk < cntNeeded ){
            System.out.println(isOk);
            System.out.println(cntNeeded);
            int isSame = 0;
            enemy1X = tempX = rand.nextInt(4);
            enemy1Y = tempY = rand.nextInt(4);
            System.out.println(enemy1X);
            System.out.println(enemy1Y);
            System.out.println(X_used);
            System.out.println(Y_used);
            System.out.println("-------------------");
            for(int k = 0; k < size; k ++){
                int lolX = (int) X_used.get(k);
                int lolY = (int) Y_used.get(k);
                if (enemy1X == lolX && enemy1Y == lolY){
                    isSame++;
                }
            }
            if (isSame == 0){
                isOk++;
            }
        }
        this.nextStep();
        while (isOk < cntNeeded ){
            System.out.println(isOk);
            System.out.println(cntNeeded);

            int isSame = 0;
            enemy2X = tempX = rand.nextInt(4);
            enemy2Y = tempY = rand.nextInt(4);
            System.out.println(enemy2X);
            System.out.println(enemy2Y);
            System.out.println(X_used);
            System.out.println(Y_used);
            System.out.println("-------------------");
            for(int k = 0; k < size; k ++){
                int lolX = (int) X_used.get(k);
                int lolY = (int) Y_used.get(k);
                if (enemy2X== lolX && enemy2Y == lolY){
                    isSame++;
                }
            }
            if (isSame == 0){
                isOk++;
            }
        }
    }
    public void nextStep(){
        cntNeeded++;
        X_used.add(tempX);
        Y_used.add(tempY);
        size = X_used.size();

    }

    public void enemy1Run(){
        Random rand2 = new Random();
        int choiceXY = rand2.nextInt(2);
        int choiceDI = rand2.nextInt(2);
        if (choiceXY==0){
            if(choiceDI==0){
                if(enemy1X!=0){
                    enemy1X--;
                }
            }
            if(choiceDI==1){
                if(enemy1X!=mapwidth-1){
                    enemy1X++;
                }
            }
        }
        if (choiceXY==1){
            if(choiceDI==0){
                if(enemy1Y!=0){
                    enemy1Y--;
                }
            }
            if(choiceDI==1){
                if(enemy1Y!=mapheight-1){
                    enemy1Y++;
                }
            }
        }


    }
    public void enemy2Run(){
        Random rand3 = new Random();
        int choiceXY = rand3.nextInt(2);
        int choiceDI = rand3.nextInt(2);
        if (choiceXY==0){
            if(choiceDI==0){
                if(enemy2X!=0){
                    enemy2X--;
                }
            }
            if(choiceDI==1){
                if(enemy2X!=mapwidth-1){
                    enemy2X++;
                }
            }
        }
        if (choiceXY==1){
            if(choiceDI==0){
                if(enemy2Y!=0){
                    enemy2Y--;
                }
            }
            if(choiceDI==1){
                if(enemy2Y!=mapheight-1){
                    enemy2Y++;
                }
            }
        }

    }
    public void enemyRun(){
        this.enemy1Run();
        this.enemy2Run();
    }

    public void gameLoop(){
//        int cnt = 0;
        while (true) {
            this.printMap();
            this.run();
            if (playerX == keyX && playerY==keyY){
                this.printMap();
                System.out.println("WIN");
                break;
                //cach 2 System.exit(0);
            }
            else if ((playerX == enemy1X && playerY ==enemy1Y)||(playerX == enemy2X && playerY ==enemy2Y)){
                this.printMap();
                System.out.println("LOSE");
                break;
            }
        }


    }
    public  void run(){
        //player nhap lenh
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
//            System.out.println(input);

        if (input.equals("up")){
            this.playerY--;
            this.enemyRun();
        }
        else if (input.equals("down")){
            this.playerY++;
            this.enemyRun();
        }
        else if (input.equals("right")){
            this.playerX++;
            this.enemyRun();
            //cach 2 if playerX != 3 thi thuc hien lenh
        }
        else if (input.equals("left")){
//            System.out.println("left");
            this.playerX--;
            this.enemyRun();
        }
        this.clamp();
    }

    private void clamp() {
        if (playerX >= mapwidth-1){
            playerX = 3;
        }
        if (playerX <= 0  ){
            playerX = 0;
        }
        if (playerY <= 0  ){
            playerY = 0;
        }
        if (playerY >= mapheight-1){
            playerY = 3;
        }
    }
    public void printMap(){
        for (int i = 0; i < mapheight; i++) {
            for (int j = 0; j < mapwidth; j++) {

                if (i==enemy1Y && j==enemy1X){
                    System.out.print(" E ");
                }
                else if (i==enemy2Y && j==enemy2X){
                    System.out.print(" E ");
                }
                else if (i==playerY && j==playerX){
                    System.out.print(" P ");
                }
                else if (i==keyY && j==keyX){
                    System.out.print(" K ");
                }
                else{
                    System.out.print(" x ");
                }
            }
            System.out.println("");
        }
    }
}

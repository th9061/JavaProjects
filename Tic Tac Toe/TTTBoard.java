import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class TTTBoard extends JPanel
{
    private Square[][] board = new Square[3][3];
    private Random generator = new Random();
    private int moves=0;
    private int[] corners = {0,2,6,8};
    private int stage = 0;
    public TTTBoard()
    {
        setLayout(new GridLayout(3,3));
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                board[i][j] = new Square();
                add(board[i][j]);
                board[i][j].addActionListener(
                    new ActionListener()
                    {
                        public void actionPerformed(ActionEvent e)
                        {
                            Square btn = (Square)e.getSource();
                            if(btn.isAvailable())
                            {
                                btn.setPlayer(1);
                                moves++;
                                if(winner(1))
                                {
                                    System.out.println("You win");
                                } else
                                {                             
                                    if(moves<5)
                                    {
                                        stage1();
                                        if(winner(2))
                                        {
                                            System.out.println("I win");
                                        }
                                    }       
                                }
                            }
                        }
                    }
                );
            }
        }
    }

    private int computersTurn()
    {
        int spot = 0; 
        int r = 0; 
        int c = 0;
        do{
            spot = generator.nextInt(9);
            r = spot/3;
            c = spot%3;
        }while(!board[r][c].isAvailable());
        return r*3 + c;
    }

    public boolean winner(int player)
    {
        for(int r = 0; r<3; r++){
            int count = 0;
            int count2 = 0;
            for(int c = 0; c<3; c++){
                if(board[r][c].getPlayer()==player){
                    count++;
                }
                if(board[c][r].getPlayer()==player){
                    count2++;
                }
            }
            if(count==3||count2==3){
                return true;
            }
        }
        int count3 = 0;
        int count4 = 0;
        for(int a = 0; a<3; a++){
            if(board[a][a].getPlayer()==player){
                count3++;
            }
            if(board[a][2-a].getPlayer()==player){
                count4++;
            }
        }
        if(count3==3||count4==3){
            return true;
        }
        return false;
    }

    public void stage1()
    {
        int spot = checkForTwo(2);
        int r = spot/3; int c = spot%3;
        if(spot==-1){
            if(checkForTwo(1)!=-1){
                spot = checkForTwo(1);
            }else{
                if(board[1][1].isAvailable()){
                    spot = 4;
                }else{
                    if(corner()!=-1){
                        spot = corner();
                    }else{
                        spot = computersTurn();
                    }
                }
            }
        }
        r = spot/3;
        c = spot%3;
        board[r][c].setPlayer(2);
    }

    private int corner()
    {
        int spot = -1;
        int r = 0; int c = 0;
        if(board[0][0].isAvailable()||board[0][2].isAvailable()||board[2][0].isAvailable()||board[2][2].isAvailable()){
            do{
                spot = generator.nextInt(4);
                r = corners[spot]/3;
                c = corners[spot]%3;
            }while(!board[r][c].isAvailable());
        }
        return r*3 + c;
    }

    private int checkForTwo(int player)
    {
        int spot = -1;
        for(int r = 0; r<3; r++){
            int count = 0;
            int count2 = 0;
            for(int c = 0; c<3; c++){
                if(board[r][c].getPlayer()==player){
                    count++;
                }
                if(board[c][r].getPlayer()==player){
                    count2++;
                }
            }
            if(count == 2){
                for(int a = 0; a<3; a++){
                    if(board[r][a].isAvailable()){
                        return r*3 + a;
                    }
                }
            }
            if(count2==2){
                for(int b = 0; b<3; b++){
                    if(board[b][r].isAvailable()){
                        return b*3 + r;
                    }
                }
            }
        }
        int count3 = 0;
        int count4 = 0;
        for(int c = 0; c<3; c++){
            if(board[c][c].getPlayer()==player){
                count3++;
            }
            if(board[c][2-c].getPlayer()==player){
                count4++;
            }
        }
        if(count3==2){
            for(int d = 0; d<3; d++){
                if(board[d][d].isAvailable()){
                    return d*3 + d;
                }
            }
        }
        if(count4==2){
            for(int e = 0; e<3; e++){
                if(board[e][2-e].isAvailable()){
                    return e*3 + 2 - e;
                }
            }
        }
        return spot;
    }
}	
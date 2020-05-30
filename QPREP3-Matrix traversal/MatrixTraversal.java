import java.util.*;

class MatrixTraversal  {
  
      static boolean isSafe(int x, int y, int m, int n) 
          { 
              return (x >= 0 && x < m &&  y >= 0 && y < n); 
          } 

  // complete the below function implementation
  public List<Integer> valueAtNewPosition(int[][] matrix, int currX, int currY, int dir, int steps) {
    List<Integer> lst = new ArrayList<Integer>();
    int flag=0;
    // (RIGHT is 1, DOWN in 2, LEFT is 3 and UP is 4)
    if(dir==1)
    {
        for(int i = 1;i<=steps;i++)
        {
          if (! isSafe(currX, currY+i, matrix.length, matrix[0].length)) 
            {
              flag=1;
              break;
            }
            else
            {
              lst.add(matrix[currX][currY+i]);
            }
        }
    }
    else if(dir==2)
    {
        for(int i = 1;i<=steps;i++)
        {
          if (! isSafe(currX+i, currY, matrix.length, matrix[0].length)) 
          {
           flag=1;
           break;
          }
          else
            {
              lst.add(matrix[currX+i][currY]);
            }
        }
    }
    else if(dir==3)
    {
        for(int i = 1;i<=steps;i++)
        {
          if (! isSafe(currX, currY-i, matrix.length, matrix[0].length)) 
            {
              flag =1;
              break;
            }
            else
            {
              lst.add(matrix[currX][currY-i]);
            }
        }
    }
    else if(dir==4)
    {
        for(int i = 1;i<=steps;i++)
        {
          if (! isSafe(currX-i, currY, matrix.length, matrix[0].length)) 
            {
              flag=1;
              break;
            }
            else
            {
              lst.add(matrix[currX-i][currY]);
            }
        }
    }

    if(flag==1)
    {
      List<Integer> result = new ArrayList<Integer>();
      result.add(-1);
      return result; 
    }
    return lst;
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int m = scanner.nextInt();
    int[][] matrix = new int[n][m];

    for (int i = 0; i < n; ++i) {
      for (int j = 0; j < m; ++j) {
        matrix[i][j] = scanner.nextInt();
      }
    }
    int currPosX = scanner.nextInt();
    int currPosY = scanner.nextInt();
    int dirToMove = scanner.nextInt();
    int stepsToMove = scanner.nextInt();

    scanner.close();
     List<Integer> result = new MatrixTraversal().valueAtNewPosition(matrix, currPosX, currPosY, dirToMove, stepsToMove);

    for (int i = 0; i < result.size(); ++i) {
      System.out.printf("%d ", result.get(i));
    }
  }
}

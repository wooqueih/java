package graphics;

public class TGraphics {
    public TGraphics(int pixelsX, int pixelsY){ //192/96, 49
        state = new double[pixelsX][pixelsY];
        width = pixelsX;
        height = pixelsY;
        for(int x = 0; x < pixelsX; x++){
            for(int y = 0; y < pixelsY; y++){
                state[x][y] = 0;
            }
        }
    }
    public double[][] state;
    public int width;
    public int height;

    public void print(){
        String temp = "";
        for(int y = height-1; y >= 0; y--){
            for(int x = 0; x < width; x++){
                switch((state[x][y] <= 0.1) ? 0 : (state[x][y] <= 0.25) ? 1 : (state[x][y] <= 0.4) ? 2 : (state[x][y] <= 0.6) ? 3 : (state[x][y] <= 0.8) ? 4 : 5){
                    case 0:
                        temp += " ";
                        break;
                    case 1:
                        temp += ".";
                        break;
                    case 2:
                        temp += "*";
                        break;
                    case 3:
                        temp += "+";
                        break;
                    case 4:
                        temp += "/";
                        break;
                    case 5:
                        temp += "#";
                        break;
                }
            }
            temp += "\n";
        }
        System.out.println(temp);
    }
    public static void main(String[] args){
        TGraphics test = new TGraphics(192, 49);
        test.print();
    }
}
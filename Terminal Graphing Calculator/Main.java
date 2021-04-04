public class Main {
    static int f(int x, int min, int max){
        int result = x;
        if(result < max && result > min){
            return result;
        } else {
            return 0;
        }
    }

    public static void main(String[] args){
        int arg0 = Integer.parseInt(args[0]);
        int arg1 = Integer.parseInt(args[1]);
        int argRange = Math.abs(arg0)+Math.abs(arg1);
        //float yScaling = Integer.parseInt(args[2]);
        //float xScaling = Integer.parseInt(args[3]);
        String[][] screen = new String[argRange][argRange];

        for(int n = 0; n < screen.length; n++){
            for(int m = 0; m < screen[n].length-1; m++){
                screen[n][m] = "\s"/*Integer.toString(n)*/;
            }
            screen[n][f(n, arg0, arg1)] = "_";
        }
        for(int n = 0; n < screen.length-1; n++){
            screen[n][screen[n].length-1] = "\n";
        }
        String screenString = "";
        for(int n = 0; n < screen.length; n++){
            for(int m = 0; m < screen.length; m++){
                screenString += screen[m][n];
            }
        }
        System.out.println(screenString);
    }
}
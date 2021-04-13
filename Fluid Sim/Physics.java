public class Physics {
    static class Tile {
        //public double temperature;
        public double density;
        public double[] velocity;

        public Tile(boolean makeRandom){
            if(makeRandom){
                //temperature = Math.random()*70+30;
                density = Math.random()*70+30;
                velocity = new double[2];
                velocity[0] = Math.random()*70+30;
                velocity[1] = Math.random()*70+30;
            } else {
                //temperature = 0;
                density = 0;
                velocity = new double[2];
                velocity[0] = 0;
                velocity[1] = 0;
            }
        }
    }
    static class Handler {
        public Tile[][] state;
        public int width;
        public int height;

        public Handler(int pixelsX, int pixelsY){
            state = new Tile[pixelsX+2][pixelsY+2];
            for(int i = 0; i < state.length; i++){
                for(int j = 0; j < state[i].length; j++){
                    state[i][j] = new Tile(true);
                }
            }
            /* border attributes
            for(int i = 0; i < state[0].length; i++){
                state[0][i].temperature = 0;
                state[state.length-1][i].temperature = 0;
                state[0][i].density = 0;
                state[state.length-1][i].density = 0;
            }
            for(int i = 0; i < state.length; i++){
                state[i][0].temperature = 100;
                state[i][state[0].length-1].temperature = 100;
                state[i][0].density = 100;
                state[i][state[0].length-1].density = 100;
            }
            */
            width = pixelsX;
            height = pixelsY;
        }
        public double[][] currentFrame(){
            double[][] tileBrightness = new double[width][height];
            for(int i = 1; i < width+1; i++){
                for(int j = 1; j < height+1; j++){
                    tileBrightness[i-1][j-1] = state[i][j].density/100;
                }
            }
            return tileBrightness;
        }

        public double[][] nextFrame(){
            double[][] tileBrightness = new double[width][height];
            Tile[][] temp = state;
            for(int i = 1; i < width+1; i++){
                for(int j = 1; j < height+1; j++){
                    temp[i][j] = simulateTile(i, j);
                    tileBrightness[i-1][j-1] = temp[i][j].density/100;
                }
            }
            return tileBrightness;
        }
        public Tile simulateTile(int x, int y){
            Tile outTile = new Tile(false);
            outTile.density = ((state[x+1][y].density + state[x-1][y].density + state[x][y+1].density + state[x][y-1].density)/4);
            simulateDiffusion();
            return outTile;
        }
        public simulateDiffusion(){
            
        }
    }
}
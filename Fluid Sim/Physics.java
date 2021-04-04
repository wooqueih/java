public class Physics {
    static class Tile {
        public double temperature;
        public double density;
        public double[] velocity;

        public Tile(boolean makeRandom){
            if(makeRandom){
                temperature = Math.random()*60+40;
                density = Math.random()*60+40;
                velocity = new double[2];
                velocity[0] = Math.random()*70+30;
                velocity[1] = Math.random()*70+30;
            } else {
                temperature = 0;
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
                    tileBrightness[i-1][j-1] = state[i][j].temperature*state[i][j].density/10000;
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
                    tileBrightness[i-1][j-1] = temp[i][j].temperature*temp[i][j].density/10000;
                }
            }
            return tileBrightness;
        }
        public Tile simulateTile(int x, int y){
            Tile outTile = new Tile(false);
            for(int i = -1; i < 2; i++){
                for(int j = -1; j < 2; j++){
                    outTile.temperature += state[x+i][y+j].temperature;
                    outTile.density += state[x+i][y+j].density;
                }
            }
            outTile.temperature = outTile.temperature/9;
            outTile.density = outTile.density/9;
            return outTile;
        }
    }
}
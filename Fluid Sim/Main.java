import graphics.TGraphics;
public class Main {
    public static void main(String[] args) throws InterruptedException{
        TGraphics display = new TGraphics(192,51);
        Physics.Handler h = new Physics.Handler(192,51);/*
        h.state[1][2].temperature = 100;
        h.state[1][2].density = 100;
        h.state[2][2].temperature = 100;
        h.state[2][2].density = 100;
        h.state[3][2].temperature = 100;
        h.state[3][2].density = 100;
        h.state[1][1].temperature = 100;
        h.state[1][1].density = 100;*/
        display.state = h.currentFrame();
        display.print();
        Thread.sleep(1000);
        int simulationSteps = 10000;
        for(int i = 0; i < simulationSteps; i++){
            //System.out.println("\n\n");
            System.out.print("\033[H\033[2J");  
            System.out.flush();  
            display.state = h.nextFrame();
            display.print();
            Thread.sleep(100);
        }
    }
}
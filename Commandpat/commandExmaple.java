package Commandpat;

interface Command {

    void execute();
}

class MusicPlayer {

    void play() {
        System.out.println("Music is playing");
    }
}

class PlayCommand implements Command { //PlayCommand ko pta rahega ki kha play krna h - Musicplayer/TV/Radio

    MusicPlayer player; //Store krega item ko

    PlayCommand(MusicPlayer p) { //PlayCommand ka constructor
        player = p;
    }

    @Override
    public void execute() { //MusicPlayer ki Command ko execute kiya
        player.play();
    }
}

class RemoteControl { //Command h, command ko set krta h, and press method bhi diya h

    Command cmd;

    void setCommand(Command cmd) {
        this.cmd = cmd;
    }

    void press() {
        cmd.execute();
    }
}

public class commandExmaple {

    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer(); // Music player laya
        Command play = new PlayCommand(player); // Musicplayer me play command fit kia 

        RemoteControl remote = new RemoteControl(); //remote control laya
        remote.setCommand(play);// play method set kiya 
        remote.press(); // press kiya play
    }
}

package command;

public class Main {
  public static void main(String[] args) {
    Command command = new LightCommand(new Light());
    Button button = new Button(command);
    button.pressButton();

    command = new MusicPlayerCommand(new MusicPlayer());
    button = new Button(command);
    button.pressButton();

    command = new CoffeeMachineCommand(new CoffeeMachine());
    button = new Button(command);
    button.pressButton();

    command = new LightAndMusicPlayerCommand(new Light(), new MusicPlayer());
    button = new Button(command);
    button.pressButton();

    command = new PhoneCommand(new Phone(), "Иван");
    button = new Button(command);
    button.pressButton();
  }
}

class Button {
  Command command;

  public Button(Command command) {
    this.command = command;
  }

  public void pressButton() {
    command.execute();
  }
}

interface Command {

  void execute();
}

class Light {
  boolean isOn;

  public void swicthLight() {
    this.isOn = !this.isOn;
    System.out.println("light is " + (isOn ? "on" : "off"));
  }
}

class LightCommand implements Command {
  private Light light;

  public LightCommand(Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    light.swicthLight();
  }
}

class MusicPlayer {

  public void playMusic() {
    System.out.println("play music");
  }
}

class MusicPlayerCommand implements Command {
  private MusicPlayer musicPlayer;

  public MusicPlayerCommand(MusicPlayer musicPlayer) {
    this.musicPlayer = musicPlayer;
  }

  @Override
  public void execute() {
    musicPlayer.playMusic();
  }
}

class CoffeeMachine {

  public void makeCoffee() {
    System.out.println("make coffee");
  }
}

class CoffeeMachineCommand implements Command {
  private CoffeeMachine coffeeMachine;

  public CoffeeMachineCommand(CoffeeMachine coffeeMachine) {
    this.coffeeMachine = coffeeMachine;
  }

  @Override
  public void execute() {
    coffeeMachine.makeCoffee();
  }
}

class LightAndMusicPlayerCommand implements Command {
  private Light light;
  private MusicPlayer musicPlayer;

  public LightAndMusicPlayerCommand(Light light, MusicPlayer musicPlayer) {
    this.light = light;
    this.musicPlayer = musicPlayer;
  }

  @Override
  public void execute() {
    light.swicthLight();
    musicPlayer.playMusic();
  }
}

class Phone {

  public void makeCall(String name) {
    System.out.println("male call to " + name);
  }
}

class PhoneCommand implements Command {
  private Phone phone;
  private String name;

  public PhoneCommand(Phone phone, String name) {
    this.phone = phone;
    this.name = name;
  }

  @Override
  public void execute() {
    phone.makeCall(name);
  }
}

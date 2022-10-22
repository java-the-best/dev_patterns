package facade;

public class Main {
  public static void main(String[] args) {
    LivingRoom livingRoom = new LivingRoom();
    livingRoom.pressButton("5", "22");

    BadRoom badRoom = new BadRoom();
    badRoom.pressButton("10", "15");
  }
}

class RoomFacade {
  Tv tv = new Tv();
  AirConditioning airConditioning = new AirConditioning();
  Light light = new Light();

  public void pressButton(String channel, String temperature) {
    tv.playChannel(channel);
    airConditioning.setTemperature(temperature);
    light.turnLight();
  }
}

class LivingRoom {

  private RoomFacade roomFacade = new RoomFacade();

  public void pressButton(String channel, String temperature) {
    roomFacade.pressButton(channel, temperature);
  }
}

class BadRoom {

  private RoomFacade roomFacade = new RoomFacade();

  public void pressButton(String channel, String temperature) {
    roomFacade.pressButton(channel, temperature);
  }
}

class AirConditioning {

  public void setTemperature(String temperature) {
    System.out.println("set temperature " + temperature);
  }
}

class Light {

  public void turnLight() {
    System.out.println("turn light");
  }
}

class Tv {

  public void playChannel(String channel) {
    System.out.println("play channel " + channel);
  }
}

package adapter;

public class Main {
  public static void main(String[] args) {
    AmericanSocket socket = new SimpleAmericanSocketImpl();
    Radio radio = new Radio();
    EuroSocket euroSocket = new SocketAdapter(socket);
    radio.listenMusic(euroSocket);
  }
}

interface EuroSocket {
  void getPower();
}

interface AmericanSocket {
  void getPower();
}

class SimpleAmericanSocketImpl implements AmericanSocket {
  @Override
  public void getPower() {
    System.out.println("americanSocket");
  }
}

class Radio {
  public void listenMusic(EuroSocket euroSocket) {
    euroSocket.getPower();
  }
}

class SocketAdapter implements EuroSocket {
  private AmericanSocket americanSocket;

  public SocketAdapter(AmericanSocket americanSocket) {
    this.americanSocket = americanSocket;
  }

  @Override
  public void getPower() {
    americanSocket.getPower();
  }
}

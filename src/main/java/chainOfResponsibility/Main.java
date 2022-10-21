package chainOfResponsibility;

public class Main {
  public static void main(String[] args) {
    MessageHandler messageHandler = new MessageAddExclamationMarkHandler(
        new MessageVerifyHandler(new MessagePrintHandler(null)));
    messageHandler.handle("hello world");
  }
}

abstract class MessageHandler {
  MessageHandler messageHandler;

  public MessageHandler(MessageHandler messageHandler) {
    this.messageHandler = messageHandler;
  }

  public abstract void handle(String message);
}

class MessagePrintHandler extends MessageHandler {

  public MessagePrintHandler(MessageHandler messageHandler) {
    super(messageHandler);
  }

  @Override
  public void handle(String message) {
    System.out.println(message);
  }
}

class MessageVerifyHandler extends MessageHandler {

  public MessageVerifyHandler(MessageHandler messageHandler) {
    super(messageHandler);
  }

  @Override
  public void handle(String message) {
    if (!message.matches(".*\\d.*")) {
      System.out.println(message);
    }
  }
}

class MessageAddExclamationMarkHandler extends MessageHandler {

  public MessageAddExclamationMarkHandler(MessageHandler messageHandler) {
    super(messageHandler);
  }

  @Override
  public void handle(String message) {
    System.out.println(message + "!");
  }
}

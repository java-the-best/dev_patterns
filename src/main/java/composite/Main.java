package composite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    Folder users = new Folder("users");
    Folder etc = new Folder("etc");
    Folder root = new Folder("root");
    root.addFolder(users, etc);

    Folder mike = new Folder("Mike");
    Folder kent = new Folder("Kent");
    Folder max = new Folder("Max");
    users.addFolder(mike, kent, max);

    Folder one = new Folder("one");
    Folder two = new Folder("two");
    Folder three = new Folder("three");
    mike.addFolder(one, two, three);

    root.printFolders();
  }
}

class Folder {
  private String name;

  public Folder(String name) {
    this.name = name;
  }

  private List<Folder> list = new ArrayList<>();

  public void addFolder(Folder folder) {
    list.add(folder);
  }

  public void addFolder(Folder... folder) {
    list.addAll(Arrays.asList(folder));
  }

  public void printFolders() {
    for (Folder folder : list) {
      System.out.println(folder.name);
      folder.printFolders();
    }
  }
}

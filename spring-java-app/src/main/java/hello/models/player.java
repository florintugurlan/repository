package hello;

import java.util.List;
import java.util.ArrayList;

public class player {
  private String name;
  private int id;

  public player() {}

  public player(int id, String name) {
      this.name = name;
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

public void setNume(String name) {
       this.name = name;
   }

 public void setid(int id) {
      this.id = id;
   }

  public int getId() {
    return this.id;
  }
}
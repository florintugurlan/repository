package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;


@RestController
public class playercontroller {
  private List<player> Barcelona = new ArrayList<player>();

  playercontroller() {
    player p1 = new player(1, "Messi");
    player p2 = new player(2, "Iniesta");
    player p3 = new player(3, "Neymar");

    Barcelona.add(p1);
    Barcelona.add(p2);
    Barcelona.add(p3);
  }

  @RequestMapping(value="/player", method = RequestMethod.GET)
  public List<player> index() {
    return this.Barcelona;
  }

  @RequestMapping(value="/player/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(player p : this.Barcelona) {
      if(p.getId() == id) {
        return new ResponseEntity<player>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/player/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(player p : this.Barcelona) {
      if(p.getId() == id) {
        this.Barcelona.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


    @RequestMapping(value="/player/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("id") int id) {
        for(player p : this.Barcelona) {
            if(p.getId() == id) {
                p.setNume("playerNou");
                p.setid(1);

                return new ResponseEntity<player>(p, new HttpHeaders(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
   }

    @RequestMapping(value="/p", method = RequestMethod.POST)
    public ResponseEntity create() {
		int size = this.Barcelona.size();
        player p = new player(size+1,"Suarez");
        this.Barcelona.add(p);
        return new ResponseEntity<player>(p, new HttpHeaders(), HttpStatus.OK);
    }


}
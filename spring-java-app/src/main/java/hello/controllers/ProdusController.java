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
public class ProdusController {
  private List<Produs> Produse = new ArrayList<Produs>();

  ProdusController() {
    Produs p1 = new Produs(1, "Lapte");
    Produs p2 = new Produs(2, "Paine");
    Produs p3 = new Produs(3, "Ulei");

    Produse.add(p1);
    Produse.add(p2);
    Produse.add(p3);
  }

  @RequestMapping(value="/produs", method = RequestMethod.GET)
  public List<Produs> index() {
    return this.Produse;
  }

  @RequestMapping(value="/produs/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(Produs p : this.Produse) {
      if(p.getId() == id) {
        return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/produs/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(Produs p : this.Produse) {
      if(p.getId() == id) {
        this.Produse.remove(p);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }


    @RequestMapping(value="/produs/{id}", method = RequestMethod.PUT)
    public ResponseEntity update(@PathVariable("id") int id) {
        for(Produs p : this.Produse) {
            if(p.getId() == id) {
                p.setNume("ProdusNou");
                p.setid(1);

                return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
   }

    @RequestMapping(value="/p", method = RequestMethod.POST)
    public ResponseEntity create() {
		int size = this.Produse.size();
        Produs p = new Produs(size+1,"Branza");
        this.Produse.add(p);
        return new ResponseEntity<Produs>(p, new HttpHeaders(), HttpStatus.OK);
    }


}
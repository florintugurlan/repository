

package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.ArrayList;

  @RestController
  public class ProdusController {
    private List<Produs> produse = new ArrayList<Produs>();

    ProdusController() {
      Produs pr1 = new Produs(1, "Lapte");
      Produs pr2 = new Produs(2, "Paine");
      Produs pr3 = new Produs(3, "Ulei");

      produse.add(pr1);
      produse.add(pr2);
      produse.add(pr3);
    }

    @RequestMapping(value="/produs", method = RequestMethod.GET)
    public List<Produs> index() {
      return this.produse;
    }

    @RequestMapping(value="/produs/{id}", method = RequestMethod.GET)
    public ResponseEntity show(@PathVariable("id") int id) {
      for(Produs pr : this.produse) {
        if(pr.getId() == id) {
          return new ResponseEntity<Produs>(pr, new HttpHeaders(), HttpStatus.OK);
        }
      }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/produs/{id}", method = RequestMethod.DELETE)
    public ResponseEntity remove(@PathVariable("id") int id) {
      for(Produs pr : this.produse) {
        if(pr.getId() == id) {
          this.produse.remove(pr);
            return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
        }
      }
      return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value="/produs/{id}",method=RequestMethod.PUT)
    public ResponseEntity update(@RequestBody Produs a) {
      
      this.produse.set(a.getId()-1,a);
      return new ResponseEntity<Produs>(a, new HttpHeaders(), HttpStatus.OK);
    }


    @RequestMapping(value="/produs",method=RequestMethod.POST)
    public ResponseEntity create(@RequestBody Produs a) {
      this.produse.add(a);
      return new ResponseEntity<Produs>(a, new HttpHeaders(), HttpStatus.OK);
    }
  }

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
public class facultatecontroller {
  private List<facultate> Politehnica = new ArrayList<facultate>();

  facultatecontroller() {
    facultate f1 = new facultate(1, "Automatica si Calculatoare");
    facultate f2 = new facultate(2, "IMST");
    facultate f3 = new facultate(3, "Transporturi");

    Politehnica.add(f1);
    Politehnica.add(f2);
    Politehnica.add(f3);
  }

  @RequestMapping(value="/facultate", method = RequestMethod.GET)
  public List<facultate> index() {
    return this.Politehnica;
  }

  @RequestMapping(value="/facultate/{id}", method = RequestMethod.GET)
  public ResponseEntity show(@PathVariable("id") int id) {
    for(facultate f : this.Politehnica) {
      if(f.getId() == id) {
        return new ResponseEntity<facultate>(f, new HttpHeaders(), HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/facultate/{id}", method = RequestMethod.DELETE)
  public ResponseEntity remove(@PathVariable("id") int id) {
    for(facultate f : this.Politehnica) {
      if(f.getId() == id) {
        this.Politehnica.remove(f);
        return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NO_CONTENT);
      }
    }
    return new ResponseEntity<String>(null, new HttpHeaders(), HttpStatus.NOT_FOUND);
  }

  @RequestMapping(value="/facultate/{id}",method=RequestMethod.PUT)
    
    public ResponseEntity update(@RequestBody facultate a){
      this.Politehnica.set(a.getId() - 1, a);
      return new ResponseEntity<facultate>(a, new HttpHeaders(), HttpStatus.OK);
    }

  @RequestMapping(value="/facultate",method=RequestMethod.POST)
      public ResponseEntity create(@RequestBody facultate a) {
        this.Politehnica.add(a);
        return new ResponseEntity<facultate>(a, new HttpHeaders(), HttpStatus.OK);
     }
   }
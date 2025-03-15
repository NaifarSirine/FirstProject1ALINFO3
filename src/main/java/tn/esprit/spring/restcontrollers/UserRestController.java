package tn.esprit.spring.restcontrollers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IUserService;

import java.util.List;

@RestController// ou @Component
@RequestMapping("UserRestController") // Pour personnaliser l'accès au web service implémenté dans cette classe
@Tag(name = "Gestion des utilisateurs") // Pour changer le nom affiché dans swagger
@AllArgsConstructor
public class UserRestController {

    IUserService userService;
    // GET(Récuperation),POST(Création),PUT(Modification),
    // DELETE(Suppression)

    // @RequestBody : Pour passer en paramètre un objet JSON/ une liste d'objet JSON
    // @RequestParam et @PathVariable : Pour passer en paramètre une valeur, une liste de String, int, ...

    //    public UserRestController(IUserService userService) {
    //        this.userService = userService;
    //    }

    @GetMapping("helloWorld")
    @Operation(description = "Cette méthode permet d'afficher un message de test") // Pour une description
    public String helloWorld() {
        return "Hello from Spring";
    }

    @GetMapping("helloWorld2")
    public String helloWorld2(@RequestBody List<String> names) {
        return "Hello" + names.toString();
    }

    //.../helloWorld5/NAIFAR,Sirine (',' est le séparateur entre les valeurs de la liste)
    @GetMapping("helloWorld5/{names}")
    public String helloWorld5(@PathVariable List<String> names) {
        return "Hello" + names.toString();
    }

    //.../helloWorld6?names=NAIFAR,Sirine (',' est le séparateur entre les valeurs de la liste)
    @GetMapping("helloWorld6")
    public String helloWorld6(@RequestParam List<String> names) {
        return "Hello" + names.toString();
    }

    //.../helloWorld3/NAIFAR/Sirine
    @GetMapping("helloWorld3")
    public String helloWorld3(@RequestParam String nom, @RequestParam String prenom) {
        return "Hello" + nom + " " + prenom;
    }

    //.../helloWorld4?nom=NAIFAR&prenom=Sirine
    @GetMapping("helloWorld4/{nom}/{prenom}")
    public String helloWorld4(@PathVariable String nom, @PathVariable String prenom) {
        return "Hello" + nom + " " + prenom;
    }

    @PostMapping("add")
    public User add(@RequestBody User user) {
        return userService.add(user);
    }

    @PostMapping("addAll")
    public List<User> addAll(@RequestBody List<User> users) {
        return userService.addAll(users);
    }


    @DeleteMapping("delete")
    public void delete(@RequestBody User user) {
        userService.delete(user);
    }

    //.../deleteById?id=1
    @DeleteMapping("deleteById")
    public void deleteById(@RequestParam Long id) {
        userService.deleteById(id);
    }

    //.../deleteById2/2
    @DeleteMapping("deleteById2/{id}")
    public void deleteById2(@PathVariable Long id) {
        userService.deleteById(id);
    }


}

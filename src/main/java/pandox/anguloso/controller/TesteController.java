package pandox.anguloso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pandox.anguloso.dto.AngularRequest;

@Controller
@RequestMapping("/teste")
public class TesteController {

    @Autowired
    private MongoOperations operations;


    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AngularRequest persist(@RequestBody AngularRequest request) {

        operations.save(request, "request");


        return request;
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {

        return "redirect:/pages/anguloso.html";
    }





}

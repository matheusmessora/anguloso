package pandox.anguloso.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pandox.anguloso.dto.AngularRequest;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/teste")
public class TesteController {

    public static Map<String, AngularRequest> database = new HashMap<String, AngularRequest>();


    @RequestMapping(value = "", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Collection<AngularRequest> persist(@RequestBody AngularRequest request) {

        // UPDATE
        if(database.containsKey(request.getPath())) {
            AngularRequest angularRequest = database.get(request.getPath());

            angularRequest.setHttpStatus(request.getHttpStatus());
            angularRequest.setJson(request.getJson());
            angularRequest.setResponseDate(request.getResponseDate());
        }else {
            database.put(request.getPath(), request);
        }


        return database.values();
    }


    @RequestMapping(value = "", method = RequestMethod.GET)
    public String index() {

        return "redirect:/pages/anguloso.html";
    }


}

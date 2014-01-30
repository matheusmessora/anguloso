package pandox.anguloso.controller;

import org.apache.log4j.Logger;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 *
 *
 */
@Controller
public class SocketController {


    Logger log = Logger.getLogger(SocketController.class);

    @MessageMapping("/opa")
//    @SendTo("/topic/greetings")
    public HelloMessage greeting(HelloMessage message) throws Exception {
        System.out.println("CHEGOU MENSAGEM!!!!. message = " + message);
        Thread.sleep(100); // simulated delay
//        return new Greeting("Hello, " + message.getName() + "!");

        log.debug("CHEGOU MENSAGEM." + message);
        HelloMessage hello = new HelloMessage();
        hello.setName("A" + message.getName().toUpperCase());

        return hello;
    }

}

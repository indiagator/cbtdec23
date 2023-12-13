package com.example.cbtdec23;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class MainRestController
{
    @Autowired //dependency injection
    CredentialRepository credentialRepository;

    @GetMapping("greet")
    public ResponseEntity<String> greet()
    {
        return ResponseEntity.ok("Hello, We are learning to build" +
                " a monolithic rest api backend using spring");
    }

    @PostMapping("signup")
    public ResponseEntity<String> signup(@RequestParam("username") String username, @RequestParam("password") String password)
    {
        Credential credential = new Credential();
        credential.setUsername(username);
        credential.setPassword(password);

        credentialRepository.save(credential);

        return ResponseEntity.ok("New Signup Successful");
    }

}

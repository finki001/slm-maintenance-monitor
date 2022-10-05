package at.fhtw.slmmaintenancemonitor.controller;

import at.fhtw.slmmaintenancemonitor.service.StatusService;
import org.springframework.web.bind.annotation.*;

@RestController
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("message")
    public String getMessage() {
        return statusService.getMessage();
    }

    @PutMapping("message")
    public void setMessage(@RequestParam String message) {
        statusService.setMessage(message);
    }

    @PutMapping("reset")
    public void resetMessage() {
        statusService.setMessage(null);
    }
}

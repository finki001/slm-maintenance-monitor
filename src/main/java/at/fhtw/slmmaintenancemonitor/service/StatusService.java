package at.fhtw.slmmaintenancemonitor.service;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    @Nullable
    private String message = null;

    @Nullable
    public String getMessage() {
        return message;
    }

    public void setMessage(@Nullable String message) {
        this.message = message;
    }
}

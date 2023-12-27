package com.zingleside.urbanbusinesssystem.advertising;

import com.zingleside.urbanbusinesssystem.advertising.entity.Advertising;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AdvertisingController {

    private final AdvertisingJDBCDateAccess advertisingJDBCDateAccess;

    public AdvertisingController(AdvertisingJDBCDateAccess advertisingJDBCDateAccess) {
        this.advertisingJDBCDateAccess = advertisingJDBCDateAccess;
    }

    @GetMapping("/advertising")
    List<Advertising> getAll() {
        return advertisingJDBCDateAccess.selectALlAdvertising();
    }

    @PostMapping("/advertising")
    Advertising insertAdvertising(@RequestBody Advertising advertising) {
        return advertisingJDBCDateAccess.insertAdvertising(advertising);
    }
}

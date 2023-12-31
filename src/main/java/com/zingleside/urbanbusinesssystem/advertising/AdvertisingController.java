package com.zingleside.urbanbusinesssystem.advertising;

import com.zingleside.urbanbusinesssystem.advertising.entity.Advertising;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Tag(name ="advertising manager")
public class AdvertisingController {

    private final AdvertisingJDBCDateAccess advertisingJDBCDateAccess;

    public AdvertisingController(AdvertisingJDBCDateAccess advertisingJDBCDateAccess) {
        this.advertisingJDBCDateAccess = advertisingJDBCDateAccess;
    }

    @GetMapping("/advertising")
    List<Advertising> getAll() {
        return advertisingJDBCDateAccess.selectALlAdvertising();
    }


    @GetMapping("/advertising/id")
    Optional<Advertising> selectByID(Long id){
        return advertisingJDBCDateAccess.selectAdvertisingByID(id);
    }

    @PostMapping("/advertising")
    Advertising insertAdvertising(@RequestBody Advertising advertising) {
        return advertisingJDBCDateAccess.insertAdvertising(advertising);
    }
}

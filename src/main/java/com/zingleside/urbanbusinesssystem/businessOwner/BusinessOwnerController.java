package com.zingleside.urbanbusinesssystem.businessOwner;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Businesses Manager")
public class BusinessOwnerController {
    private final BusinessOwnerService businessOwnerService;

    public BusinessOwnerController(BusinessOwnerService businessOwnerService) {
        this.businessOwnerService = businessOwnerService;
    }

    @GetMapping("/business")
    @Operation(description = "this apit returns businesses")
    List<BusinessOwner> getbusinessOwner(@RequestParam(required = false, value = "owner-name") String ownerName) {
        return businessOwnerService.getbusinessOwner();
    }

    @PostMapping("/business")
    void createNewBusinessOwner(@RequestBody BusinessOwner businessOwner){
        System.out.println("post request");
        System.out.println(businessOwner);
    }

    @PutMapping
    void updateNewBusinessOwner(@RequestBody BusinessOwner businessOwner){
        System.out.println("update request");
        System.out.println(businessOwner);
    }

    @DeleteMapping("{BusinessOwnerID}")
    void deleteBusinessOwner(@PathVariable("{BusinessOwnerID}") Integer id){
        System.out.println("delete request for id"+ id  );
    }


}

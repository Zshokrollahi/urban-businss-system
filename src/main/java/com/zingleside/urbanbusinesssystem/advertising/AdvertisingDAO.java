package com.zingleside.urbanbusinesssystem.advertising;

import com.zingleside.urbanbusinesssystem.advertising.entity.Advertising;

import java.util.List;
import java.util.Optional;

public interface AdvertisingDAO {

    List<Advertising> selectALlAdvertising();

    Optional<Advertising> selectAdvertisingByID(Long id);

    Advertising insertAdvertising(Advertising advertising);

}

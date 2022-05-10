package ru.service.shelter.services;

import org.springframework.stereotype.Component;
import ru.service.shelter.entity.AnimalGender;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GenderServiceImpl implements GenderService{
    @Override
    public Map<String, String> getMapGender() {
        return  Arrays.stream(AnimalGender.values())
                .collect(Collectors.toMap(e->e.name(), AnimalGender::getTitle));
    }
}

package repositories;

import models.Gate;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class GateRepository {

    private final Map<Integer, Gate> gateMap;
    private static int countId = 0;

    public GateRepository(){
        this.gateMap = new HashMap<>();
    }

    public Optional<Gate> findById(int gateId){
        if(gateMap.containsKey(gateId)){
            return Optional.of(gateMap.get(gateId));
        }
        return Optional.empty();
    }

    public Gate save(Gate gate){
        if(gate.getId() == 0){
            gate.setId(++countId);
        }
        gateMap.put(gate.getId(), gate);
        return gate;
    }
}

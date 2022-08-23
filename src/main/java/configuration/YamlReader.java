package configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.extern.slf4j.Slf4j;
import model.EnvironmentStructure;
import model.Pojo;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
public class YamlReader {

    public static Pojo getProperties(){
        final ObjectMapper om = new ObjectMapper(new YAMLFactory());
        try{
            return om.readValue(new File(System.getProperty("user.dir")+ "\\src\\main\\resources\\properties.yaml"),Pojo.class);
        } catch (IOException e){
            log.error("Can not read the properties due to IOException");
        }
        return null;
    }

    public static void setPropertiesFromYAML(){
        List<EnvironmentStructure> list = getProperties().getEnvironments().listOfEnvironments();
        boolean active  = false;
        for (EnvironmentStructure e : list){
            if(e.isActive()){
                active = true;
                Map<String,Object> environmentProperties = e.getStructure();
                for(Map.Entry map :  environmentProperties.entrySet()){
                    System.setProperty(map.getKey().toString(),map.getValue().toString());
                    log.info("Loaded environment property: {} - {}",map.getKey().toString(),map.getValue().toString());
                }
                log.info("Loaded environment properties total: {}", environmentProperties.size());
                break;
            }
        }
    }
}

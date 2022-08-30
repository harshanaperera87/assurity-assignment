package model.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDetails {

    @JsonProperty("Name")
    private String name;
    @JsonProperty("CanRelist")
    private Boolean canRelist;
    @JsonProperty("Promotions")
    private List<Promotion> promotions;
}


package org.mule.examples.oauth2connectorexample.entities;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({
    "lists"
})
public class Response {

    @JsonProperty("lists")
    private Lists lists;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("lists")
    public Lists getLists() {
        return lists;
    }

    @JsonProperty("lists")
    public void setLists(Lists lists) {
        this.lists = lists;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}

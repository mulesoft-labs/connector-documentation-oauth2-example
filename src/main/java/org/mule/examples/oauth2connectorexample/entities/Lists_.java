
package org.mule.examples.oauth2connectorexample.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "groups"
})
public class Lists_ {

    @JsonProperty("groups")
    private List<Group_> groups = new ArrayList<Group_>();
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("groups")
    public List<Group_> getGroups() {
        return groups;
    }

    @JsonProperty("groups")
    public void setGroups(List<Group_> groups) {
        this.groups = groups;
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


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
    "unreadCount"
})
public class Item {

    @JsonProperty("unreadCount")
    private Integer unreadCount;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("unreadCount")
    public Integer getUnreadCount() {
        return unreadCount;
    }

    @JsonProperty("unreadCount")
    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
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

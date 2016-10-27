package com.adatar.qp.conf;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class QPConfiguration extends Configuration {

    @NotEmpty
    String qualifierDataPath;

    @JsonProperty
    public String getQualifierDataPath() {
        return qualifierDataPath;
    }

    @JsonProperty
    public void setQualifierDataPath(String qualifierDataPath) {
        this.qualifierDataPath = qualifierDataPath;
    }
}

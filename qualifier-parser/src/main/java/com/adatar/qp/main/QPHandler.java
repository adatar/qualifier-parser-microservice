package com.adatar.qp.main;

import com.adatar.qp.cache.CacheManager;
import com.adatar.qp.parser.QualifierParserComponent;
import com.adatar.qp.response.ServiceResponse;
import com.codahale.metrics.annotation.Timed;
import org.hibernate.validator.constraints.NotEmpty;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/qualifiers")
@Produces(MediaType.APPLICATION_JSON)
public class QPHandler {

    @GET
    @Timed
    public ServiceResponse parseQuery(@QueryParam("q") @NotEmpty String q){

        ServiceResponse response = new CacheManager().get(q);

        if(response == null)
            response = new QualifierParserComponent().parse(q);

        return response;
    }
}

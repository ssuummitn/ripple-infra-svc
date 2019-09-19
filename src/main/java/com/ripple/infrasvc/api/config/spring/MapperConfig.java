package com.ripple.infrasvc.api.config.spring;


import com.ripple.infrasvc.api.mapper.ApiServiceMapper;
import com.ripple.infrasvc.service.mappers.ServiceDalMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sumit.nagariya on 18/09/19.
 */
@Configuration
public class MapperConfig {
    @Bean
    public ApiServiceMapper apiServiceMapper() {
        return Mappers.getMapper(ApiServiceMapper.class);
    }

    @Bean
    public ServiceDalMapper serviceDalMapper() {
        return Mappers.getMapper(ServiceDalMapper.class);
    }

}

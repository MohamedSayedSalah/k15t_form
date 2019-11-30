package com.k15t.pat.registration.mappers;

import com.k15t.pat.registration.models.User;
import io.swagger.model.UserDetails;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    User mapFromUserDetailsDtoToUser(UserDetails userDetails);
}






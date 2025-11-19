package edu.txts.pj191125.mapper;

import edu.txts.pj191125.dto.request.UserCreate;
import edu.txts.pj191125.dto.request.UserUpdate;
import edu.txts.pj191125.dto.response.UserResponse;
import edu.txts.pj191125.entity.RUser;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 19 Nov 2025 12:53
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/
@Mapper(componentModel = "spring")
public interface RUserMapper {
	RUser toRUser(UserCreate userCreate);
	UserResponse toUserResponse(RUser rUser);
	void updateRUser(@MappingTarget RUser rUser, UserUpdate userUpdate);
}

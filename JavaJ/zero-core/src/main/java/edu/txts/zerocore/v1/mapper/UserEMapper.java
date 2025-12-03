package edu.txts.zerocore.v1.mapper;

import edu.txts.zerocore.v1.dto.request.UserECreate;
import edu.txts.zerocore.v1.dto.request.UserEUpdate;
import edu.txts.zerocore.v1.dto.response.UserEResponse;
import edu.txts.zerocore.v1.entity.UserE;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

/*******************************************************************************
 * CODE NÀY VIẾT RA KHÔNG PHẢI ĐỂ HIỂU – MÀ ĐỂ KHIẾN NGƯỜI KHÁC KHÓC THÉT.
 * Author   : TXTsG7
 * Created  : 03 Dec 2025 10:12
 * Org      : Republic of Bugs - Where Bugs Are Born!!!
 ******************************************************************************/
@Mapper(componentModel = "spring")
public interface UserEMapper {
	UserEResponse toUserEResponse(UserE userE);
	UserE toUserE(UserEResponse userEResponse);
	UserE toUserE(UserECreate userECreate);
	void updateUserE(@MappingTarget UserE userE, UserEUpdate userEUpdate );
}

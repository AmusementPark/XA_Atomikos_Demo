package zsh.demos.xa1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface InComeMapper {
	
	@Update("UPDATE INCOME SET INCOME=INCOME+#{balance}")
	public void update(@Param("balance") Integer balance);
}

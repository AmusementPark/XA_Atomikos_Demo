package zsh.demos.xa0.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

/**
 * For Balance Table
 * @author SimonZhu
 *
 */
@Mapper
public interface BalanceMapper {
	
	@Update("UPDATE BALANCE SET BALANCE=BALANCE-#{balance}")
	public void update(@Param("balance") Integer balance);
}

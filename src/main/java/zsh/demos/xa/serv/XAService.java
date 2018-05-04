package zsh.demos.xa.serv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zsh.demos.xa0.mapper.BalanceMapper;
import zsh.demos.xa1.mapper.InComeMapper;

@Service
public class XAService {
	
	@Autowired
	private BalanceMapper balanceMapper;
	
	@Autowired
	private InComeMapper incomeMapper;
	
	@Transactional(rollbackFor=Exception.class)
	public void doTransaction() {
		balanceMapper.update(100);
		incomeMapper.update(100);
		int y = 10/0;
		System.err.println(y);
		return;
	}
}

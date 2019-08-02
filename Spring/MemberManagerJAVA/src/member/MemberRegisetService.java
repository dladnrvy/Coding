package member;

import java.util.Date;

public class MemberRegisetService {

	private MemberDao memberDao;
	
	public MemberRegisetService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void register(RegisterRequest request) throws AleadyExistingMemberException {
		Member member = memberDao.selectByEmail(request.getEmail());
		
		if(member != null) {
			throw new AleadyExistingMemberException();
		}
		
		Member newMember = new Member(
				request.getEmail(),
				request.getPassword(),
				request.getName(),
				new Date());
		
		memberDao.insert(newMember);
	}
}
